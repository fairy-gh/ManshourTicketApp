package com.fereshte_gholami.manshourticketapp.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication : Application() {

    init {
        context = this
    }

    companion object {
        private lateinit var context: HiltApplication
        fun applicationContext() : HiltApplication {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext()
    }

}