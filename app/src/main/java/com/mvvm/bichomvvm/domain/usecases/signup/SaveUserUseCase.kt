package com.mvvm.bichomvvm.domain.usecases.signup

import com.mvvm.bichomvvm.domain.model.User
import com.mvvm.bichomvvm.domain.repository.LoginRepository
import com.mvvm.bichomvvm.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(user: User): Flow<DataState<Boolean>> =
        loginRepository.saveUser(user)
}