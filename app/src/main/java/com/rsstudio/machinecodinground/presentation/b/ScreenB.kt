package com.rsstudio.machinecodinground.presentation.b

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rsstudio.machinecodinground.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenB(
    viewModel: ScreenBViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                actions = {

                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(R.drawable.baseline_arrow_back_24),
                        contentDescription = "back"
                    )
                },
                title = {
                    Text(
                        text = "back"
                    )
                }
            )
        }
    ) { innerPadding ->
        ScreenBContent(
            modifier = Modifier.padding(innerPadding),
            uiState = viewModel.uiState
        )
    }
}

@Composable
fun ScreenBContent(
    modifier: Modifier = Modifier,
    uiState: ScreenBUiState
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(text = stringResource(R.string.name, uiState.name))
        Spacer(Modifier.size(16.dp))
        Spacer(Modifier.size(16.dp))
        Text(text = stringResource(R.string.age, uiState.age))
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenBPreview(modifier: Modifier = Modifier) {
    ScreenBContent(
        uiState = ScreenBUiState()
    )
}