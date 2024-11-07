package com.ryan.cryptotracker.crypto.data.networking

import com.ryan.cryptotracker.core.data.networking.constructUrl
import com.ryan.cryptotracker.core.data.networking.safeCall
import com.ryan.cryptotracker.core.domain.util.NetworkError
import com.ryan.cryptotracker.core.domain.util.Result
import com.ryan.cryptotracker.core.domain.util.map
import com.ryan.cryptotracker.crypto.data.mappers.toCoin
import com.ryan.cryptotracker.crypto.data.networking.dto.CoinsResponseDto
import com.ryan.cryptotracker.crypto.domain.Coin
import com.ryan.cryptotracker.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
): CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }
}