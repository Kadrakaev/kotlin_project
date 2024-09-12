package com.example.app_kotlin_kadrakaev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesApp()
        }
    }
}

@Composable
fun NotesApp() {
    var notes by remember { mutableStateOf(listOf<String>()) }
    var noteText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Заметки",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Column(modifier = Modifier.weight(1f)) {
            notes.forEach { note ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = 4.dp
                ) {
                    Text(
                        text = note,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = noteText,
                onValueChange = { noteText = it },
                label = { Text("Введите заметку") },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                if (noteText.isNotBlank()) {
                    notes = notes + noteText
                    noteText = ""
                }
            }) {
                Text("Добавить")
            }
        }
    }
}