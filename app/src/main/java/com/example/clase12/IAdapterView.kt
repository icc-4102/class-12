package com.example.clase12

interface IAdapterView{
    fun addItem(item: Any)
    val onClickListener: OnClickListener
}