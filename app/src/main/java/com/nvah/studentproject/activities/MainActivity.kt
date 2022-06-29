package com.nvah.studentproject.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nvah.studentproject.adapters.BasicRecyclerViewAdapter
import com.nvah.studentproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainRv.layoutManager = LinearLayoutManager(this)
        binding.mainRv.adapter =
            BasicRecyclerViewAdapter(this) //для комбинированного тоже самое, но у него есть и второй параметр


    }
}