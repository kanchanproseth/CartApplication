package com.cs473.mda.cartapplication.model

import java.io.Serializable

data class Product(val productImageId: Int, val productImageIconId: Int, val productName: String, val productDescription: String,
                   val cost: Double): Serializable