package com.example.bmiapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            val btnCalculate = findViewById<Button>(R.id.btn_calculate)
            val edtWeight = findViewById<TextInputEditText>(R.id.edittext_weight)
            val edtHeight = findViewById<TextInputEditText>(R.id.edittext_height)

            btnCalculate.setOnClickListener {

                val weightStr: String = edtWeight.text.toString()
                val heightStr: String = edtHeight.text.toString()

                if (weightStr == "" || heightStr == "") {
                    Snackbar
                        .make(
                            edtWeight,
                            "Fill in all fields",
                            Snackbar.LENGTH_LONG
                        )
                        .show()

                } else {
                    val weight: Float = weightStr.toFloat()
                    val height: Float = heightStr.toFloat()

                    val finalHeight = height * height
                    val result = weight / finalHeight

                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra(KEY_BMI_RESULT, result)
                    startActivity(intent)

                }


            }
    }
}