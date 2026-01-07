package com.hmw.decideease.domain.coinflip.usecase

import com.hmw.decideease.domain.coinflip.model.CoinSide
import com.hmw.decideease.domain.coinflip.model.CoinFlipResult
import com.hmw.decideease.domain.coinflip.util.RandomGenerator

class FlipCoinUseCase(private val randomGenerator: RandomGenerator) {

    fun execute(): CoinFlipResult {
        val side = if (randomGenerator.nextInt(2) == 0) CoinSide.HEADS else CoinSide.TAILS
        return CoinFlipResult(side)
    }
}