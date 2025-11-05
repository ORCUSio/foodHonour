package com.example.group9

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.group9.model.DataProvider
import com.example.group9.ui.screens.CheckoutScreen
import com.example.group9.ui.screens.HomeScreen
import com.example.group9.ui.screens.ItemDetailScreen
import com.example.group9.ui.screens.OrderConfirmedScreen
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
    val context = LocalContext.current

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
                    Button(
                        onClick = { navController.navigate("team") },
                        shape = RoundedCornerShape(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3700B3))
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                            Text("TEAM")
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(Icons.Default.AccountCircle, contentDescription = "Team")
                        }
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
                        Toast.makeText(context, "Item added to cart", Toast.LENGTH_SHORT).show()
                        navController.popBackStack()
                    }
                }
            }
            composable("checkout") {
                CheckoutScreen(navController = navController)
            }
            composable("team") {
                TeamScreen()
            }
            composable("orderConfirmed") {
                OrderConfirmedScreen(onContinueShopping = {
                    navController.navigate("home") {
                        popUpTo("home") {
                            inclusive = true
                        }
                    }
                })
            }
        }
    }
}
