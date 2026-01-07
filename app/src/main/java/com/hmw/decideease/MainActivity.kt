package com.hmw.decideease

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.hmw.decideease.domain.coinflip.usecase.FlipCoinUseCase
import com.hmw.decideease.domain.coinflip.util.DefaultRandomGenerator
import com.hmw.decideease.ui.DeciderType
import com.hmw.decideease.ui.HomeScreen
import com.hmw.decideease.ui.coinflip.CoinFlipScreen
import com.hmw.decideease.ui.coinflip.CoinFlipViewModel
import com.hmw.decideease.ui.theme.DecideEaseTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Coin Flip dependencies
        val randomGenerator = DefaultRandomGenerator()
        val flipCoinUseCase = FlipCoinUseCase(randomGenerator)
        val coinFlipViewModel = CoinFlipViewModel(flipCoinUseCase)

        setContent {
            DecideEaseTheme {
                // Simple screen navigation
                var currentScreen by remember { mutableStateOf<DeciderType?>(null) }

                if (currentScreen == null) {
                    // Show home screen
                    HomeScreen { selectedDecider ->
                        currentScreen = selectedDecider
                    }
                } else {
                    // Show the chosen decider screen
                    when (currentScreen) {
                        DeciderType.COIN_FLIP -> CoinFlipScreen(
                            viewModel = coinFlipViewModel,
                            onBack = { currentScreen = null } // Go back to home
                        )
                        // Later: add other deciders here
                        else -> {}
                    }
                }
            }
        }
    }
}
