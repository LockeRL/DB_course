package com.qoollo.hookah_center.presentation.common

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import com.qoollo.hookah_center.R
import com.qoollo.hookah_center.presentation.ui.theme.BlueLink
import com.qoollo.hookah_center.presentation.ui.theme.Typography

@Composable
fun HookahAppDefaultButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        ),
        modifier = modifier
    ) {
        Text(
            text = text,
            style = Typography.bodyLarge
        )
    }
}

@Composable
fun HookahAppDefaultTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(onClick = onClick, modifier = modifier) {
        Text(
            text = text,
            style = Typography.bodyLarge.copy(
                textDecoration = TextDecoration.Underline
            ),
            color = BlueLink
        )
    }
}