package com.qoollo.hookah_center.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun HookahAppDefaultListItem(
    leadingImage: Painter,
    headlineText: String,
    supportText: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    ListItem(
        leadingContent = {
            Image(
                painter = leadingImage,
                contentDescription = null,
                modifier = Modifier.fillMaxHeight()
            )
        },
        headlineContent = { Text(text = headlineText) },
        supportingContent = { Text(text = supportText) },
        trailingContent = {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = null
            )
        },
        modifier = modifier
            .height(72.dp)
            .clickable { onClick() }
    )
}