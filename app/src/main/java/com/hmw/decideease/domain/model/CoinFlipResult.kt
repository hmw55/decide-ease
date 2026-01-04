package com.hmw.decideease.domain.model

data class CoinFlipResult (
    val side: CoinSide,
    val timestamp: Long = System.currentTimeMillis()
)