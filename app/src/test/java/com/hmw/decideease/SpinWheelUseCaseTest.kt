package com.hmw.decideease.domain.decisionwheel.usecase

import com.hmw.decideease.domain.decisionwheel.model.WheelOption
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.Assert.assertThrows

class SpinWheelUseCaseTest {

    @Test
    fun `spin returns one of the choices`() {
        val choices = listOf(
            WheelOption(1, "Italian"),
            WheelOption(2, "Mexican"),
            WheelOption(3, "Greek")
        )

        val spinWheel = SpinWheelUseCase()
        val result = spinWheel.spin(choices)

        assertTrue(choices.contains(result.selectedDecision))
    }

    @Test
    fun `spin throws error when choices are empty`() {
        val spinWheel = SpinWheelUseCase()
        assertThrows(IllegalArgumentException::class.java) {
            spinWheel.spin(emptyList())
        }
    }
}
