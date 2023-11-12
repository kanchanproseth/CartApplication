package com.cs473.mda.cartapplication.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cs473.mda.cartapplication.R
import com.cs473.mda.cartapplication.adapter.ItemClickable
import com.cs473.mda.cartapplication.adapter.ProductAdapter
import com.cs473.mda.cartapplication.factory.CartFactory
import com.cs473.mda.cartapplication.model.Product
import com.cs473.mda.cartapplication.factory.ProductFactory


class MainActivity : AppCompatActivity(), ItemClickable<Product> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapter =  ProductAdapter(ProductFactory.products(), this);
        recyclerView.adapter = adapter

        val viewCartButton = findViewById<Button>(R.id.view_cart_button)
        viewCartButton.setOnClickListener {
            Toast.makeText(this, CartFactory.items().toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(item: Product, position: Int) {
        val intent = Intent(this, ProductDetailsActivity::class.java)
        intent.putExtra("item", item)
        startActivity(intent)
    }
}