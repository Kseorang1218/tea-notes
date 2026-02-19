package com.example.teanotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.teanotes.data.model.TeaRecord
import com.example.teanotes.ui.theme.TeaNotesTheme
import com.example.teanotes.ui.viewmodel.TeaViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.material3.ExperimentalMaterial3Api

@AndroidEntryPoint // Hilt가 의존성을 주입할 수 있도록 반드시 필요합니다.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TeaNotesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TeaListScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeaListScreen(viewModel: TeaViewModel = viewModel()) {
    // StateFlow를 Compose 상태로 변환하여 관찰
    val teaRecords by viewModel.teaRecords.collectAsState()

    Scaffold(
        topBar = {
            SmallTopAppBar(title = { Text("나의 차 시음 노트") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.addTestRecord() }) {
                Icon(Icons.Default.Add, contentDescription = "추가")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(teaRecords) { record ->
                TeaItemCard(record)
            }
        }
    }
}

@Composable
fun TeaItemCard(record: TeaRecord) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = record.name, style = MaterialTheme.typography.titleLarge)
            Text(text = "${record.brand} | ${record.type}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = record.memo, style = MaterialTheme.typography.bodySmall)
        }
    }
}