package com.example.clase10.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//Este metodo los va a ayudar a debugear las request que hacen
private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = if (isDebug)
        HttpLoggingInterceptor.Level.BODY
    else
        HttpLoggingInterceptor.Level.NONE
    return logging
}
//Este es el cliente que funciona por detras de retrofit
private fun getOkClient(): OkHttpClient {
    return OkHttpClient()
            .newBuilder()
            .addInterceptor(makeLoggingInterceptor(isDebug = true))
            .build()
}


fun getRetrofit(): Retrofit {
    val retrofit = Retrofit.Builder().baseUrl("https://corona.lmao.ninja/v2/")
            .client(getOkClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    return retrofit
}
