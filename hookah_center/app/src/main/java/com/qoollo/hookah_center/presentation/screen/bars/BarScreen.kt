package com.qoollo.hookah_center.presentation.screen.bars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.qoollo.hookah_center.R
import com.qoollo.hookah_center.presentation.common.HookahAppDefaultButton
import com.qoollo.hookah_center.presentation.common.HookahAppDefaultOutlinedTextField
import com.qoollo.hookah_center.presentation.model.BarViewData
import com.qoollo.hookah_center.presentation.ui.theme.Typography
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.BarViewModel

@Composable
fun BarScreen(
    viewModel: BarViewModel,
    onClickNavigateFood: () -> Unit,
    onClickNavigateHookahs: () -> Unit,
    onClickNavigateDrinks: () -> Unit
) {
    val barState by viewModel.bar.collectAsState()
    val bar = barState

    if (bar == null)
        Text(text = "")
    else
        BarInfo(
            bar = bar,
            onClickNavigateFood = onClickNavigateFood,
            onClickNavigateHookahs = onClickNavigateHookahs,
            onClickNavigateDrinks = onClickNavigateDrinks
        )
}

@Composable
fun BarInfo(
    bar: BarViewData,
    onClickNavigateFood: () -> Unit,
    onClickNavigateHookahs: () -> Unit,
    onClickNavigateDrinks: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = bar.name,
            style = Typography.titleLarge
        )

        val fillMaxWidthModifier = Modifier.fillMaxWidth()
        HookahAppDefaultOutlinedTextField(
            text = bar.city,
            label = stringResource(id = R.string.city),
            readOnly = true,
            modifier = fillMaxWidthModifier
        )
        HookahAppDefaultOutlinedTextField(
            text = bar.phone,
            label = stringResource(id = R.string.phone),
            readOnly = true,
            modifier = fillMaxWidthModifier
        )
        HookahAppDefaultOutlinedTextField(
            text = bar.website,
            label = stringResource(id = R.string.website),
            readOnly = true,
            modifier = fillMaxWidthModifier.padding(bottom = 8.dp)
        )
        HookahAppDefaultButton(
            text = stringResource(id = R.string.food),
            onClick = onClickNavigateFood,
            modifier = fillMaxWidthModifier
        )
        HookahAppDefaultButton(
            text = stringResource(id = R.string.drinks),
            onClick = onClickNavigateDrinks,
            modifier = fillMaxWidthModifier
        )
        HookahAppDefaultButton(
            text = stringResource(id = R.string.hookahs),
            onClick = onClickNavigateHookahs,
            modifier = fillMaxWidthModifier
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun BarScreenPreview() {
//    HookahCenterTheme {
//        BarScreen(
//            onClickNavigateFood = { /*TODO*/ },
//            onClickNavigateHookahs = { /*TODO*/ },
//            onClickNavigateDrinks = { /*TODO*/ }
//        )
//    }
//}