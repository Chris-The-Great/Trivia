package com.example.trivia.api

import com.example.trivia.model.Trivia
import com.example.trivia.model.TriviaData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TriviaApi {

    @GET(Search_Path)
    suspend fun getTrivia(
        @Query("amount") qAmount: String
    ): Response<TriviaData>


    //"https://opentdb.com/api.php?amount=10&category=9&difficulty=easy&type=multiple"
    companion object {
        const val Base_Url = "https://opentdb.com/"
        const val Search_Path ="api.php"
    }

}