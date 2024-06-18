package com.example.calculatorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.calculatorapp.module.Calculator


class MainActivity : AppCompatActivity() {

    lateinit var textno1:EditText
    lateinit var textno2:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textno1 = findViewById(R.id.textno1)
        textno2 = findViewById(R.id.textno2)

    }
        fun buttonClick(v: View) {
            var ans = 0.0
            val calculator = Calculator(
                textno1.text.toString().toDouble(),
                textno2.text.toString().toDouble()
            )

            when (v.id) {
                R.id.button1 -> ans = calculator.add()
                R.id.button2 -> ans = calculator.subtract()
                R.id.button3 -> ans = calculator.multiply()
                R.id.button4 -> ans = calculator.divide()
            }

            println(ans)//this will print the output on the terminal


            val intent = Intent(this, Display::class.java)
            intent.putExtra("answer", ans)
            startActivity(intent)
            finish()

            var txtAnswer = findViewById<TextView>(R.id.textview2)
            txtAnswer.setText(intent.getDoubleExtra("answer", 0.0).toString())
            var btnBack = findViewById<Button>(R.id.button01)
            btnBack.setOnClickListener {
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }


}