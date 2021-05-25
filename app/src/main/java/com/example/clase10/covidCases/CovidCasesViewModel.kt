package com.example.clase10.covidCases

import android.app.Application
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.clase10.MainActivity
import com.example.clase10.model.CovidCaseEntityMapper
import com.example.clase10.model.CovidCaseModel
import com.example.clase10.model.CovidCasesDao
import com.example.clase10.model.DatabaseRepository
import com.example.clase10.navigation.Navigator
import com.example.clase10.networking.CovidCaseRepository
import com.example.clase10.networking.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class CovidCasesViewModel(application: Application) : AndroidViewModel(application) {

    var cases: List<CovidCaseModel> = listOf()
    val caseList = mutableListOf<CovidCaseModel>()
    val myCases = MutableLiveData<MutableList<CovidCaseModel>>()
    val selectedCase = MutableLiveData<CovidCaseModel>()
    val favoritesCountries = MutableLiveData<MutableList<CovidCaseModel>>()
    lateinit var navigator: Navigator
    var database: CovidCasesDao

    // Ya que AsyncTask esta deprecado utilizaremos esta forma. Y como vamos a hacer lectura y escritura en mas de un lado es mejor crearla aca
    private val executor: ExecutorService = Executors.newSingleThreadExecutor()
    private val handler = Handler(Looper.getMainLooper())


    init {
        val service = getRetrofit().create(CovidCaseRepository::class.java)
        val call = service.getCountriesCovidCases()
        database = DatabaseRepository(application).getCovidCaseDao()
        call.enqueue(object : Callback<List<CovidCaseModel>> {
             override fun onResponse(
                     call: Call<List<CovidCaseModel>>,
                     response: Response<List<CovidCaseModel>>
             ) {
                  val body = response.body()
                  if (body != null) {
                       //En la clases se vio AstncTask pero esta deprecado desde API 30 esta es una nueva forma de hacerlo.
                       executor.execute {
                            body.forEach {
                                database.insertCase(CovidCaseEntityMapper().mapToCached(it))
                            }
                           loadCases()
                       }
                  }
             }

             override fun onFailure(call: Call<List<CovidCaseModel>>, t: Throwable) {
                  println(t.message)
             }

        })
    }

    fun loadCases() {
        executor.execute {
            cases = database.getAllCases().map {
                CovidCaseEntityMapper().mapFromCached(it)
            }
            myCases.postValue(cases.toMutableList())
        }
    }

    fun setNavigator(activity: MainActivity?) {
        navigator = Navigator(activity)
    }

    fun selectCase(item: CovidCaseModel) {
        selectedCase.postValue(item)
    }

    fun addCase(item: CovidCaseModel) {
        var tempList = favoritesCountries.value ?: mutableListOf<CovidCaseModel>()
        tempList?.add(item)
        favoritesCountries.postValue(tempList)
    }


}