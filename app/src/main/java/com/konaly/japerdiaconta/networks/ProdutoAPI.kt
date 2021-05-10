package com.konaly.japerdiaconta.networks

import com.konaly.japerdiaconta.model.ApiResponse
import com.konaly.japerdiaconta.model.Produto
import com.konaly.japerdiaconta.model.ProdutoItem
import retrofit2.Call
import retrofit2.http.GET

interface ProdutoAPI {

    @GET("produtos")
    fun list():Call<Produto>

}