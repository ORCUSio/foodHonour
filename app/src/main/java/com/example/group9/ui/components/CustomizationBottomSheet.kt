package com.example.group9.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.group9.model.FoodItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomizationBottomSheet(foodItem: FoodItem, onAddToCart: () -> Unit) {
    var selectedSize by remember { mutableStateOf("Regular") }
    val sizes = listOf("Regular", "Large", "X-Large")

    var extraCheese by remember { mutableStateOf(false) }
    var extraSauce by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Customize ${foodItem.name}", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Size", style = MaterialTheme.typography.titleMedium)
        sizes.forEach { size ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (size == selectedSize),
                        onClick = { selectedSize = size }
                    )
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (size == selectedSize),
                    onClick = { selectedSize = size }
                )
                Text(text = size, modifier = Modifier.padding(start = 16.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Add-ons", style = MaterialTheme.typography.titleMedium)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = extraCheese, onCheckedChange = { extraCheese = it })
            Text(text = "Extra Cheese", modifier = Modifier.padding(start = 16.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = extraSauce, onCheckedChange = { extraSauce = it })
            Text(text = "Extra Sauce", modifier = Modifier.padding(start = 16.dp))
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = onAddToCart,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("Add to Cart")
        }
    }
}