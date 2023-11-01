package com.mvvm.bichomvvm.domain.usecases.signup

import com.mvvm.bichomvvm.domain.model.User
import com.mvvm.bichomvvm.domain.repository.LoginRepository
import com.mvvm.bichomvvm.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(user: User, password: String): Flow<DataState<User>> =
        loginRepository.signUp(user, password)

}