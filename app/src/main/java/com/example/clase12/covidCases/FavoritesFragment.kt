package com.example.clase10.covidCases

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clase10.OnClickListener
import com.example.clase10.R
import com.example.clase10.model.CovidCaseModel

class FavoritesFragment : Fragment(), OnClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CovidRecyclerViewAdapter
    private val viewModel: CovidCasesViewModel by activityViewModels()


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_covid_casses, container, false)
        adapter = CovidRecyclerViewAdapter(this)
        recyclerView = view.findViewById<RecyclerView>(R.id.covid_recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
        viewModel.favoritesCountries.observe(viewLifecycleOwner, Observer {
            adapter.set(it)
        })
        return view
    }

    override fun onClickItem(item: Any) {
        if (item is CovidCaseModel) {
            viewModel.selectCase(item)
            viewModel.navigator.navigateToDetail(item.country)
        }
    }

}