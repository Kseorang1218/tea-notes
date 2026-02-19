package com.example.teanotes.data.repository

import com.example.teanotes.data.local.TeaDao
import com.example.teanotes.data.model.TeaRecord
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeaRepository @Inject constructor(
    private val teaDao: TeaDao
) {
    // 모든 기록 가져오기 (실시간 Flow)
    val allRecords: Flow<List<TeaRecord>> = teaDao.getAllRecords()

    // 새 기록 저장
    suspend fun insert(record: TeaRecord) {
        teaDao.insertRecord(record)
    }

    // 기록 삭제
    suspend fun delete(id: Int) {
        teaDao.deleteRecordById(id)
    }
}