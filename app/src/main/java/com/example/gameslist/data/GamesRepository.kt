package com.example.gameslist.data

import com.example.gameslist.data.remote.GamesResponse
import retrofit2.Response

interface GamesRepository {
    suspend fun getGamesList(platform: String) : Response<List<GamesResponse>>
}