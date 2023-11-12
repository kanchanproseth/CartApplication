package com.cs473.mda.cartapplication.adapter

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cs473.mda.cartapplication.model.Product
import com.cs473.mda.cartapplication.R
import com.cs473.mda.cartapplication.factory.CartFactory
import com.cs473.mda.cartapplication.factory.ImageFactory

class ProductViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {
    private var productImageView: ImageView? = null
    private var productIcon: ImageView? = null
    private var productTitle: TextView? = null
    private var productDescription: TextView? = null
    private var productPrice: TextView? = null
    private var addButton: Button? = null
    private var context: Context

    init {
        productImageView = itemView.findViewById(R.id.product_image)
        productIcon = itemView.findViewById(R.id.product_icon)
        productTitle = itemView.findViewById(R.id.title_view)
        productDescription = itemView.findViewById(R.id.description_text_view)
        productPrice = itemView.findViewById(R.id.price_text_view)
        addButton = itemView.findViewById(R.id.add_button)
        this.context = context
    }

    fun configure(product: Product) {
        val imageBitmap = ImageFactory.bitmapFromFile(this.context, product.productImageId)
        if (imageBitmap != null) {
            val compressedImageBitmap = ImageFactory.compressBitmap(imageBitmap, 10)
            productImageView?.setImageBitmap(compressedImageBitmap)
        }

        val iconBitmap = ImageFactory.bitmapFromFile(this.context, product.productImageIconId)
        if (iconBitmap != null) {
            val compressedIconBitmap = ImageFactory.compressBitmap(iconBitmap, 10)
            productIcon?.setImageBitmap(compressedIconBitmap)
        }

        productTitle?.text = product.productName
        productDescription?.text = product.productName
        productPrice?.text = product.cost.toString()

        addButton?.setOnClickListener {
            CartFactory.add(product)
        }
    }
}