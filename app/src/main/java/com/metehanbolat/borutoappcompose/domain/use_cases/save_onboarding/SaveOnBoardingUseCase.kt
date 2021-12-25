package com.metehanbolat.borutoappcompose.domain.use_cases.save_onboarding

import com.metehanbolat.borutoappcompose.data.repository.Repository

class SaveOnBoardingUseCase(private val repository: Repository) {

    suspend operator fun invoke(completed: Boolean){
        repository.saveOnBoardingState(completed = completed)
    }
}