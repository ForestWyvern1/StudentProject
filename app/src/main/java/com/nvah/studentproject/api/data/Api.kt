package com.nvah.studentproject.api.data

import com.google.gson.GsonBuilder
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface Api {

    @GET("")//вставляем остальную часть ссылки
    fun getSomething(
        @Header("someHeader") someHeader: String, //пример для добавления header в запрос
        @Query("someQuery") someQuery: String, //пример для добавления Query в запрос
        @Body someBody: String //пример для добавления Body в запрос
    ): Observable<String> // что бы ожидаем от запроса (обязательно выбирать io.reactivex.Observable

            companion object {

        fun createApi(): Api {

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit = Retrofit.Builder()
                .baseUrl("") //засовываем основную ссылку нашего запроса
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return retrofit.create(Api::class.java)
        }
    }

}