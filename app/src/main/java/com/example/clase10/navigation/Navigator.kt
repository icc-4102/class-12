package com.example.clase10.navigation

import androidx.navigation.findNavController
import com.example.clase10.MainActivity
import com.example.clase10.R
import com.example.clase10.covidCases.CovidCasesFragmentDirections

class Navigator(val activity: MainActivity?) {

    fun navigateToDetail(countryId: String){
        val action = CovidCasesFragmentDirections.actionToCovidCaseDetailFragment(countryId)
        activity?.findNavController(R.id.fragment_container)?.navigate(action)
    }

    fun navigateToFavorites(){
        activity?.findNavController(R.id.fragment_container)?.navigate(R.id.action_to_favoritesFragment)
    }

    fun navigateUp(){
        activity?.findNavController(R.id.fragment_container)?.popBackStack()
    }

}