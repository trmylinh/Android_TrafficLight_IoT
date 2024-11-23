package com.example.lighttraffic

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.lighttraffic.databinding.ActivityControllerBinding
import java.text.DecimalFormat

class ControllerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityControllerBinding
    private val decimalFormat = DecimalFormat("00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityControllerBinding.inflate(layoutInflater)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(binding.root)

        binding.apply {
            homeIcon.setOnClickListener {
                finish()
            }

            var currentNumberGreen = greenAText.text.toString().toInt()
            buttonAGreenUp.setOnClickListener {
                currentNumberGreen++
                greenAText.text = decimalFormat.format(currentNumberGreen)
            }

            buttonAGreenDown.setOnClickListener {
                currentNumberGreen--
                greenAText.text = decimalFormat.format(currentNumberGreen)
            }

            var currentNumberYellow = yellowAText.text.toString().toInt()
            buttonAYellowUp.setOnClickListener {
                currentNumberYellow++
                yellowAText.text = decimalFormat.format(currentNumberYellow)
            }

            buttonAYellowDown.setOnClickListener {
                currentNumberYellow--
                yellowAText.text = decimalFormat.format(currentNumberYellow)
            }

            var currentNumberRed = redAText.text.toString().toInt()
            buttonARedUp.setOnClickListener {
                currentNumberRed++
                redAText.text = decimalFormat.format(currentNumberRed)
            }

            buttonARedDown.setOnClickListener {
                currentNumberRed--
                redAText.text = decimalFormat.format(currentNumberRed)
            }

            switchWarning.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    groupA.setBackgroundResource(R.drawable.disable_border)
                    groupTitleA.setBackgroundResource(R.drawable.rounded_disable_background)

                    for (i in 0 until groupA.childCount) {
                        groupA.getChildAt(i).visibility = View.GONE
                    }

                    groupB.setBackgroundResource(R.drawable.disable_border)
                    groupTitleB.setBackgroundResource(R.drawable.rounded_disable_background)

                    for (i in 0 until groupB.childCount) {
                        groupB.getChildAt(i).visibility = View.GONE
                    }
                } else {
                    groupA.setBackgroundResource(R.drawable.green_border)
                    groupTitleA.setBackgroundResource(R.drawable.rounded_green_background)

                    for (i in 0 until groupA.childCount) {
                        groupA.getChildAt(i).visibility = View.VISIBLE
                    }

                    groupB.setBackgroundResource(R.drawable.red_border)
                    groupTitleB.setBackgroundResource(R.drawable.rounded_red_background)

                    for (i in 0 until groupB.childCount) {
                        groupB.getChildAt(i).visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}