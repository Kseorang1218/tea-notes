package com.example.teanotes.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.teanotes.data.model.TeaRecord
import kotlinx.coroutines.flow.Flow

@Dao
interface TeaDao {
    @Query("SELECT * FROM tea_records ORDER BY createdAt DESC")
    fun getAllRecords(): Flow<List<TeaRecord>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecord(record: TeaRecord)

    @Query("DELETE FROM tea_records WHERE id = :id")
    suspend fun deleteRecordById(id: Int)
}