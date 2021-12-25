package com.metehanbolat.borutoappcompose.domain.use_cases

import com.metehanbolat.borutoappcompose.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.metehanbolat.borutoappcompose.domain.use_cases.save_onboarding.SaveOnBoardingUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase
)
