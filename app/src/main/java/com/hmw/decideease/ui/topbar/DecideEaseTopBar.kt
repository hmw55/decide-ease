package com.hmw.decideease.ui.topbar

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DecideEaseTopBar(
    title: String = "DecideEase",
    showBackButton: Boolean = false,
    onBackClick: (() -> Unit)? = null,
    onCartClick: (() -> Unit)? = null
) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        tonalElevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Left: Back button
            if (showBackButton && onBackClick != null) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            } else {
                Spacer(modifier = Modifier.width(48.dp)) // keep title centered
            }

            // Center: Title
            Text(
                text = title,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onPrimary
            )

            // Right: Cart button
            if (onCartClick != null) {
                IconButton(onClick = onCartClick) {
                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = "Cart",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            } else {
                Spacer(modifier = Modifier.width(48.dp)) // keep title centered
            }
        }
    }
}
