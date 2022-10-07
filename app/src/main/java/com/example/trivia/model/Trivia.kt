package com.example.trivia.model

import android.os.Parcelable
import android.util.Log
import com.example.trivia.model.Result
import kotlinx.parcelize.Parcelize

@Parcelize
data class Trivia (
    val questions : String = "Invalid",
    val correct : String = "Invalid",
    val difficulty : String = "Invalid",
    val answer1 : String = "Invalid",
    val answer2 : String = "Invalid",
    val answer3 : String = "Invalid",
    val category : String = "Invalid"
        ) : Parcelable

fun List<Result?>?.mapToAnswers() : List<Trivia> =
    this?.map {
        Trivia(// use inded to join to string
            questions= it?.question?: "Invaild",
            correct= it?.correctAnswer?: "Invaild",
            difficulty= it?.difficulty?: "Invaild",
            category = it?.category?: "Invaild",
            answer1 = it?.incorrectAnswers?.get(0).toString()?: "",
            answer2 = it?.incorrectAnswers?.get(1).toString()?: "",
            answer3 = it?.incorrectAnswers?.get(2).toString()?: "",

        )
    } ?: emptyList()
