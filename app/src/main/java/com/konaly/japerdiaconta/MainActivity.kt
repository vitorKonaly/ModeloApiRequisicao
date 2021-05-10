package com.konaly.japerdiaconta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.konaly.japerdiaconta.model.ApiResponse
import com.konaly.japerdiaconta.model.Produto
import com.konaly.japerdiaconta.model.ProdutoItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val call = RetrofitConfig().produtoApi().list()
        call.enqueue(object : Callback<Produto>{
            override fun onFailure(call: Call<Produto>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Erro",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Produto>, response: Response<Produto>) {
                response.body()
                Toast.makeText(this@MainActivity,"deu boa",Toast.LENGTH_SHORT).show()
            }
        })
    }
}