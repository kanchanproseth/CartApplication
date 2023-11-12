package com.cs473.mda.cartapplication.factory

import com.cs473.mda.cartapplication.R
import com.cs473.mda.cartapplication.model.Product

class ProductFactory {
    companion object {
        fun products(): ArrayList<Product> {
            val products = ArrayList<Product>()
            products.add(Product( R.drawable.iphone11, R.drawable.apple,"Iphone 11", "iPad Pro 11-inch", 400.0))
            products.add(Product(R.drawable.iphone12promax, R.drawable.apple,"Iphone 12 Pro Max", "12-core CPU\n18-core GPU", 2500.00))
            products.add(Product(R.drawable.iphone13promax, R.drawable.apple,"Iphone 13 Pro Max", "13th Gen Intel® Core™ i7", 1499.00))
            products.add(Product(R.drawable.iphone14promax, R.drawable.apple,"Iphone 14 Pro Max", "Logitech - PRO X\nTKL LIGHTSPEED Wireless", 199.00))
            return products
        }
    }
}