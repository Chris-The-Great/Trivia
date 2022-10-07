package com.example.trivia.di


import com.example.trivia.api.TriviaREImpl
import com.example.trivia.api.TriviaRe
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providesRespository(
        triviaREImpl: TriviaREImpl) : TriviaRe
}