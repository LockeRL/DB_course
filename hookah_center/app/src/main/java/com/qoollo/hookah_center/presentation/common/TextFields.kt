package com.qoollo.hookah_center.presentation.common

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HookahAppDefaultOutlinedTextField(
    text: String,
    label: String,
    modifier: Modifier = Modifier,
    onValueChanged: (String) -> Unit = {},
    readOnly: Boolean = false,
    singleLine: Boolean = true
) {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChanged,
        label = { Text(text = label) },
        modifier = modifier,
        readOnly = readOnly,
        singleLine = singleLine
    )
}