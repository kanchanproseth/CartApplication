package com.cs473.mda.cartapplication.factory

import com.cs473.mda.cartapplication.model.Product

class CartFactory {
    companion object {
        private var items = ArrayList<Product>()

        fun add(item: Product) {
            items.add(item)
        }

        fun items(): List<Product> {
            return items
        }
    }
}