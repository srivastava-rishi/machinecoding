package com.rsstudio.machinecodinground.presentation.a

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rsstudio.machinecodinground.navigation.ScreenAActions
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenA(
    viewModel: ScreenAViewModel = hiltViewModel(),
    onAction: (ScreenAActions) -> Unit
) {

    var boy by remember { mutableStateOf<Boolean>(false) }

    LaunchedEffect(Unit) {
        delay(3000)
        boy = true
    }
    DisposableEffect(boy) {
        onDispose {
            Log.d("lion229999", "Screen -  line n0 44")
        }
    }
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                actions = {
//
//                },
//                navigationIcon = {
//
//                },
//                title = {
//                    Text(
//                        text = "back"
//                    )
//                }
//            )
//        }
//    ) { innerPadding ->
//        ScreenAContent(
//            modifier = Modifier.padding(innerPadding),
//            onEvent = viewModel::onEvent
//        )
//    }
//
//    LaunchedEffect(viewModel.uiSideEffect) {
//        handleSideEffects(
//            onAction = onAction,
//            effects = viewModel.uiSideEffect
//        )
//        viewModel.resetSideEffect()
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Load 10 items with increasing height
        for (i in 1..10) {
            ComposableItem("Item $i", height = (80 + i * 40).dp) {
                onAction(ScreenAActions.OpenScreenB("", ""))
            }
        }
    }
}


@Composable
fun ComposableItem(
    label: String,
    height: Dp,
    onClick: () -> Unit
) {
    DisposableEffect(Unit) {
        Log.d("lion229999", "ComposableItem - started  $label")
        onDispose {
            Log.d("lion229999", "ComposableItem  ended -  $label")
        }
    }

    LaunchedEffect(Unit) {
        Log.d("lion229999", "LaunchedEffect block -  $label")
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(height)
            .background(Color(0xFFEEEEEE), RoundedCornerShape(12.dp))
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$label\nHeight: ${height.value.toInt()}dp",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ScreenAContent(
    modifier: Modifier = Modifier,
    onEvent: (ScreenAEvents) -> Unit,
) {
    var nameTextField by remember {
        mutableStateOf(TextFieldValue())
    }
    var ageTextField by remember {
        mutableStateOf(TextFieldValue())
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Name"
        )
        Spacer(Modifier.size(16.dp))
        TextField(
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Enter your name",
                    color = Color.LightGray,
                    fontSize = 14.sp
                )
            },
            value = nameTextField,
            onValueChange = {
                nameTextField = it
            }
        )
        Spacer(Modifier.size(16.dp))
        Text(
            text = "Age"
        )
        Spacer(Modifier.size(16.dp))
        TextField(
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Enter your name",
                    color = Color.LightGray,
                    fontSize = 14.sp
                )
            },
            value = ageTextField,
            onValueChange = {
                ageTextField = it
            }
        )
        Spacer(Modifier.size(16.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            content = {
                Text(
                    text = "Age"
                )
            },
            onClick = {
                onEvent(ScreenAEvents.OnDone(nameTextField.text, ageTextField.text))
            }
        )
    }
}


fun handleSideEffects(
    onAction: (ScreenAActions) -> Unit,
    effects: ScreenASideEffects
) {
    when (effects) {
        is ScreenASideEffects.NavigateToScreenB -> {
            onAction(ScreenAActions.OpenScreenB(effects.name, effects.age))
        }

        ScreenASideEffects.None -> {
            // stub
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenAPreview(modifier: Modifier = Modifier) {
    ScreenAContent(
        onEvent = {}
    )
}