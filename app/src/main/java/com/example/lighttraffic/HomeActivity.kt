package com.example.lighttraffic

import android.app.AlertDialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lighttraffic.databinding.ActivityHomeBinding
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        setContentView(binding.root)

        binding.apply {
            seriButton.setOnClickListener {
                showInputDialog()
            }

            qrButton.setOnClickListener {
                scannerLauncher.launch(
                    ScanOptions().setPrompt("Scan Qr Code")
                        .setDesiredBarcodeFormats(ScanOptions.QR_CODE)
                        .setOrientationLocked(false) // ho tro xoay ngang/doc
                        .setBeepEnabled(true) // bat am bao khi quet thanh cong
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
            val intent = Intent(this@HomeActivity, MainMenuActivity::class.java)
            intent.putExtra("scannedData", scannedData)
            startActivity(intent)
            finish()
        }
    }

    private fun showInputDialog() {
        val editText = EditText(this)
        val dialog = AlertDialog.Builder(this)
            .setTitle("Enter serial number")
            .setView(editText)
            .setPositiveButton("OK") { _, _ ->
                val input = editText.text.toString()
                if (input.isNotEmpty()) {
                    val intent = Intent(this, MainMenuActivity::class.java)
                    intent.putExtra("serialNumber", input)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Please enter serial number!!!", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel") { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            .create()

        dialog.show()
    }
}