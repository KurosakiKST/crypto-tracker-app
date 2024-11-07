package com.ryan.cryptotracker.crypto.presentation.coin_list

import com.ryan.cryptotracker.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError) : CoinListEvent
}