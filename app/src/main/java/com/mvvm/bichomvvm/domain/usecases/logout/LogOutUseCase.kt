package com.mvvm.bichomvvm.domain.usecases.logout

import com.mvvm.bichomvvm.domain.repository.LoginRepository
import com.mvvm.bichomvvm.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(): Flow<DataState<Boolean>> =
        loginRepository.logOut()
}