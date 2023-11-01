package com.mvvm.bichomvvm.domain.usecases.login

import com.mvvm.bichomvvm.domain.repository.LoginRepository
import com.mvvm.bichomvvm.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserDataUseCase  @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(): Flow<DataState<Boolean>> =
        loginRepository.getUserData()
}