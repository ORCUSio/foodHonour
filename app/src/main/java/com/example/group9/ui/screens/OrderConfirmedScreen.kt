package com.example.group9.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.group9.R

@Composable
fun OrderConfirmedScreen(
    onContinueShopping: () -> Unit = {}
) {
    // Gradient background for vibrance
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFE0B2),  // soft pastel orange
            Color(0xFFFFCC80),  // light coral
            Color(0xFFFFAB91)   // warm peach
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradient),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            // ✅ Animated success icon (or static vector)
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Order Confirmed",
                tint = Color(0xFF2E7D32), // Green success color
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Order Confirmed!",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color(0xFF2E7D32),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Thank you for your order.\nYour food is being prepared and will arrive soon!",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = Color(0xFF4E342E)
            )

            Spacer(modifier = Modifier.height(40.dp))

            // 🍔 Order summary card (optional)
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.9f)),
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Estimated Delivery: 25–30 mins",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                        color = Color(0xFF5D4037)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Order #FG1208",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(48.dp))

            // 🔘 Continue button
            Button(
                onClick = onContinueShopping,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF7043)
                ),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(50.dp)
            ) {
                Text(
                    text = "Continue Shopping",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
