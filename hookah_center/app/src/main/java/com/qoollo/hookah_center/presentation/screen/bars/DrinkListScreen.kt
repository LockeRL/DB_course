package com.qoollo.hookah_center.presentation.screen.bars

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.qoollo.hookah_center.R
import com.qoollo.hookah_center.presentation.common.DefaultProgressLayout
import com.qoollo.hookah_center.presentation.common.HookahAppDefaultListItem
import com.qoollo.hookah_center.presentation.model.DrinkViewData
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.DrinkListViewModel
import com.qoollo.hookah_center.presentation.util.roublePrice
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrinkListScreen(
    viewModel: DrinkListViewModel,
    onCardClickNavigate: (id: UUID) -> Unit
) {
    val drinksState by viewModel.drinks.collectAsState()
    val drinks = drinksState

    DefaultProgressLayout(
        titleText = stringResource(id = R.string.drinks),
        dataLoaded = viewModel.dataLoaded
    ) {
        PullToRefreshBox(
            isRefreshing = viewModel.isRefreshing,
            onRefresh = { viewModel.refresh() },
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(drinks) { drink ->
                    DrinkCard(
                        drink = drink,
                        onClick = {
                            println(drink)
                            onCardClickNavigate(drink.id)
                        }
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}

@Composable
fun DrinkCard(
    drink: DrinkViewData,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    HookahAppDefaultListItem(
        leadingImage = painterResource(id = R.drawable.drink_image),
        headlineText = drink.name,
        supportText = "${stringResource(id = R.string.price)}: ${roublePrice(price = drink.price)}",
        onClick = onClick,
        modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Composable
//fun DrinksPreview() {
//    val drink = DrinkViewData(
//        id = UUID.randomUUID(),
//        name = "super voda",
//        ingredients = "voda",
//        type = "non alcohol",
//        price = 400.0
//    )
//    HookahCenterTheme {
//        DrinkListScreen(
//            listOf(
//                drink,
//                drink.copy(id = UUID.randomUUID(), name = "sok")
//            )
//        )
//    }
//}