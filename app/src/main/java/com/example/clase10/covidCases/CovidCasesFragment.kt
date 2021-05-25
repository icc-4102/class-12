package com.example.clase10.covidCases

import android.os.Bundle
import android.view.*
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clase10.*
import com.example.clase10.model.CovidCaseModel

class CovidCasesFragment : Fragment(), OnClickListener {


    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CovidRecyclerViewAdapter
    private val viewModel: CovidCasesViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(activity as MainActivity)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.favorites, menu)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_covid_casses, container, false)
        viewModel.loadCases()
        adapter = CovidRecyclerViewAdapter(this)
        recyclerView = view.findViewById<RecyclerView>(R.id.covid_recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
        viewModel.myCases.observe(viewLifecycleOwner, Observer {
            adapter.set(it)
        })
        return view
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favorites -> viewModel.navigator.navigateToFavorites()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClickItem(item: Any) {
        if (item is CovidCaseModel) {
            viewModel.selectCase(item)
            viewModel.navigator.navigateToDetail(item.country)
        }
    }

}