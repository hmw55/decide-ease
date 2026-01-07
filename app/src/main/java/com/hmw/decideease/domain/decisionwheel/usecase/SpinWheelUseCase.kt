package com.hmw.decideease.domain.decisionwheel.usecase

import com.hmw.decideease.domain.decisionwheel.model.WheelOption
import com.hmw.decideease.domain.decisionwheel.model.SpinResult
import com.hmw.decideease.domain.decisionwheel.util.WheelRandomGenerator

class SpinWheelUseCase(
    private val randomGenerator: WheelRandomGenerator = WheelRandomGenerator()
) {
    fun spin(choices: List<WheelOption>): SpinResult {
        if (choices.isEmpty()) throw IllegalArgumentException("No decisions to choose from")
        val selected = choices[randomGenerator.nextInt(choices.size)]
        return SpinResult(selectedDecision = selected)
    }
}
