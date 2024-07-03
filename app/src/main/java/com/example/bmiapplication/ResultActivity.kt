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
            "Underweight"
        } else if (result in 18.5f..25f) {
            "Normal (healthy weight)"
        } else if (result in 25f..30f) {
            "Overweight"
        } else if (result in 30f..35f) {
            "Moderately obese (Class I)"
        } else if (result in 35f..40f) {
            "Severely obese (Class II)"
        } else {
            "Very severely obese (Class III)"
        }

        tvClassification.text = classification
    }
}