package com.example.myapplication.ui.components


import androidx.compose.runtime.Composable

@Composable
fun DatePickerField(
    label: String,
    date: String,
    onDateChange: (String) -> Unit
) {
    LabeledTextField(label = label, value = date, onValueChange = onDateChange)
    // TODO: replace with actual date picker dialog
}
