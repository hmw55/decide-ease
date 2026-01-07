package com.hmw.decideease.ui.coinflip

import com.hmw.decideease.domain.coinflip.model.CoinFlipResult

data class CoinFlipUiState(
    val result: CoinFlipResult? = null,
    val isFlipping: Boolean = false
)
