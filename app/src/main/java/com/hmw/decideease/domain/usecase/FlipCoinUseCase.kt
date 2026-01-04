package com.hmw.decideease.domain.usecase

import com.hmw.decideease.domain.model.CoinSide
import com.hmw.decideease.domain.model.CoinFlipResult
import com.hmw.decideease.domain.util.RandomGenerator

class FlipCoinUseCase(private val randomGenerator: RandomGenerator) {

    fun execute(): CoinFlipResult {
        val side = if (randomGenerator.nextInt(2) == 0) CoinSide.HEADS else CoinSide.TAILS
        return CoinFlipResult(side)
    }
}