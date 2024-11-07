package com.ryan.cryptotracker.crypto.presentation.coin_list

import com.ryan.cryptotracker.crypto.presentation.models.CoinUi

sealed interface CoinListAction {
    data class OnCoinClicked(val coinUi: CoinUi) : CoinListAction
}