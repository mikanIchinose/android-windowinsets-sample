package com.github.mikan.sample.windowinsets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGestures
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.mikan.sample.windowinsets.ui.theme.WindowInsetsSampleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetSample() {
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("ModalBottomSheet Sample")
                },
            )
        },
    ) { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Button({ showBottomSheet = true }) {
                Text("Show Bottom Sheet")
            }
        }
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            val paddingValues = WindowInsets.safeGestures.asPaddingValues()
            val topPadding = paddingValues.calculateTopPadding()
            val bottomPadding = paddingValues.calculateBottomPadding()
            val rightPadding = paddingValues.calculateRightPadding(LocalLayoutDirection.current)
            val leftPadding = paddingValues.calculateLeftPadding(LocalLayoutDirection.current)
            Column {
                Text(text = "top: $topPadding")
                Text(text = "bottom: $bottomPadding")
                Text(text = "right: $rightPadding")
                Text(text = "left: $leftPadding")
            }
        }
    }
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text("Hello Android!")
            }
        }
    }
}

@Preview
@Composable
private fun BottomSheetSamplePreview() {
    WindowInsetsSampleTheme {
        BottomSheetSample()
    }
}
