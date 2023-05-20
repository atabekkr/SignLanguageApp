package com.atabekdev.signlanguage.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.atabekdev.signlanguage.R
import com.atabekdev.signlanguage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = this.getColor(R.color.purple_200)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}