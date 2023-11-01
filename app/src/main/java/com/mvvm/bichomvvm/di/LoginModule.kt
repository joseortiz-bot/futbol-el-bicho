package com.mvvm.bichomvvm.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.mvvm.bichomvvm.data.remote.LoginRepositoryImpl
import com.mvvm.bichomvvm.domain.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LoginModule {

    @Provides
    @Singleton
    fun provideLoginRepository(
        auth: FirebaseAuth,
        @FirebaseModule.UsersCollection usersCollection: CollectionReference
    ): LoginRepository {
        return LoginRepositoryImpl(
            auth, usersCollection
        )
    }



}