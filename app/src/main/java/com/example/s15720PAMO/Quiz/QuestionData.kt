package com.example.s15720PAMO.Quiz

class QuestionData {
    private val mQuestions = arrayOf(
            "What is a coronavirus?",
            "What are the symptoms of someone infected with a coronavirus?",
            "COVID-'number'?",
            "How can I protect myself against infection?",
            "Can animals get coronavirus?",
            "where the coronavirus comes from"
    )
    private val mChoices = arrayOf(arrayOf("bacteria", "virus", "mushroom"), arrayOf("fever", "blindness", "deafness"), arrayOf("17", "9", "19"), arrayOf("go to the gym", "go on a walk", "stay in home"), arrayOf("Yes", "No", "don't know"), arrayOf("Russia", "Poland", "China"))
    private val mCorrectAnswers = arrayOf("virus", "fever", "19", "stay in home", "don't know", "China")
    fun getQuestion(a: Int): String {
        return mQuestions[a]
    }

    fun getChoice1(a: Int): String {
        return mChoices[a][0]
    }

    fun getChoice2(a: Int): String {
        return mChoices[a][1]
    }

    fun getChoice3(a: Int): String {
        return mChoices[a][2]
    }

    fun getCorrectAnswer(a: Int): String {
        return mCorrectAnswers[a]
    }
}
