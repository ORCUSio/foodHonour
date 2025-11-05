package com.example.group9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.group9.model.DataProvider
import com.example.group9.ui.screens.CheckoutScreen
import com.example.group9.ui.screens.HomeScreen
import com.example.group9.ui.screens.ItemDetailScreen
import com.example.group9.ui.screens.TeamScreen
import com.example.group9.ui.theme.Group9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Group9Theme {
                FoodDeliveryApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodDeliveryApp() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    val cartItems = DataProvider.cartItems

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Food App") },
                navigationIcon = {
                    if (currentRoute != "home") {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate("team") }) {
                        Icon(Icons.Default.AccountBox, contentDescription = "Team")
                    }
                    IconButton(onClick = { navController.navigate("checkout") }) {
                        BadgedBox(badge = { Badge { Text("${cartItems.size}") } }) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") {
                HomeScreen(navController)
            }
            composable("itemDetail/{itemId}") { backStackEntry ->
                val itemId = backStackEntry.arguments?.getString("itemId")?.toIntOrNull()
                val foodItem = DataProvider.foodList.find { it.id == itemId }
                if (foodItem != null) {
                    ItemDetailScreen(foodItem = foodItem) { cartItem ->
                        DataProvider.addToCart(cartItem)
                    }
                }
            }
            composable("checkout") {
                CheckoutScreen()
            }
            composable("team") {
                TeamScreen()
            }
        }
    }
}