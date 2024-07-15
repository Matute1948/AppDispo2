package com.lugmana_andres.appdispo2.ui.activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lugmana_andres.appdispo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
i
    }


}