package com.karima.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.konaly.japerdiaconta.R
import com.konaly.japerdiaconta.model.Produto
import com.konaly.japerdiaconta.model.ProdutoItem
import kotlinx.android.synthetic.main.item.view.*


class ProductsAdapter(private var produtos: Produto, private val context: Context, private val onItemClickListener: (product: ProdutoItem, position: Int) -> Unit) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = produtos.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val produto = this.produtos[position]
        holder.bindView(produto, context)
        holder.itemView.setOnClickListener {
            onItemClickListener(produto, position)
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(produto: ProdutoItem, context: Context) {
            Glide.with(context)
                .load(produto.path_thumb)
                .into(itemView.image_produto)
            itemView.text_nome.text = produto.nome
            itemView.text_descricao.text = produto.descricao
            itemView.text_valor.text = produto.valor_unitario

        }

    }

    fun getList(): Produto {
        return produtos
    }

    fun addAll(products: Produto) {
        this.produtos.clear()
        this.produtos.addAll(products)
        notifyDataSetChanged()
    }

    fun add(produto: ProdutoItem) {
        this.produtos.add(produto)
        notifyDataSetChanged()
    }

//
//    fun update(product: Product, position: Int) {
//        this.products.add(position, product)
//        notifyItemChanged(position)
//    }
//
//    private fun delete(position: Int) {
//        this.products.removeAt(position)
//        notifyDataSetChanged()
//    }
}

