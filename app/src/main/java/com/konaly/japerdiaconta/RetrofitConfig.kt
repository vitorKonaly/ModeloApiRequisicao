package com.konaly.japerdiaconta

import com.konaly.japerdiaconta.networks.ProdutoAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitConfig {


       val retrofit = Retrofit.Builder().baseUrl("http://192.168.29.172:80/api/").addConverterFactory(GsonConverterFactory.create()).build()

       fun produtoApi():ProdutoAPI = retrofit.create(ProdutoAPI::class.java)


}