package com.example.lighttraffic

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lighttraffic.databinding.ActivitySettingBinding
import com.google.android.material.tabs.TabLayout

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(binding.root)

        binding.apply {
            homeIcon.setOnClickListener {
                finish()
            }

            buttonGroup.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    when (tab?.position) {
                        0 -> {
                            // traffic light
                            slave1Icon.setBackgroundResource(R.drawable.traffic_light_rotate_disable)
                            slave2Icon.setBackgroundResource(R.drawable.traffic_light_rotate_disable)
                            slave3Icon.setBackgroundResource(R.drawable.traffic_light_rotate_disable)

                            // slave text
                            slave1Text.setTextColor(getColorStateList(R.color.dark_text))
                            slave2Text.setTextColor(getColorStateList(R.color.dark_text))
                            slave3Text.setTextColor(getColorStateList(R.color.dark_text))

                            // info
                            slave1Sn.setTextColor(getColorStateList(R.color.dark_text))
                            slave1Name.setTextColor(getColorStateList(R.color.dark_text))
                            slave1Group.setTextColor(getColorStateList(R.color.dark_text))

                            slave2Sn.setTextColor(getColorStateList(R.color.dark_text))
                            slave2Name.setTextColor(getColorStateList(R.color.dark_text))
                            slave2Group.setTextColor(getColorStateList(R.color.dark_text))

                            slave3Sn.setTextColor(getColorStateList(R.color.dark_text))
                            slave3Name.setTextColor(getColorStateList(R.color.dark_text))
                            slave3Group.setTextColor(getColorStateList(R.color.dark_text))

                            // disconnect - connect
                            disconnectSlave1.setBackgroundResource(R.drawable.disconnect)
                            disconnectSlave2.setBackgroundResource(R.drawable.disconnect)
                            disconnectSlave3.setBackgroundResource(R.drawable.disconnect)

                        }

                        1 -> {
                            slave1Icon.setBackgroundResource(R.drawable.traffic_light_rotate)
                            slave2Icon.setBackgroundResource(R.drawable.traffic_light_rotate_disable)
                            slave3Icon.setBackgroundResource(R.drawable.traffic_light_rotate_disable)

                            slave1Text.setTextColor(getColorStateList(R.color.red_text))
                            slave2Text.setTextColor(getColorStateList(R.color.dark_text))
                            slave3Text.setTextColor(getColorStateList(R.color.dark_text))

                            // info
                            //layout
                            slave1SnLayout.setBackgroundResource(R.drawable.layout_border)
                            slave1SnLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            slave1NameLayout.setBackgroundResource(R.drawable.layout_border)
                            slave1NameLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            slave1GroupLayout.setBackgroundResource(R.drawable.layout_border)
                            slave1GroupLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            slave2SnLayout.setBackgroundResource(R.drawable.layout_border_disconnect)
                            slave2SnLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line_disconnect
                            )

                            slave2NameLayout.setBackgroundResource(R.drawable.layout_border_disconnect)
                            slave2NameLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line_disconnect
                            )

                            slave2GroupLayout.setBackgroundResource(R.drawable.layout_border_disconnect)
                            slave2GroupLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line_disconnect
                            )

                            slave3SnLayout.setBackgroundResource(R.drawable.layout_border_disconnect)
                            slave3SnLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line_disconnect
                            )

                            slave3NameLayout.setBackgroundResource(R.drawable.layout_border_disconnect)
                            slave3NameLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line_disconnect
                            )

                            slave3GroupLayout.setBackgroundResource(R.drawable.layout_border_disconnect)
                            slave3GroupLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line_disconnect
                            )

                            // text
                            slave1Sn.setTextColor(getColorStateList(R.color.black))
                            slave1Name.setTextColor(getColorStateList(R.color.black))
                            slave1Group.setTextColor(getColorStateList(R.color.black))

                            slave2Sn.setTextColor(getColorStateList(R.color.dark_text))
                            slave2Name.setTextColor(getColorStateList(R.color.dark_text))
                            slave2Group.setTextColor(getColorStateList(R.color.dark_text))

                            slave3Sn.setTextColor(getColorStateList(R.color.dark_text))
                            slave3Name.setTextColor(getColorStateList(R.color.dark_text))
                            slave3Group.setTextColor(getColorStateList(R.color.dark_text))

                            disconnectSlave1.setBackgroundResource(R.drawable.connect)
                            disconnectSlave2.setBackgroundResource(R.drawable.disconnect)
                            disconnectSlave3.setBackgroundResource(R.drawable.disconnect)
                        }

                        2 -> {
                            slave2Icon.setBackgroundResource(R.drawable.traffic_light_rotate)
                            slave1Icon.setBackgroundResource(R.drawable.traffic_light_rotate)
                            slave3Icon.setBackgroundResource(R.drawable.traffic_light_rotate_disable)

                            slave1Text.setTextColor(getColorStateList(R.color.red_text))
                            slave2Text.setTextColor(getColorStateList(R.color.red_text))
                            slave3Text.setTextColor(getColorStateList(R.color.dark_text))

                            // info
                            //layout
                            slave1SnLayout.setBackgroundResource(R.drawable.layout_border)
                            slave1SnLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            slave1NameLayout.setBackgroundResource(R.drawable.layout_border)
                            slave1NameLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            slave1GroupLayout.setBackgroundResource(R.drawable.layout_border)
                            slave1GroupLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            slave2SnLayout.setBackgroundResource(R.drawable.layout_border)
                            slave2SnLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            slave2NameLayout.setBackgroundResource(R.drawable.layout_border)
                            slave2NameLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            slave2GroupLayout.setBackgroundResource(R.drawable.layout_border)
                            slave2GroupLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            slave3SnLayout.setBackgroundResource(R.drawable.layout_border_disconnect)
                            slave3SnLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line_disconnect
                            )

                            slave3NameLayout.setBackgroundResource(R.drawable.layout_border_disconnect)
                            slave3NameLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line_disconnect
                            )

                            slave3GroupLayout.setBackgroundResource(R.drawable.layout_border_disconnect)
                            slave3GroupLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line_disconnect
                            )

                            //text
                            slave1Sn.setTextColor(getColorStateList(R.color.black))
                            slave1Name.setTextColor(getColorStateList(R.color.black))
                            slave1Group.setTextColor(getColorStateList(R.color.black))

                            slave2Sn.setTextColor(getColorStateList(R.color.black))
                            slave2Name.setTextColor(getColorStateList(R.color.black))
                            slave2Group.setTextColor(getColorStateList(R.color.black))

                            slave3Sn.setTextColor(getColorStateList(R.color.dark_text))
                            slave3Name.setTextColor(getColorStateList(R.color.dark_text))
                            slave3Group.setTextColor(getColorStateList(R.color.dark_text))

                            disconnectSlave1.setBackgroundResource(R.drawable.connect)
                            disconnectSlave2.setBackgroundResource(R.drawable.connect)
                            disconnectSlave3.setBackgroundResource(R.drawable.disconnect)
                        }

                        3 -> {
                            slave3Icon.setBackgroundResource(R.drawable.traffic_light_rotate)
                            slave1Icon.setBackgroundResource(R.drawable.traffic_light_rotate)
                            slave2Icon.setBackgroundResource(R.drawable.traffic_light_rotate)

                            slave1Text.setTextColor(getColorStateList(R.color.red_text))
                            slave2Text.setTextColor(getColorStateList(R.color.red_text))
                            slave3Text.setTextColor(getColorStateList(R.color.red_text))

                            // info
                            //layout
                            slave1SnLayout.setBackgroundResource(R.drawable.layout_border)
                            slave1SnLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            slave1NameLayout.setBackgroundResource(R.drawable.layout_border)
                            slave1NameLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            slave1GroupLayout.setBackgroundResource(R.drawable.layout_border)
                            slave1GroupLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            slave2SnLayout.setBackgroundResource(R.drawable.layout_border)
                            slave2SnLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            slave2NameLayout.setBackgroundResource(R.drawable.layout_border)
                            slave2NameLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            slave2GroupLayout.setBackgroundResource(R.drawable.layout_border)
                            slave2GroupLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            slave3SnLayout.setBackgroundResource(R.drawable.layout_border)
                            slave3SnLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            slave3NameLayout.setBackgroundResource(R.drawable.layout_border)
                            slave3NameLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            slave3GroupLayout.setBackgroundResource(R.drawable.layout_border)
                            slave3GroupLayout.dividerDrawable = AppCompatResources.getDrawable(
                                this@SettingActivity,
                                R.drawable.divider_line
                            )

                            //text
                            slave1Sn.setTextColor(getColorStateList(R.color.black))
                            slave1Name.setTextColor(getColorStateList(R.color.black))
                            slave1Group.setTextColor(getColorStateList(R.color.black))

                            slave2Sn.setTextColor(getColorStateList(R.color.black))
                            slave2Name.setTextColor(getColorStateList(R.color.black))
                            slave2Group.setTextColor(getColorStateList(R.color.black))

                            slave3Sn.setTextColor(getColorStateList(R.color.black))
                            slave3Name.setTextColor(getColorStateList(R.color.black))
                            slave3Group.setTextColor(getColorStateList(R.color.black))

                            disconnectSlave1.setBackgroundResource(R.drawable.connect)
                            disconnectSlave2.setBackgroundResource(R.drawable.connect)
                            disconnectSlave3.setBackgroundResource(R.drawable.connect)
                        }
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {}

                override fun onTabReselected(tab: TabLayout.Tab?) {}

            })
        }
    }
}