package com.example.lighttraffic

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lighttraffic.databinding.ActivityMainHomeBinding
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions

class MainHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainHomeBinding.inflate(layoutInflater)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(binding.root)

        val scannedData = intent.getStringExtra("scannedData")
        val serialNumber = intent.getStringExtra("serialNumber")

        binding.apply {
            serialNumberValue.text = scannedData ?: serialNumber

            connectionButton.setOnClickListener {
                val intent = Intent(this@MainHomeActivity, ConnectionActivity::class.java)
                startActivity(intent)
            }
            settingButton.setOnClickListener {
                val intent = Intent(this@MainHomeActivity, SettingActivity::class.java)
                startActivity(intent)
            }
            controllerButton.setOnClickListener {
                val intent = Intent(this@MainHomeActivity, ControllerActivity::class.java)
                startActivity(intent)
            }
            rescanButton.setOnClickListener {
                scannerLauncher.launch(
                    ScanOptions().setPrompt("Scan Qr Code")
                        .setDesiredBarcodeFormats(ScanOptions.QR_CODE)
                        .setOrientationLocked(false)
                        .setBeepEnabled(true)
                )
            }
        }

    }

    private val scannerLauncher = registerForActivityResult<ScanOptions, ScanIntentResult>(
        ScanContract()
    ) { result ->

        if (result.contents == null) {
            Toast.makeText(this, "Scan cancelled", Toast.LENGTH_SHORT).show()
        } else {
            val scannedData = result.contents
            binding.serialNumberValue.text = scannedData
        }
    }
}