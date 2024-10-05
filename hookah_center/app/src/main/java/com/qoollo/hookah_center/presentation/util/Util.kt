package com.qoollo.hookah_center.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.qoollo.hookah_center.R


@Composable
fun roublePrice(price: Double): String =
    "${price.toInt()} ${stringResource(id = R.string.rouble)}"