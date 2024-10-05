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
import com.qoollo.hookah_center.presentation.model.HookahViewData
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.HookahListViewModel
import com.qoollo.hookah_center.presentation.util.roublePrice
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HookahListScreen(
    viewModel: HookahListViewModel,
    onCardClickNavigate: (id: UUID) -> Unit
) {
    val hookahsState by viewModel.hookahs.collectAsState()
    val hookahs = hookahsState

    DefaultProgressLayout(
        titleText = stringResource(id = R.string.hookahs),
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
                items(hookahs) { hookah ->
                    HookahCard(
                        hookah = hookah,
                        onClick = {
                            println(hookah)
                            onCardClickNavigate(hookah.id)
                        }
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}

@Composable
fun HookahCard(
    hookah: HookahViewData,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    HookahAppDefaultListItem(
        leadingImage = painterResource(id = R.drawable.hookah_image),
        headlineText = hookah.name,
        supportText = "${stringResource(id = R.string.price)}: ${roublePrice(price = hookah.price)}",
        onClick = onClick,
        modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Composable
//fun HookahsPreview() {
//    val hookah = HookahViewData(
//        id = UUID.randomUUID(),
//        name = "mandarin",
//        description = "tabak krutoi",
//        type = "non alcohol",
//        price = 400.0
//    )
//    HookahCenterTheme {
//        HookahListScreen(
//            listOf(
//                hookah,
//                hookah.copy(id = UUID.randomUUID(), name = "morozhenoe")
//            )
//        )
//    }
//}