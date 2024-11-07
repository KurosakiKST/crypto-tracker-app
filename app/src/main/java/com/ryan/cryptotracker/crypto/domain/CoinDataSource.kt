package com.ryan.cryptotracker.crypto.domain

import com.ryan.cryptotracker.core.domain.util.NetworkError
import com.ryan.cryptotracker.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}