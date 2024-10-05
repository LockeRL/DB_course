package com.qoollo.hookah_center.presentation.screen.profile

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
import com.qoollo.hookah_center.presentation.model.OwnerViewData
import com.qoollo.hookah_center.presentation.ui.theme.Typography
import com.qoollo.hookah_center.presentation.ui.viewModel.profile.ProfileViewModel


@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel
) {
    val ownerState by viewModel.ownerFlow.collectAsState()
    val owner = ownerState

    if (owner == null)
        Text(text = "")
    else
        ProfileInfo(owner = owner)
}

@Composable
fun ProfileInfo(
    owner: OwnerViewData
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.profile),
            style = Typography.titleLarge
        )
        val textFieldModifier = Modifier.fillMaxWidth()
        HookahAppDefaultOutlinedTextField(
            text = owner.id.toString(),
            label = stringResource(id = R.string.id),
            readOnly = true,
            modifier = textFieldModifier
        )
        HookahAppDefaultOutlinedTextField(
            text = owner.login,
            label = stringResource(id = R.string.login),
            readOnly = true,
            modifier = textFieldModifier
        )
        HookahAppDefaultOutlinedTextField(
            text = owner.firstName,
            label = stringResource(id = R.string.first_name),
            readOnly = true,
            modifier = textFieldModifier
        )
        HookahAppDefaultOutlinedTextField(
            text = owner.secondName,
            label = stringResource(id = R.string.second_name),
            readOnly = true,
            modifier = textFieldModifier
        )
    }
}