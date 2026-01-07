package com.hmw.decideease

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.hmw.decideease.domain.coinflip.usecase.FlipCoinUseCase
import com.hmw.decideease.domain.coinflip.util.DefaultRandomGenerator
import com.hmw.decideease.ui.coinflip.CoinFlipScreen
import com.hmw.decideease.ui.coinflip.CoinFlipViewModel
import com.hmw.decideease.ui.theme.DecideEaseTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val randomGenerator = DefaultRandomGenerator()
        val flipCoinUseCase = FlipCoinUseCase(randomGenerator)
        val coinFlipViewModel = CoinFlipViewModel(flipCoinUseCase)

        setContent {
            DecideEaseTheme {
                CoinFlipScreen(viewModel = coinFlipViewModel)
            }
        }
    }
}
