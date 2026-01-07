package com.hmw.decideease

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.hmw.decideease.ui.home.HomeScreen
import com.hmw.decideease.ui.theme.DecideEaseTheme
import com.hmw.decideease.domain.coinflip.usecase.FlipCoinUseCase
import com.hmw.decideease.domain.coinflip.util.DefaultRandomGenerator
import com.hmw.decideease.domain.decisionwheel.usecase.SpinWheelUseCase
import com.hmw.decideease.ui.coinflip.CoinFlipScreen
import com.hmw.decideease.ui.coinflip.CoinFlipViewModel
import com.hmw.decideease.ui.topbar.DecideEaseTopBar

import com.hmw.decideease.ui.wheels.FoodWheelScreen
import com.hmw.decideease.ui.wheels.FoodWheelOptions


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val randomGenerator = DefaultRandomGenerator()
        val flipCoinUseCase = FlipCoinUseCase(randomGenerator)
        val coinFlipViewModel = CoinFlipViewModel(flipCoinUseCase)

        setContent {
            DecideEaseTheme {

                var currentScreen by remember { mutableStateOf("home") }

                Column(modifier = Modifier
                        .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primary)) {
                    DecideEaseTopBar(
                        showBackButton = currentScreen != "home",
                        onBackClick = { currentScreen = "home" },
                        onCartClick = { /* TODO */ }
                    )

                    Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))

                    when (currentScreen) {
                        "home" -> HomeScreen(
                            onCoinFlipClick = { currentScreen = "coinFlip"},
                            onFoodWheelClick = { currentScreen = "foodWheelScreen" },
                            onMovieWheelClick = { /* TODO */ },
                            onCustomWheelClick = { /* TODO */ }
                        )
                        "coinFlip" -> CoinFlipScreen(
                            viewModel = coinFlipViewModel,
                            onBack = { currentScreen = "home"}
                        )
                        "foodWheelScreen" -> FoodWheelScreen(
                            spinWheelUseCase =  SpinWheelUseCase(),
                            onBack = { currentScreen = "home" }
                        )
                    }

                }


            }
        }
    }
}
