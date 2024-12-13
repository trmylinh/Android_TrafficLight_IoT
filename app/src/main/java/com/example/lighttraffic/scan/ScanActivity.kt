package com.example.lighttraffic.scan

import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import androidx.appcompat.app.AppCompatActivity
import com.example.lighttraffic.R
import com.example.lighttraffic.databinding.ActivityScanBinding


class ScanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // underline text
        val content = SpannableString(getString(R.string.please_scan_the_master_unit_first))
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        binding.tvTitle.text = content

    }
}