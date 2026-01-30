package com.example.testcase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testcase.R
import com.example.testcase.models.ProductListItem

class ProductAdapter (private val products: List<ProductListItem>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>()  {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item_layout,parent,false)
       return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ProductViewHolder, position: Int) {
        val product = products[position]
        holder.name.text = product.title
        Glide.with(holder.itemView.context).load(product.image).into(holder.image)
    }

    override fun getItemCount(): Int {
        return products.size

    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.productImage)
        val name = itemView.findViewById<TextView>(R.id.productName)

    }


}