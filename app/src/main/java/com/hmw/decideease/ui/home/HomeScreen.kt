package com.hmw.decideease.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme

@Composable
fun HomeScreen(
    onCoinFlipClick: () -> Unit,
    onFoodWheelClick: () -> Unit,
    onMovieWheelClick: () -> Unit,
    onCustomWheelClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val buttonSpacing = 16.dp

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = DarkBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        HomeOptionCard(
            title = "Flip a Coin",
            color = PurpleAccent,
            onClick = onCoinFlipClick
        )
        HomeOptionCard(
            title = "Food Wheel",
            color = OrangeAccent,
            onClick = onFoodWheelClick
        )
        HomeOptionCard(
            title = "Movie Wheel",
            color = GreenAccent,
            onClick = onMovieWheelClick
        )
        HomeOptionCard(
            title = "Custom Wheel",
            color = BlueAccent,
            onClick = onCustomWheelClick
        )
    }
}

// ---- Colors ----
val DarkBackground = Color(0xFF121212)
val PurpleAccent = Color(0xFFBB86FC)
val OrangeAccent = Color(0xFFFF9800)
val GreenAccent = Color(0xFF4CAF50)
val BlueAccent = Color(0xFF03A9F4)
