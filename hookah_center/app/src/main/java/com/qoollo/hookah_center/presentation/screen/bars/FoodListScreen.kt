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
import com.qoollo.hookah_center.presentation.model.FoodViewData
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.FoodListViewModel
import com.qoollo.hookah_center.presentation.util.roublePrice
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodListScreen(
    viewModel: FoodListViewModel,
    onCardClickNavigate: (id: UUID) -> Unit
) {
    val foodState by viewModel.food.collectAsState()
    val food = foodState

    DefaultProgressLayout(
        titleText = stringResource(id = R.string.food),
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
                items(food) { foodItem ->
                    FoodCard(
                        food = foodItem,
                        onClick = {
                            println(foodItem)
                            onCardClickNavigate(foodItem.id)
                        }
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}

@Composable
fun FoodCard(
    food: FoodViewData,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    HookahAppDefaultListItem(
        leadingImage = painterResource(id = R.drawable.food_image),
        headlineText = food.name,
        supportText = "${stringResource(id = R.string.price)}: ${roublePrice(price = food.price)}",
        onClick = onClick,
        modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Composable
//fun FoodPreview() {
//    val food = FoodViewData(
//        id = UUID.randomUUID(),
//        name = "soup",
//        ingredients = "voda",
//        price = 800.0
//    )
//    HookahCenterTheme {
//        FoodScreen(
//            listOf(
//                food,
//                food.copy(id = UUID.randomUUID(), name = "plov")
//            )
//        )
//    }
//}