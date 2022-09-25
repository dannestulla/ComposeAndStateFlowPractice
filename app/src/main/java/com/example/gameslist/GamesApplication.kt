package com.example.gameslist

import android.app.Application
import com.example.gameslist.di.gamesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class GamesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GamesApplication)
            modules(gamesModule)
        }
    }
}