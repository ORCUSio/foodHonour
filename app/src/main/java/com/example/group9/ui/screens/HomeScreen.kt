package com.example.group9.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.group9.model.CartItem
import com.example.group9.model.DataProvider
import com.example.group9.model.FoodItem
import com.example.group9.ui.components.CustomizationBottomSheet
import com.example.group9.ui.components.FoodItemCard
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val foodItems = DataProvider.foodList
    var selectedFoodItem by remember { mutableStateOf<FoodItem?>(null) }
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    LazyColumn {
        items(foodItems) { foodItem ->
            FoodItemCard(
                foodItem = foodItem,
                onItemClick = {
                    navController.navigate("itemDetail/${foodItem.id}")
                },
                onAddToCartClick = {
                    val cartItem = CartItem(foodItem, 1, "Regular", emptyList())
                    DataProvider.addToCart(cartItem)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}