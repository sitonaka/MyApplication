package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun DialogTestScreen() {
    val showDialog = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(onClick = {
            showDialog.value = true
        }) {
            Text(text = "BUTTON")
        }
    }
    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = {},
            confirmButton = {
                Button(onClick = {
                    showDialog.value = false
                }) {
                    Text(text = "OK")
                }
            },
            dismissButton = {
                Button(onClick = {
                    showDialog.value = false
                }) {
                    Text(text = "CANCEL")
                }
            },
            title = { Text(text = "TITLE") },
            text = { Text(text = "TEXT") })
    }
}

@Preview(showBackground = true, name = "dialog test")
@Composable
fun DialogTestPreview() {
    MyApplicationTheme {
        DialogTestScreen()
    }
}