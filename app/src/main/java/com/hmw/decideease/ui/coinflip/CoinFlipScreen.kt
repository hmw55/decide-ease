package com.hmw.decideease.ui.coinflip

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hmw.decideease.domain.coinflip.model.CoinSide

@Composable
fun CoinFlipScreen (
    viewModel: CoinFlipViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = when (uiState.result?.side) {
                CoinSide.HEADS -> "Heads"
                CoinSide.TAILS -> "Tails"
                null -> "Flip the coin"
            },
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button (
            onClick = { viewModel.flipCoin() },
            enabled = !uiState.isFlipping
        ) {
            Text("Flip Coin")
        }
    }
}