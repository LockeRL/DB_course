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
import com.qoollo.hookah_center.presentation.model.DrinkViewData
import com.qoollo.hookah_center.presentation.ui.theme.Typography
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.DrinkViewModel
import com.qoollo.hookah_center.presentation.util.roublePrice

@Composable
fun DrinkScreen(
    viewModel: DrinkViewModel
) {
    val drinkState by viewModel.drink.collectAsState()
    val drink = drinkState

    if (drink == null)
        Text(text = "")
    else
        DrinkInfo(drink = drink)
}

@Composable
fun DrinkInfo(
    drink: DrinkViewData
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(text = drink.name, style = Typography.titleLarge)

        val fillMaxWidthModifier = Modifier.fillMaxWidth()
        HookahAppDefaultOutlinedTextField(
            text = roublePrice(price = drink.price),
            label = stringResource(id = R.string.price),
            readOnly = true,
            modifier = fillMaxWidthModifier
        )
        HookahAppDefaultOutlinedTextField(
            text = drink.type,
            label = stringResource(id = R.string.type),
            readOnly = true,
            modifier = fillMaxWidthModifier
        )
        HookahAppDefaultOutlinedTextField(
            text = drink.ingredients,
            label = stringResource(id = R.string.ingredients),
            readOnly = true,
            singleLine = false,
            modifier = fillMaxWidthModifier
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DrinkScreenPreview() {
//    val drink = DrinkViewData(
//        id = UUID.randomUUID(),
//        name = "super voda",
//        ingredients = "voda",
//        type = "non alcohol",
//        price = 400.0
//    )
//    HookahCenterTheme {
//        DrinkScreen(drink = drink)
//    }
//}