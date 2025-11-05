package com.example.group9.model

import androidx.compose.runtime.mutableStateListOf

object DataProvider {

    val foodList = listOf(
        FoodItem(
            id = 1,
            name = "Classic Burger",
            description = "A juicy beef patty with fresh lettuce, tomato, and our special sauce.",
            price = 8.99,
            imageUrl = "https://lh3.googleusercontent.com/p/AF1QipO6-vvhwEFWpT6_aEClDTQcZNlfXmS2d0_wvl-Q=w260-h175-n-k-no",
            tags = listOf("Popular", "New"),
            nutritionalInfo = NutritionalInfo(calories = 550, protein = 30, carbs = 45)
        ),
        FoodItem(
            id = 2,
            name = "Spicy Chicken Pizza",
            description = "A fiery pizza with spicy chicken, jalapenos, and a blend of cheeses.",
            price = 12.50,
            imageUrl = "https://www.mexicanplease.com/wp-content/uploads/2016/12/pickled-jalapeno-pizza-just-after-cooking-white.jpg",
            tags = listOf("Spicy"),
            nutritionalInfo = NutritionalInfo(calories = 800, protein = 40, carbs = 90)
        ),
        FoodItem(
            id = 3,
            name = "Vegan Salad Bowl",
            description = "A healthy and refreshing bowl of mixed greens, quinoa, and fresh vegetables.",
            price = 9.99,
            imageUrl = "https://rainbowplantlife.com/wp-content/uploads/2022/07/cucumber-salad-in-white-bowl-1-of-1-300x300.jpg",
            tags = listOf("Vegan", "Healthy"),
            nutritionalInfo = NutritionalInfo(calories = 350, protein = 15, carbs = 30)
        )
    )

    var cartItems = mutableStateListOf<CartItem>()
        private set

    fun addToCart(item: CartItem) {
        cartItems.add(item)
    }
}