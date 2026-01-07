package com.hmw.decideease.ui.wheels

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hmw.decideease.domain.decisionwheel.model.WheelOption
import com.hmw.decideease.domain.decisionwheel.usecase.SpinWheelUseCase
import com.hmw.decideease.ui.topbar.DecideEaseTopBar

@Composable
fun FoodWheelScreen(
    spinWheelUseCase: SpinWheelUseCase, // pass it in
    onBack: () -> Unit
) {
    var spinResult by remember { mutableStateOf<WheelOption?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {



        // Spinning wheel
        WheelComposable(
            options = FoodWheelOptions.options,
            spinWheelUseCase = spinWheelUseCase, // <-- pass it here
            onSpinComplete = { result ->
                spinResult = result
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Show result
        spinResult?.let { result ->
            Text(
                text = "You got: ${result.label}",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}