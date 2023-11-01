package com.mvvm.bichomvvm.domain.usecases.login

import com.mvvm.bichomvvm.domain.repository.LoginRepository
import com.mvvm.bichomvvm.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(email: String, password: String): Flow<DataState<Boolean>> =
        loginRepository.login(email, password)
}