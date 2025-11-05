package com.example.group9.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.group9.model.FoodItem
import com.example.group9.model.NutritionalInfo
import com.example.group9.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodItemCard(foodItem: FoodItem, onItemClick: () -> Unit, onAddToCartClick: () -> Unit) {
    Card(
        onClick = onItemClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column {
            AsyncImage(
                model = foodItem.imageUrl,
                contentDescription = foodItem.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = foodItem.name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = foodItem.description, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(modifier = Modifier.height(8.dp))
                foodItem.nutritionalInfo?.let {
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        NutrientInfo(icon = R.drawable.ic_launcher_foreground, value = "${it.calories} kcal")
                        NutrientInfo(icon = R.drawable.ic_launcher_foreground, value = "${it.protein}g protein")
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$${foodItem.price}",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Button(onClick = onAddToCartClick) {
                        Text("Add to Cart")
                    }
                }
            }
        }
    }
}

@Composable
fun NutrientInfo(icon: Int, value: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(16.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = value, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

@Preview(showBackground = true)
@Composable
fun FoodItemCardPreview() {
    FoodItemCard(
        foodItem = FoodItem(
            id = 1,
            name = "Classic Burger",
            description = "A juicy beef patty with fresh lettuce, tomato, and our special sauce.",
            price = 8.99,
            imageUrl = "https://www.foodandwine.com/thmb/DI29Houjc_ccAtFKly0BbVsusHc=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/crispy-comte-cheesburgers-FT-RECIPE0921-6166c6552b7148e8a85d47f56d69f5a4.jpg",
            tags = listOf("Popular", "New"),
            nutritionalInfo = NutritionalInfo(calories = 550, protein = 30, carbs = 45)
        ),
        onItemClick = {},
        onAddToCartClick = {}
    )
}