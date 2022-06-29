package com.nvah.studentproject.api.data

import android.content.Context

class DataManager(private val baseContext: Context) {

    val shared = baseContext.getSharedPreferences(
        "ws",
        Context.MODE_PRIVATE
    ) //В первый параметр пишем любую строку

    val api = Api.createApi()

}