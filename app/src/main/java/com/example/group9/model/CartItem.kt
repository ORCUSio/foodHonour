package com.example.group9.model

data class CartItem(
    val foodItem: FoodItem,
    var quantity: Int,
    val selectedSize: String,
    val addOns: List<String>
)