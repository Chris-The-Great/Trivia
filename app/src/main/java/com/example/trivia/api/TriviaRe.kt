package com.example.trivia.api

import android.util.Log
import com.example.trivia.model.mapToAnswers
import com.example.trivia.views.MainFragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


interface TriviaRe {
    fun getTriviaQ() : Flow<UIState>
}

class TriviaREImpl @Inject constructor(
    private val triviaApi :TriviaApi
) : TriviaRe{
    override fun getTriviaQ(): Flow<UIState> = flow {
        emit(UIState.LOADING)

        try {
            Log.d("Yes", MainFragment.qAmount)
            val response = triviaApi.getTrivia(qAmount = MainFragment.qAmount)
            if (response.isSuccessful){
                response.body()?.let {
                    emit(UIState.SUCCESS(it.results.mapToAnswers()))
                } ?: throw NullResponseFromServer("Null")
            }
            else{
                throw FailureResponseFromServer(response.errorBody()?.string())
            }
        } catch (e :Exception){
            emit(UIState.ERROR(e))
        }
    }

}