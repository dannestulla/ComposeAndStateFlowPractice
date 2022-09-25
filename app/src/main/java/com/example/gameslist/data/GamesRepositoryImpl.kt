package com.example.gameslist.data

import com.example.gameslist.data.remote.GamesResponse
import com.example.gameslist.data.remote.GamesService
import retrofit2.Response

class GamesRepositoryImpl(
    private val apiService : GamesService
) : GamesRepository {

    override suspend fun getGamesList(platform: String) : Response<List<GamesResponse>> =
        apiService.getGamesList(platform)
}