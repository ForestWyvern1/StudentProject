package com.nvah.studentproject.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nvah.studentproject.R
import com.nvah.studentproject.api.app.App
import com.nvah.studentproject.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val disp = App.dm.api
            .getSomething("", "", "") //передаем в header, query и body, которые мы прописали в Api()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ //в первых скобках выполняется, если запрос успешно отправлен и мы что то получили
                //do something
            }, { //во вторях скобках выполняется, если запрос не отправлен и нам пришла ошибка
                //do something
            })

    }
}