package com.example.group9.model

object DataProvider {

    val foodList = listOf(
        FoodItem(
            id = 1,
            name = "Classic Burger",
            description = "A juicy beef patty with fresh lettuce, tomato, and our special sauce.",
            price = 8.99,
            imageUrl = "https://www.foodandwine.com/thmb/DI29Houjc_ccAtFKly0BbVsusHc=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/crispy-comte-cheesburgers-FT-RECIPE0921-6166c6552b7148e8a85d47f56d69f5a4.jpg",
            tags = listOf("Popular", "New"),
            nutritionalInfo = NutritionalInfo(calories = 550, protein = 30, carbs = 45)
        ),
        FoodItem(
            id = 2,
            name = "Spicy Chicken Pizza",
            description = "A fiery pizza with spicy chicken, jalapenos, and a blend of cheeses.",
            price = 12.50,
            imageUrl = "https://www.chicken.ca/wp-content/uploads/2020/09/Spicy-Chicken-Pizza-1-1180x1021.jpg",
            tags = listOf("Spicy"),
            nutritionalInfo = NutritionalInfo(calories = 800, protein = 40, carbs = 90)
        ),
        FoodItem(
            id = 3,
            name = "Vegan Salad Bowl",
            description = "A healthy and refreshing bowl of mixed greens, quinoa, and fresh vegetables.",
            price = 9.99,
            imageUrl = "https://www.twopeasandtheirpod.com/wp-content/uploads/2021/03/Vegan-Cobb-Salad-5.jpg",
            tags = listOf("Vegan", "Healthy"),
            nutritionalInfo = NutritionalInfo(calories = 350, protein = 15, carbs = 30)
        )
    )

    val cartItems = listOf(
        CartItem(
            foodItem = foodList[0],
            quantity = 2,
            selectedSize = "Large",
            addOns = listOf("Extra Cheese")
        ),
        CartItem(
            foodItem = foodList[1],
            quantity = 1,
            selectedSize = "Regular",
            addOns = listOf("Extra Sauce", "Double toppings")
        )
    )
}