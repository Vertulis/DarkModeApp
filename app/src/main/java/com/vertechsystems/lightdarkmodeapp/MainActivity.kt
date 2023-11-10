package com.vertechsystems.lightdarkmodeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.vertechsystems.lightdarkmodeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("sp", MODE_PRIVATE)

        var editor = sharedPreferences.edit()
        var isDarkMode = sharedPreferences.getBoolean("isDarkMode", false)

        if(isDarkMode){
            goInDarkMode()
            binding.switch1.isChecked = true
        }
        binding.switch1.setOnCheckedChangeListener { button, isChecked ->
            if (isChecked) {
                goInDarkMode()
                editor.putBoolean("isDarkMode", true)
                editor.apply()
            } else {
                goInLightMode()
                editor.putBoolean("isDarkMode", false)
                editor.apply()
            }
        }
    }

    private fun goInLightMode() {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun goInDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }
}