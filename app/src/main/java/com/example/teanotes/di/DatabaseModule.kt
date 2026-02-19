package com.example.teanotes.di

import android.content.Context
import androidx.room.Room
import com.example.teanotes.data.local.TeaDao
import com.example.teanotes.data.local.TeaLogDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TeaLogDatabase {
        return Room.databaseBuilder(
            context,
            TeaLogDatabase::class.java,
            "tealog_db"
        ).build()
    }

    @Provides
    fun provideTeaDao(database: TeaLogDatabase): TeaDao = database.teaDao()
}