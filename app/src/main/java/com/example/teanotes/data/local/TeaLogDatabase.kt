package com.example.teanotes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.teanotes.data.model.TeaRecord

@Database(entities = [TeaRecord::class], version = 1, exportSchema = false)
abstract class TeaLogDatabase : RoomDatabase() {
    abstract fun teaDao(): TeaDao
}