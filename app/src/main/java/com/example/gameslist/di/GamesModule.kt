package com.example.gameslist.di

import com.example.gameslist.data.GamesRepository
import com.example.gameslist.data.GamesRepositoryImpl
import com.example.gameslist.data.remote.GamesService
import com.example.gameslist.presentation.GamesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val gamesModule = module {
    viewModel { GamesViewModel(get()) }
    factory<GamesRepository> { GamesRepositoryImpl(get()) }
    single { provideRetrofit() }
    single { createNetworkService(get()) }
}

private fun provideRetrofit() = Retrofit.Builder()
    .baseUrl("https://www.freetogame.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

private fun createNetworkService(retrofit: Retrofit) =
    retrofit.create(GamesService::class.java)