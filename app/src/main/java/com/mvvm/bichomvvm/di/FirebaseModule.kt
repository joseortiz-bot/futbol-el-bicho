package com.mvvm.bichomvvm.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.mvvm.bichomvvm.utils.Constants.USERS_COLLECTION
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @UsersCollection
    @Provides
    @Singleton
    fun provideUsersCollection(
        firestore: FirebaseFirestore
    ): CollectionReference {
        return firestore.collection(USERS_COLLECTION)
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class UsersCollection
}