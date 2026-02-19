package com.example.teanotes.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teanotes.data.model.TeaRecord
import com.example.teanotes.data.repository.TeaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeaViewModel @Inject constructor(
    private val repository: TeaRepository
) : ViewModel() {

    // DB의 데이터를 관찰 가능한 StateFlow로 변환 (UI 자동 갱신용)
    val teaRecords: StateFlow<List<TeaRecord>> = repository.allRecords
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    // 테스트용 데이터 추가 함수
    fun addTestRecord() {
        viewModelScope.launch {
            repository.insert(
                TeaRecord(
                    name = "우전 녹차",
                    brand = "오설록",
                    type = "녹차",
                    waterTemp = 70,
                    steepTime = 120,
                    rating = 4.5f,
                    sweetness = 3,
                    bitterness = 2,
                    body = 2,
                    memo = "첫물 차라 그런지 아주 깔끔함."
                )
            )
        }
    }
}