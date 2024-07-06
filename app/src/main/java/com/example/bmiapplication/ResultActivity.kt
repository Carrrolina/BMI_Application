package com.example.bmiapplication

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_BMI_RESULT = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_BMI_RESULT, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassification = findViewById<TextView>(R.id.tv_classification)
        tvResult.text = result.toString()

        val classification: String = if (result < 18.5f) {
            getString(R.string.underweight)
        } else if (result in 18.5f..25f) {
            getString(R.string.normal_healthy_weight_)
        } else if (result in 25f..30f) {
            getString(R.string.overweight)
        } else if (result in 30f..35f) {
            getString(R.string.moderately_obese_class_i)
        } else if (result in 35f..40f) {
            getString(R.string.severely_obese_class_ii)
        } else {
            getString(R.string.very_severely_obese_class_iii)
        }

        tvClassification.text = classification
    }
}