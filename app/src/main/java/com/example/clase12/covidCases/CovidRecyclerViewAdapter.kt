package com.example.clase10.covidCases

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clase10.CovidCase
import com.example.clase10.IAdapterView
import com.example.clase10.OnClickListener
import com.example.clase10.R
import com.example.clase10.extensions.loadImage
import com.example.clase10.model.CovidCaseModel

class CovidRecyclerViewAdapter(override val onClickListener: OnClickListener):
        RecyclerView.Adapter<CovidRecyclerViewAdapter.CovidViewHolder>(), IAdapterView {

    var data = listOf<CovidCaseModel>()


    //Metodo donde crear el layout de la celda a ver
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.covid_view_holder,parent, false)
        return CovidViewHolder(view)
    }

    // Metodo que entrega información al viewHolder
    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
        val item = data[position]
        holder.bindView(item)
        //Se aplica la interfaz entregada en este caso por la MainActivity
        holder.itemView.setOnClickListener {
            onClickListener.onClickItem(item)
        }
    }
    // Metodo que define el largo de la lista
    override fun getItemCount(): Int {
        return data.size
    }
    // Metodo donde agrega un item al recyclerView
    override fun addItem(item: Any) {
        if(item is CovidCase){
//            data.add(item)
            notifyDataSetChanged()
        }
        this.notifyDataSetChanged()
    }

    //Este metodo utiliza la lista que le entrega el viewmodel
    fun set(cases: List<CovidCaseModel>){
        this.data = cases
        this.notifyDataSetChanged()
    }


    // Clase interna con la definición del ViewHolder
    inner class CovidViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        fun bindView(item: CovidCaseModel){
            val flagIamgeView = view.findViewById<ImageView>(R.id.flag_imageView)
            val countryTextView = view.findViewById<TextView>(R.id.country_text_view)
            val positiveTextView = view.findViewById<TextView>(R.id.positive_text_view)
            val negativeTextView = view.findViewById<TextView>(R.id.negative_text_view)
            flagIamgeView.loadImage(item.countryInfo.flag)
            countryTextView.text = item.country
            positiveTextView.text = item.active.toString()
            negativeTextView.text = item.deaths.toString()

        }
    }

}