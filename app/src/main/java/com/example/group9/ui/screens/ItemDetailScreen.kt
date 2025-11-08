package com.example.group9.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.group9.model.CartItem
import com.example.group9.model.DataProvider
import com.example.group9.model.FoodItem

@Composable
fun ItemDetailScreen(foodItem: FoodItem, onAddToCart: (CartItem) -> Unit) {
    var selectedSize by remember { mutableStateOf("Regular") }
    val sizes = listOf("Regular", "Large", "X-Large")

    var extraCheese by remember { mutableStateOf(false) }
    var extraSauce by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 80.dp) // Space for the sticky button
        ) {
            AsyncImage(
                model = foodItem.imageUrl,
                contentDescription = foodItem.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = foodItem.name,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "₹${foodItem.price}",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = foodItem.description,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(16.dp))
                    // Inline Customization
                    CustomizationSection(foodItem, selectedSize, sizes, extraCheese, extraSauce) { size, cheese, sauce ->
                        selectedSize = size
                        extraCheese = cheese
                        extraSauce = sauce
                    }
                }
            }
        }

        // Sticky Add to Cart Button
        Button(
            onClick = {
                val addOns = mutableListOf<String>()
                if (extraCheese) addOns.add("Extra Cheese")
                if (extraSauce) addOns.add("Extra Sauce")
                val cartItem = CartItem(foodItem, 1, selectedSize, addOns)
                onAddToCart(cartItem)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(56.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text("Add to Cart")
        }
    }
}

@Composable
fun CustomizationSection(
    foodItem: FoodItem,
    selectedSize: String,
    sizes: List<String>,
    extraCheese: Boolean,
    extraSauce: Boolean,
    onCustomizationChange: (String, Boolean, Boolean) -> Unit
) {
    Column {
        Text(text = "Size", style = MaterialTheme.typography.titleMedium)
        sizes.forEach { size ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = (size == selectedSize),
                    onClick = { onCustomizationChange(size, extraCheese, extraSauce) }
                )
                Text(text = size, modifier = Modifier.padding(start = 8.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Add-ons", style = MaterialTheme.typography.titleMedium)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            Checkbox(checked = extraCheese, onCheckedChange = { onCustomizationChange(selectedSize, it, extraSauce) })
            Text(text = "Extra Cheese", modifier = Modifier.padding(start = 8.dp))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            Checkbox(checked = extraSauce, onCheckedChange = { onCustomizationChange(selectedSize, extraCheese, it) })
            Text(text = "Extra Sauce", modifier = Modifier.padding(start = 8.dp))
        }
//         can add another option here to specify quantity, truncate the prices to two digits in checkout?, on clicking on logo(Food App) go to homescreen,
    }
}


@Preview(showBackground = true)
@Composable
fun ItemDetailScreenPreview() {
    ItemDetailScreen(foodItem = DataProvider.foodList.first(), onAddToCart = {})
}