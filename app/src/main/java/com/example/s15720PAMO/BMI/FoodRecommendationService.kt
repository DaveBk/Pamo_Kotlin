package com.example.s15720PAMO.BMI

class FoodRecommendationService {
    fun recommendedFood(bmi: Float): String {
        return if (bmi < NORMAL_DOWN_VALUE) {
            "Eat more pizza"
        } else if (NORMAL_DOWN_VALUE < bmi && bmi < NORMAL_TOP_VALUE) {
            "Eat pizza and vegetables"
        } else {
            "Eat vegetables"
        }
    }

    companion object {
        private const val NORMAL_DOWN_VALUE = 17.2f
        private const val NORMAL_TOP_VALUE = 30.0f
    }
}