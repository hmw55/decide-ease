package com.hmw.decideease

import com.hmw.decideease.domain.usecase.FlipCoinUseCase
import com.hmw.decideease.domain.model.CoinSide
import com.hmw.decideease.domain.util.TestRandomGenerator
import org.junit.Assert.assertEquals
import org.junit.Test

class FlipCoinUseCaseTest {

    @Test
    fun `flip coin returns HEADS when random is 0`() {
        val testRandom = TestRandomGenerator(listOf(0))
        val coinFlipper = FlipCoinUseCase(testRandom)

        val result = coinFlipper.execute()

        assertEquals(CoinSide.HEADS, result.side)
    }

    @Test
    fun `flip coin returns TAILS when random is 1`() {
        val testRandom = TestRandomGenerator(listOf(1))
        val coinFlipper = FlipCoinUseCase(testRandom)

        val result = coinFlipper.execute()

        assertEquals(CoinSide.TAILS, result.side)
    }

    @Test
    fun `flip coin cycles through sequence`() {
        val testRandom = TestRandomGenerator(listOf(0, 1, 0))
        val coinFlipper = FlipCoinUseCase(testRandom)

        val results = List(3) { coinFlipper.execute().side }

        assertEquals(listOf(CoinSide.HEADS, CoinSide.TAILS, CoinSide.HEADS), results)
    }
}