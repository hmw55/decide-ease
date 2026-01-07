package com.hmw.decideease.domain.coinflip.model

data class CoinFlipResult (
    val side: CoinSide,
    val timestamp: Long = System.currentTimeMillis()
)