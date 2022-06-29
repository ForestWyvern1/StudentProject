package com.nvah.studentproject.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.nvah.studentproject.R
import com.nvah.studentproject.databinding.ActivityMainBinding
import com.nvah.studentproject.fragments.FirstFragment
import com.nvah.studentproject.fragments.SecondFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeFragment(FirstFragment())

        binding.bottomNavigationBar.setOnNavigationItemSelectedListener {

            when (it.itemId){

                //айдишники наших item, которые мы написали в menu файле
                R.id.firstButton -> {
                    changeFragment(FirstFragment())
                }

                R.id.secondButton -> {
                    changeFragment(SecondFragment())
                }

            }

            true
        }

    }

    private fun changeFragment(fmt : Fragment){
        supportFragmentManager.beginTransaction().replace(binding.fragmentHolder.id, fmt).commit()
    }

}