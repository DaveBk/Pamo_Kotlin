package com.example.s15720PAMO

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.s15720PAMO.BMI.BmiCalculator
import com.example.s15720PAMO.Chart.ChartMenuActivity
import com.example.s15720PAMO.Quiz.QuizActivity


class MainActivity : AppCompatActivity() {
    private var buttonBmi: Button? = null
    private var buttonQuiz: Button? = null
    private var buttonCovid: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonBmi = findViewById(R.id.buttonBmi)
        buttonBmi?.setOnClickListener(View.OnClickListener { openCalcActivity() })
        buttonQuiz = findViewById(R.id.buttonQuiz)
        buttonQuiz?.setOnClickListener(View.OnClickListener { openQuizActivity() })
        buttonCovid = findViewById(R.id.buttonCovid)
        buttonCovid?.setOnClickListener(View.OnClickListener { openChartActivity() })
    }

    fun openCalcActivity() {
        val intent = Intent(this, BmiCalculator::class.java)
        startActivity(intent)
    }

    fun openQuizActivity() {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }

    fun openChartActivity() {
        val intent = Intent(this, ChartMenuActivity::class.java)
        startActivity(intent)
    }
}
