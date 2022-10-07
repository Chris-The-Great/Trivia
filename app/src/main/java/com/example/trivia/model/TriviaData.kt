package com.example.trivia.model


import com.google.gson.annotations.SerializedName

data class TriviaData(
    @SerializedName("response_code")
    val responseCode: Int? = null,
    @SerializedName("results")
    val results: List<Result?>? = null
)