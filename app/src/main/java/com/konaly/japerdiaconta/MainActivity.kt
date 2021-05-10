package com.konaly.japerdiaconta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.karima.retrofit.ProductsAdapter
import com.konaly.japerdiaconta.model.ApiResponse
import com.konaly.japerdiaconta.model.Produto
import com.konaly.japerdiaconta.model.ProdutoItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: ProductsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureRecyclerView()

       val call = RetrofitConfig().produtoApi().list()
        call.enqueue(object : Callback<Produto>{
            override fun onFailure(call: Call<Produto>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Erro",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Produto>, response: Response<Produto>) {
                response.body()?.let {
                    adapter.addAll(it)
                }

                Toast.makeText(this@MainActivity,"deu boa",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun configureRecyclerView() {

        val recyclerView = recyclerView
        adapter = ProductsAdapter(Produto(), this) { produto, position ->
            image_produto.setOnClickListener {

            }
        }
        recyclerView.adapter = adapter
        val layoutManager =LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = layoutManager
    }
}