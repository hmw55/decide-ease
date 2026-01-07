package com.hmw.decideease.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(onSelectDecider: (DeciderType) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Choose a Decider",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { onSelectDecider(DeciderType.COIN_FLIP) }) {
            Text("Coin Flip")
        }

        // Later: Add more buttons for other deciders
        // Button(onClick = { onSelectDecider(DeciderType.SPIN_WHEEL) }) { Text("Spin Wheel") }
    }
}
