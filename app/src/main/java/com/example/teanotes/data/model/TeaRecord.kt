package com.example.teanotes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tea_records")
data class TeaRecord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val brand: String,
    val type: String,
    val waterTemp: Int,
    val steepTime: Int,
    val rating: Float,
    val sweetness: Int,
    val bitterness: Int,
    val body: Int,
    val memo: String,
    val createdAt: Long = System.currentTimeMillis()
)