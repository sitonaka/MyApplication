package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

@Composable
fun DialogTestScreen() {
    val counter = rememberSaveable { mutableStateOf(0) }
    val scope = rememberCoroutineScope()
    DialogContent { showDialog ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = counter.value.toString())
            Button(onClick = {
                scope.launch {
                    val result = showDialog(DialogData.COUNT_UP)
                    if (result) {
                        counter.value++
                    }
                }
            }) {
                Text(text = DialogData.COUNT_UP.kick)
            }
            Button(onClick = {
                scope.launch {
                    val result = showDialog(DialogData.COUNT_DOWN)
                    if (result) {
                        counter.value--
                    }
                }
            }) {
                Text(text = DialogData.COUNT_DOWN.kick)
            }
        }
    }
}

@Preview(showBackground = true, name = "dialog test")
@Composable
fun DialogTestPreview() {
    MyApplicationTheme {
        DialogTestScreen()
    }
}