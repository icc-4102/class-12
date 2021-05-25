package com.example.clase10

interface IAdapterView{
    fun addItem(item: Any)
    val onClickListener: OnClickListener
}