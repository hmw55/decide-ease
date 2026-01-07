package com.hmw.decideease.ui.coinflip

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CoinFlipScreen(
    viewModel: CoinFlipViewModel,
    onBack: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(32.dp))

        Text("Coin Flip", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { viewModel.flipCoin() },
            enabled = !uiState.isFlipping
        ) {
            Text(if (uiState.isFlipping) "Flipping..." else "Flip Coin")
        }

        Spacer(modifier = Modifier.height(32.dp))

        uiState.result?.let { result ->
            Text("Result: ${result.side.name}", style = MaterialTheme.typography.headlineSmall)
        }
    }
}
