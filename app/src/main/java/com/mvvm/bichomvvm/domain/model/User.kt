package com.mvvm.bichomvvm.domain.model

import com.mvvm.bichomvvm.utils.Constants.INFO_NOT_SET

data class User(
    val id: String = INFO_NOT_SET,
    val email: String = INFO_NOT_SET
)
