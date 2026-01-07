package com.hmw.decideease

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.hmw.decideease.ui.home.HomeScreen
import com.hmw.decideease.ui.theme.DecideEaseTheme
import com.hmw.decideease.domain.coinflip.usecase.FlipCoinUseCase
import com.hmw.decideease.domain.coinflip.util.DefaultRandomGenerator
import com.hmw.decideease.ui.coinflip.CoinFlipViewModel
import com.hmw.decideease.ui.topbar.DecideEaseTopBar

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val randomGenerator = DefaultRandomGenerator()
        val flipCoinUseCase = FlipCoinUseCase(randomGenerator)
        val coinFlipViewModel = CoinFlipViewModel(flipCoinUseCase)

        setContent {
            DecideEaseTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    DecideEaseTopBar(
                        showBackButton = false,
                        onCartClick = { /* TODO */ }
                    )

                    HomeScreen(
                        onCoinFlipClick = { /* TODO */ },
                        onFoodWheelClick = { /* TODO */ },
                        onMovieWheelClick = { /* TODO */ },
                        onCustomWheelClick = { /* TODO */ }
                    )
                }
            }
        }
    }
}
