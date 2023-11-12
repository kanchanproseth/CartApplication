package com.cs473.mda.cartapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cs473.mda.cartapplication.model.Product
import com.cs473.mda.cartapplication.R
import kotlin.Int


class ProductAdapter(productList: List<Product>, context: Context) :
    RecyclerView.Adapter<ProductViewHolder>() {
    private val productList: List<Product>
    private val context: Context
    private val itemClickable: ItemClickable<Product>?

    init {
        this.productList = productList
        this.context = context
        itemClickable = context as? ItemClickable<Product>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.product_item_layout, parent, false)
        return ProductViewHolder(view, this.context)
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product: Product = productList[position]
        holder.configure(product)
        holder.itemView.setOnClickListener {
            itemClickable?.onClick(product, position)
        }
    }



    override fun getItemCount(): Int {
        return productList.size
    }


}