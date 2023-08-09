package com.example.mteam.di

import android.content.SharedPreferences
import com.example.mteam.data.repository.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {  //this module for digger hilt to communicate with repository

    @Provides
    @Singleton
    fun provideNoteRepository(
        database: FirebaseFirestore
//        storageReference: StorageReference
    ): PlayersNoteRepository{
        return PlayersNoteRepositoryImp(database)
    }

//    @Provides
//    @Singleton
//    fun provideTaskRepository(
//        database: FirebaseDatabase
//    ): TaskRepository{
//        return TaskRepositoryImp(database)
//    }
//
//    @Provides
//    @Singleton
//    fun provideAutghRepository(
//        database: FirebaseFirestore,
//        auth: FirebaseAuth,
//        appPreferences: SharedPreferences,
//        gson: Gson
//    ): AuthRepository {
//        return AuthRepositoryImp(auth,database,appPreferences,gson)
//    }
}