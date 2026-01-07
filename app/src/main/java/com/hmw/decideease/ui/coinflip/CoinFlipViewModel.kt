package com.hmw.decideease.ui.coinflip

import androidx.lifecycle.ViewModel
import com.hmw.decideease.domain.coinflip.usecase.FlipCoinUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CoinFlipViewModel(
    private val flipCoinUseCase: FlipCoinUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CoinFlipUiState())
    val uiState: StateFlow<CoinFlipUiState> = _uiState

    fun flipCoin() {
        _uiState.update { it.copy(isFlipping = true) }

        val result = flipCoinUseCase.execute()

        _uiState.update {
            it.copy(
                result = result,
                isFlipping = false
            )
        }
    }
}
