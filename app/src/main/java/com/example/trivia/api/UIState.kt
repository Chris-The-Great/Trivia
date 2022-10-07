package com.example.trivia.api

import com.example.trivia.model.Trivia

sealed class UIState{
    object LOADING : UIState()
    data class SUCCESS(val trivia : List<Trivia>) : UIState()
    data class ERROR(val error : Exception) : UIState()
}
