package com.qoollo.hookah_center.presentation.screen.bars

import android.text.Layout
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.qoollo.hookah_center.R
import com.qoollo.hookah_center.presentation.common.DefaultProgressLayout
import com.qoollo.hookah_center.presentation.common.HookahAppDefaultListItem
import com.qoollo.hookah_center.presentation.model.BarViewData
import com.qoollo.hookah_center.presentation.ui.theme.Typography
import com.qoollo.hookah_center.presentation.ui.viewModel.bars.BarListViewModel
import java.util.UUID


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarListScreen(
    viewModel: BarListViewModel,
    onCardClickNavigate: (id: UUID) -> Unit
) {
    val barsState by viewModel.bars.collectAsState()
    val bars = barsState

    DefaultProgressLayout(
        titleText = stringResource(id = R.string.bars),
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
                items(bars) { bar ->
                    BarCard(
                        bar = bar,
                        onClick = {
                            println(bar)
                            onCardClickNavigate(bar.id)
                        }
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}

@Composable
fun BarCard(
    bar: BarViewData,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    HookahAppDefaultListItem(
        leadingImage = painterResource(id = R.drawable.bar_image),
        headlineText = bar.name,
        supportText = "${stringResource(id = R.string.score)}: ${bar.score}",
        onClick = onClick,
        modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Composable
//fun BarsPreview() {
//    val bar = BarViewData(
//        id = UUID.randomUUID(),
//        score = 4.5f,
//        name = "myata",
//        phone = "3274682",
//        website = "myata.ru",
//        city = "moscow",
//        latitude = 213.3,
//        longitude = 333.2,
//        schedule = ""
//    )
//    HookahCenterTheme {
//        BarsScreen(
//            listOf(
//                bar,
//                bar.copy(id = UUID.randomUUID())
//            )
//        )
//    }
//}