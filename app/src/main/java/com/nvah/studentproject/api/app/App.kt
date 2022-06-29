package com.nvah.studentproject.api.app

import android.app.Application
import com.nvah.studentproject.api.data.DataManager

class App : Application() {

    companion object{
        lateinit var dm : DataManager
    }

    override fun onCreate() {
        super.onCreate()

        dm = DataManager(baseContext)

    }

}