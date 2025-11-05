package com.example.group9.model

import androidx.compose.runtime.mutableStateListOf

object DataProvider {

    val teamMemberList = listOf(
        TeamMember(
            name = "Nikhil Raj",
            role = "23C5050",
            avatarUrl = "https://avatars.githubusercontent.com/u/810939?v=4"
        ),
        TeamMember(
            name = "Nabeela",
            role = "23C5049",
            avatarUrl = "https://avatars.githubusercontent.com/u/810939?v=4"
        ),

        TeamMember(
            name = "Obaid",
            role = "23C5051",
            avatarUrl = "https://avatars.githubusercontent.com/u/810939?v=4"
        ),
        TeamMember(
            name = "Pawani",
            role = "23C5052",
            avatarUrl = "https://avatars.githubusercontent.com/u/810939?v=4"
        ),
        TeamMember(
            name = "Piyush Rawat",
            role = "23C5053",
            avatarUrl = "https://avatars.githubusercontent.com/u/810939?v=4"
        ),
        TeamMember(
            name = "Ramkrishna",
            role = "23C5054",
            avatarUrl = "https://avatars.githubusercontent.com/u/810939?v=4"
        ),
    )

    val foodList = listOf(
        FoodItem(
            id = 1,
            name = "Classic Burger",
            description = "A juicy beef patty with fresh lettuce, tomato, and our special sauce.",
            price = 80.99,
            imageUrl = "https://lh3.googleusercontent.com/p/AF1QipO6-vvhwEFWpT6_aEClDTQcZNlfXmS2d0_wvl-Q=w260-h175-n-k-no",
            tags = listOf("Popular", "New"),
            nutritionalInfo = NutritionalInfo(calories = 550, protein = 30, carbs = 45)
        ),
        FoodItem(
            id = 2,
            name = "Spicy Chicken Pizza",
            description = "A fiery pizza with spicy chicken, jalapenos, and a blend of cheeses.",
            price = 120.50,
            imageUrl = "https://www.mexicanplease.com/wp-content/uploads/2016/12/pickled-jalapeno-pizza-just-after-cooking-white.jpg",
            tags = listOf("Spicy"),
            nutritionalInfo = NutritionalInfo(calories = 800, protein = 40, carbs = 90)
        ),
        FoodItem(
            id = 3,
            name = "Vegan Salad Bowl",
            description = "A healthy and refreshing bowl of mixed greens, quinoa, and fresh vegetables.",
            price = 90.99,
            imageUrl = "https://rainbowplantlife.com/wp-content/uploads/2022/07/cucumber-salad-in-white-bowl-1-of-1-300x300.jpg",
            tags = listOf("Vegan", "Healthy"),
            nutritionalInfo = NutritionalInfo(calories = 350, protein = 15, carbs = 30)
        ),
        FoodItem(
            id = 4,
            name = "Vegan Buddha Bowl",
            description = "A colorful bowl of quinoa, roasted veggies, chickpeas, and tahini dressing.",
            price = 90.99,
            imageUrl = "https://simplyceecee.co/wp-content/uploads/2018/07/veganbuddhabowl-2.jpg",
            tags = listOf("Vegan", "Healthy"),
            nutritionalInfo = NutritionalInfo(calories = 610, protein = 20, carbs = 70)
        ),
        FoodItem(
            id = 5,
            name = "BBQ Chicken Pizza",
            description = "Smoky BBQ sauce topped with grilled chicken, onions, and mozzarella cheese.",
            price = 110.29,
            imageUrl = "https://onebalancedlife.com/wp-content/uploads/2023/06/BBQ-Chicken-Pineapple-Flatbread-scaled-720x405.jpg",
            tags = listOf("Popular", "Non-Veg"),
            nutritionalInfo = NutritionalInfo(calories = 780, protein = 40, carbs = 85)
        ),
        FoodItem(
            id = 6,
            name = "Caesar Salad",
            description = "Crisp romaine lettuce tossed in creamy Caesar dressing with croutons and parmesan.",
            price = 60.49,
            imageUrl = "https://www.cuisinart.com/dw/image/v2/ABAF_PRD/on/demandware.static/-/Sites-us-cuisinart-sfra-Library/default/dw92573286/images/recipe-Images/classic-caesar-salad-recipe.jpg",
            tags = listOf("Light", "Healthy"),
            nutritionalInfo = NutritionalInfo(calories = 320, protein = 10, carbs = 25)
        ),
        FoodItem(
            id = 7,
            name = "Pepperoni Pizza",
            description = "Loaded with spicy pepperoni slices and gooey mozzarella cheese.",
            price = 100.99,
            imageUrl = "https://www.cherryonmysundae.com/wp-content/uploads/2021/10/pepperoni-pizza-8.jpg",
            tags = listOf("Spicy", "Classic"),
            nutritionalInfo = NutritionalInfo(calories = 860, protein = 35, carbs = 90)
        ),
        FoodItem(
            id = 8,
            name = "Grilled Salmon Bowl",
            description = "Perfectly grilled salmon served with brown rice, avocado, and sesame dressing.",
            price = 120.99,
            imageUrl = "https://www.feastingathome.com/wp-content/uploads/2017/06/Grilled-Salmon-Tzatziki-Bowl-114.jpg",
            tags = listOf("Healthy", "High Protein"),
            nutritionalInfo = NutritionalInfo(calories = 670, protein = 42, carbs = 55)
        ),
        FoodItem(
            id = 9,
            name = "Loaded Fries",
            description = "Golden fries topped with cheese sauce, crispy bacon bits, and jalapeños.",
            price = 50.99,
            imageUrl = "https://www.unileverfoodsolutions.com.au/dam/global-ufs/mcos/anz/calcmenu/recipe/red-meat/pulled-pork-loaded-fries/pulled-pork-loaded-fries-main-header.jpg",
            tags = listOf("Spicy", "Snack"),
            nutritionalInfo = NutritionalInfo(calories = 720, protein = 15, carbs = 65)
        ),
        FoodItem(
            id = 10,
            name = "Chocolate Lava Cake",
            description = "Rich molten chocolate cake served warm with a scoop of vanilla ice cream.",
            price = 60.99,
            imageUrl = "https://i.ytimg.com/vi/M6fyELOU6qA/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLAbzXpQXDmA20B9cWHTSThWz3ZX0A",
            tags = listOf("Dessert", "Popular"),
            nutritionalInfo = NutritionalInfo(calories = 540, protein = 8, carbs = 60)
        ), FoodItem(
            id = 11,
            name = "Classic Burger",
            description = "A juicy beef patty with fresh lettuce, tomato, and our special sauce.",
            price = 80.99,
            imageUrl = "https://lh3.googleusercontent.com/p/AF1QipO6-vvhwEFWpT6_aEClDTQcZNlfXmS2d0_wvl-Q=w260-h175-n-k-no",
            tags = listOf("Popular", "New"),
            nutritionalInfo = NutritionalInfo(calories = 550, protein = 30, carbs = 45)
        ),
        FoodItem(
            id = 12,
            name = "Margherita Pizza",
            description = "Classic Neapolitan pizza with mozzarella, fresh basil, and tomato sauce.",
            price = 100.49,
            imageUrl = "https://lh3.googleusercontent.com/p/AF1QipPmh3oFzX8XrMM4B9mIsxZRxhR4fPlj4bbHD8vC=w260-h175-n-k-no",
            tags = listOf("Vegetarian", "Popular"),
            nutritionalInfo = NutritionalInfo(calories = 720, protein = 25, carbs = 80)
        ),
        FoodItem(
            id = 13,
            name = "Spicy Chicken Wrap",
            description = "Grilled chicken with spicy mayo, lettuce, and tomato wrapped in a tortilla.",
            price = 70.49,
            imageUrl = "https://lh3.googleusercontent.com/p/AF1QipP-hpnD4nU6W5BZyyA_0mV3JW0yqQgi_FQ88K_e=w260-h175-n-k-no",
            tags = listOf("Spicy", "High Protein"),
            nutritionalInfo = NutritionalInfo(calories = 480, protein = 35, carbs = 40)
        ),
    )

    var cartItems = mutableStateListOf<CartItem>()
        private set

    fun addToCart(item: CartItem) {
        cartItems.add(item)
    }
}
