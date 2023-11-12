package com.cs473.mda.cartapplication.adapter

interface ItemClickable<T> {
    fun onClick(item: T, position: Int)
}