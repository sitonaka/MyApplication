package com.example.myapplication

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlin.coroutines.Continuation

enum class DialogData(
    val kick: String,
    val title: String,
    val message: String,
    val positive: String,
    val negative: String
) {
    COUNT_UP(
        "カウントアップ",
        "確認してください",
        "カウントアップしますか？",
        "OK",
        "CANCEL"
    ),
    COUNT_DOWN(
        "カウントダウン",
        "確認してください",
        "カウントダウンしますか？",
        "OK",
        "CANCEL"
    )
}

private var dialogContinuation: Continuation<Boolean>? = null

@Composable
fun DialogContent(
    content: @Composable (showDialog: suspend (dialogData: DialogData) -> Boolean) -> Unit
) {
    val isVisible = remember { mutableStateOf(false) }
    val dialogData = remember { mutableStateOf(DialogData.COUNT_UP) }
    // content{}
    if (isVisible.value) {
        AlertDialog(
            onDismissRequest = {},
            confirmButton = {
                Button(onClick = {
                    isVisible.value = false
                }) {
                    Text(text = dialogData.value.positive)
                }
            },
            dismissButton = {
                Button(onClick = {
                    isVisible.value = false
                }) {
                    Text(text = dialogData.value.negative)
                }
            },
            title = { Text(text = dialogData.value.title) },
            text = { Text(text = dialogData.value.message) }
        )
    }
}
