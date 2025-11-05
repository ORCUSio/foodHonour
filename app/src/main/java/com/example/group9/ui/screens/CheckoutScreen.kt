package com.example.group9.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
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

@Composable
fun CheckoutScreen() {
    val cartItems = remember { mutableStateOf(DataProvider.cartItems) }
    val subtotal = cartItems.value.sumOf { it.foodItem.price * it.quantity }
    val tax = subtotal * 0.1
    val deliveryFee = 5.0
    val total = subtotal + tax + deliveryFee

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp)
        ) {
            item {
                Text(
                    "My Cart",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
            items(cartItems.value) { cartItem ->
                CartItemRow(cartItem = cartItem, onQuantityChanged = { newQuantity ->
                    val index = cartItems.value.indexOf(cartItem)
                    if (index != -1) {
                        val updatedList = cartItems.value.toMutableList()
                        if (newQuantity > 0) {
                            updatedList[index] = cartItem.copy(quantity = newQuantity)
                        } else {
                            updatedList.removeAt(index)
                        }
                        cartItems.value = updatedList
                    }
                })
            }
            item {
                CheckoutSummary(subtotal = subtotal, tax = tax, deliveryFee = deliveryFee, total = total)
            }
        }

        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(56.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text("Checkout")
        }
    }
}

@Composable
fun CartItemRow(cartItem: CartItem, onQuantityChanged: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = cartItem.foodItem.imageUrl,
            contentDescription = cartItem.foodItem.name,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = cartItem.foodItem.name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text(text = "Size: ${cartItem.selectedSize}", style = MaterialTheme.typography.bodyMedium)
            Text(text = cartItem.addOns.joinToString(), style = MaterialTheme.typography.bodyMedium)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = "$${cartItem.foodItem.price * cartItem.quantity}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { onQuantityChanged(cartItem.quantity - 1) }, enabled = cartItem.quantity > 0) {
                    Icon(Icons.Filled.Delete, contentDescription = "Remove")
                }
                Text(text = cartItem.quantity.toString())
                IconButton(onClick = { onQuantityChanged(cartItem.quantity + 1) }) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }
            }
        }
    }
}

@Composable
fun CheckoutSummary(subtotal: Double, tax: Double, deliveryFee: Double, total: Double) {
    Column(modifier = Modifier.padding(16.dp)) {
        Divider(modifier = Modifier.padding(vertical = 16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Subtotal", style = MaterialTheme.typography.bodyLarge)
            Text(String.format("$%.2f", subtotal), style = MaterialTheme.typography.bodyLarge)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Tax (10%)", style = MaterialTheme.typography.bodyLarge)
            Text(String.format("$%.2f", tax), style = MaterialTheme.typography.bodyLarge)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Delivery Fee", style = MaterialTheme.typography.bodyLarge)
            Text(String.format("$%.2f", deliveryFee), style = MaterialTheme.typography.bodyLarge)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Divider()
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Total", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(String.format("$%.2f", total), style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    CheckoutScreen()
}