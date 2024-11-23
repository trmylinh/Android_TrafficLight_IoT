package com.example.lighttraffic

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lighttraffic.databinding.ActivityConnectionBinding

class ConnectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConnectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConnectionBinding.inflate(layoutInflater)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(binding.root)
        binding.apply {
            homeButton.setOnClickListener {
                finish()
            }
        }


    }
}