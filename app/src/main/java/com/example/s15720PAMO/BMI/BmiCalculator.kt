package com.example.s15720PAMO.BMI

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.s15720PAMO.R

class BmiCalculator : AppCompatActivity() {
    private var foodRecommendationService: FoodRecommendationService? = null
    private var height: EditText? = null
    private var weight: EditText? = null
    private var age: EditText? = null
    private var resultBmi: TextView? = null
    private var resultFood: TextView? = null
    private var radioSexGroup: RadioGroup? = null
    private var radioSexButton: RadioButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi_calculator)
        height = findViewById(R.id.height)
        weight = findViewById(R.id.weight)
        age = findViewById(R.id.age)
        resultBmi = findViewById(R.id.resultBmi)
        resultFood = findViewById(R.id.resultFood)
    }

    fun calculateBMI(v: View?) {
        val heightStr = height!!.text.toString()
        val weightStr = weight!!.text.toString()
        val ageStr = age!!.text.toString()
        if (heightStr != null && "" != heightStr
                && weightStr != null && "" != weightStr) {
            val heightValue: Float = heightStr.toFloat() / 100
            val weightValue: Float = weightStr.toFloat()
            val bmi = weightValue / (heightValue * heightValue)
            val sex = addListenerOnButton()
            val bhc = calculateBHC(heightStr, weightStr, ageStr, sex)
            displayBMI(bmi, bhc)
        }
    }

    private fun calculateBHC(heightStr: String, weightStr: String, ageStr: String, sex: String): Float {
        val heightValue: Float = heightStr.toFloat()
        val weightValue: Float = weightStr.toFloat()
        val ageValue: Float = ageStr.toFloat()
        var result = 0f
        if (sex == getString(R.string.female)) {
            result = 655.1f + 9.563f * weightValue + 1.85f * heightValue - 4.676f * ageValue
        } else if (sex == getString(R.string.male)) {
            result = 66.5f + 13.75f * weightValue + 5.003f * heightValue - 6.775f * ageValue
        }
        return result
    }

    private fun displayBMI(bmi: Float, bhc: Float) {
        var bmiLabel = ""
        foodRecommendationService = FoodRecommendationService()
        bmiLabel = if (java.lang.Float.compare(bmi, 15f) <= 0) {
            getString(R.string.wyglodzenie)
        } else if (java.lang.Float.compare(bmi, 15f) > 0 && java.lang.Float.compare(bmi, 16f) <= 0) {
            getString(R.string.wychudzenie)
        } else if (java.lang.Float.compare(bmi, 16f) > 0 && java.lang.Float.compare(bmi, 18.5f) <= 0) {
            getString(R.string.niedowaga)
        } else if (java.lang.Float.compare(bmi, 18.5f) > 0 && java.lang.Float.compare(bmi, 25f) <= 0) {
            getString(R.string.wartosc_prawidlowa)
        } else if (java.lang.Float.compare(bmi, 25f) > 0 && java.lang.Float.compare(bmi, 30f) <= 0) {
            getString(R.string.nadwaga)
        } else if (java.lang.Float.compare(bmi, 30f) > 0 && java.lang.Float.compare(bmi, 35f) <= 0) {
            getString(R.string.I_stopien_otylosci)
        } else if (java.lang.Float.compare(bmi, 35f) > 0 && java.lang.Float.compare(bmi, 40f) <= 0) {
            getString(R.string.II_stopien_otylosci)
        } else {
            getString(R.string.otyłosc_skrajna)
        }
        bmiLabel = "BMI = $bmi: $bmiLabel\n\nCalories per day $bhc"
        resultBmi!!.text = bmiLabel
        resultFood!!.text = foodRecommendationService!!.recommendedFood(bmi)
    }

    fun addListenerOnButton(): String {
        radioSexGroup = findViewById<View>(R.id.radioSex) as RadioGroup
        // get selected radio button from radioGroup
        val selectedId = radioSexGroup!!.checkedRadioButtonId
        // find the radiobutton by returned id
        radioSexButton = findViewById<View>(selectedId) as RadioButton
        return radioSexButton!!.text.toString()
    }
}