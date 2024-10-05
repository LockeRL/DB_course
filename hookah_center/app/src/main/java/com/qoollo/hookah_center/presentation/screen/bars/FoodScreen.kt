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
import com.qoollo.hookah_center.presentation.common.HookahAppDefaultOutlinedTextField
import com.qoollo.hookah_center.presentation.model.FoodViewData
import com.qoollo.hookah_center.presentation.ui.theme.Typography
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.FoodViewModel
import com.qoollo.hookah_center.presentation.util.roublePrice

@Composable
fun FoodScreen(
    viewModel: FoodViewModel
) {
    val foodState by viewModel.food.collectAsState()
    val food = foodState

    if (food == null)
        Text(text = "")
    else
        FoodInfo(food = food)
}

@Composable
fun FoodInfo(
    food: FoodViewData
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(text = food.name, style = Typography.titleLarge)

        val fillMaxWidthModifier = Modifier.fillMaxWidth()
        HookahAppDefaultOutlinedTextField(
            text = roublePrice(price = food.price),
            label = stringResource(id = R.string.price),
            readOnly = true,
            modifier = fillMaxWidthModifier
        )
        HookahAppDefaultOutlinedTextField(
            text = food.ingredients,
            label = stringResource(id = R.string.ingredients),
            readOnly = true,
            singleLine = false,
            modifier = fillMaxWidthModifier
        )
    }
}