package com.github.mikan.sample.windowinsets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.github.mikan.sample.windowinsets.ui.theme.WindowInsetsSampleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldSample() {
    var currentDestination = 0
    val destinations = listOf(
        Icons.Default.AccountCircle,
        Icons.Default.AddCircle,
        Icons.Default.Build,
        Icons.Default.Call,
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Scaffold Sample") },
            )
        },
        bottomBar = {
            NavigationBar {
                destinations.forEachIndexed { index,item ->
                    NavigationBarItem(
                        icon = { Icon(item, contentDescription = null) },
                        label = { Text(item.name.substringAfterLast(".")) },
                        selected = index == currentDestination,
                        onClick = { currentDestination = index },
                    )
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Text(
            text = "Scaffold Sample",
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@PreviewScreenSizes
@Composable
private fun ScaffoldSamplePreview() {
    WindowInsetsSampleTheme {
        ScaffoldSample()
    }
}
