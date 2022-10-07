package com.example.trivia.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trivia.api.TriviaRe
import com.example.trivia.api.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TriviaViewModel @Inject constructor(
    private val re : TriviaRe,
    private val ioDispatcher: CoroutineDispatcher
): ViewModel(){

    private val _trivia: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val trivia: LiveData<UIState> get() = _trivia

    init {
        //getTrivia()
    }

     fun getTrivia() {
        viewModelScope.launch (ioDispatcher){
            re.getTriviaQ().collect(){
                _trivia.postValue(it)
            }
        }
    }

}