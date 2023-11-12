package com.cs473.mda.cartapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.cs473.mda.cartapplication.R
import com.cs473.mda.cartapplication.factory.ImageFactory
import com.cs473.mda.cartapplication.model.Product

class ProductDetailsActivity : AppCompatActivity() {
    private var productImageView: ImageView? = null
    private var productTitleTextView: TextView? = null
    private var productDescriptionTextView: TextView? = null
    private var productPriceTextView: TextView? = null
    private var homeButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        setupView()
        bindView()
    }

    private fun setupView() {
        productImageView = findViewById(R.id.details_image_view)
        productTitleTextView = findViewById(R.id.details_title_text_view)
        productDescriptionTextView = findViewById(R.id.details_description)
        productPriceTextView = findViewById(R.id.details_price_text_view)
        homeButton = findViewById(R.id.home_button)
    }

    private fun bindView() {
        val product = intent.getSerializableExtra("item") as? Product
        if (product != null) {
            val imageBitmap = ImageFactory.bitmapFromFile(this, product.productImageId)
            if (imageBitmap != null) {
                val compressedImageBitmap = ImageFactory.compressBitmap(imageBitmap, 10)
                productImageView?.setImageBitmap(compressedImageBitmap)
            }
            productTitleTextView?.text = product.productName
            productDescriptionTextView?.text = product.productDescription
            productPriceTextView?.text = product.cost.toString()
        }

        homeButton?.setOnClickListener {
            finish()
        }

    }
}