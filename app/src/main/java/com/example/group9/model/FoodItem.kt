package com.example.group9.model

data class FoodItem(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrl: String,
    val tags: List<String> = emptyList(),
    val nutritionalInfo: NutritionalInfo? = null
)

data class NutritionalInfo(
    val calories: Int,
    val protein: Int,
    val carbs: Int
)