package com.qoollo.hookah_center.presentation.screen.profile


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qoollo.hookah_center.R
import com.qoollo.hookah_center.presentation.common.HookahAppDefaultButton
import com.qoollo.hookah_center.presentation.common.HookahAppDefaultOutlinedTextField
import com.qoollo.hookah_center.presentation.common.HookahAppDefaultTextButton
import com.qoollo.hookah_center.presentation.ui.viewModel.profile.LoginViewModel
import com.qoollo.hookah_center.presentation.ui.theme.HookahCenterTheme
import com.qoollo.hookah_center.presentation.ui.theme.Typography

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    var registerState by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(
                id = if (registerState) R.string.register else R.string.login
            ),
            style = Typography.titleLarge
        )
        HookahAppDefaultOutlinedTextField(
            text = viewModel.login,
            onValueChanged = { login -> viewModel.updateLogin(login) },
            label = stringResource(id = R.string.login),
            modifier = Modifier.fillMaxWidth()
        )
        HookahAppDefaultOutlinedTextField(
            text = viewModel.password,
            onValueChanged = { password -> viewModel.updatePassword(password) },
            label = stringResource(id = R.string.password),
            modifier = Modifier.fillMaxWidth()
        )
        AnimatedVisibility(visible = registerState) {
            HookahAppDefaultOutlinedTextField(
                text = viewModel.firstName,
                onValueChanged = { firstName -> viewModel.updateFirstName(firstName) },
                label = stringResource(id = R.string.first_name),
                modifier = Modifier.fillMaxWidth()
            )
        }
        AnimatedVisibility(visible = registerState) {
            HookahAppDefaultOutlinedTextField(
                text = viewModel.secondName,
                onValueChanged = { secondName -> viewModel.updateSecondName(secondName) },
                label = stringResource(id = R.string.second_name),
                modifier = Modifier.fillMaxWidth()
            )
        }
        HookahAppDefaultTextButton(
            text = stringResource(
                id = if (registerState) R.string.have_account else R.string.not_have_account
            ),
            onClick = { registerState = !registerState }
        )
        HookahAppDefaultButton(
            text = stringResource(
                id = if (registerState) R.string.sign_up else R.string.log_in
            ),
            onClick = {
                if (registerState) viewModel.signUp() else viewModel.login()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TestLoginScreen() {
    HookahCenterTheme {
        // LoginScreen()
    }
}