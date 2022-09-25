package com.example.gameslist.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesService {
    @GET("api/games")
    suspend fun getGamesList(@Query("platform") platform: String) : Response<List<GamesResponse>>
}