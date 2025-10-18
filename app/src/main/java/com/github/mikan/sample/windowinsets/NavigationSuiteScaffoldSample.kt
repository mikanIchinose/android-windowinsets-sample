package com.github.mikan.sample.windowinsets

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.github.mikan.sample.windowinsets.ui.theme.WindowInsetsSampleTheme

@Composable
fun NavigationSuiteScaffoldSample() {
    var currentDestination = 0
    val destinations = listOf(
        Icons.Default.AccountCircle,
        Icons.Default.AddCircle,
        Icons.Default.Build,
        Icons.Default.Call,
    )
    NavigationSuiteScaffold(
        navigationSuiteItems = {
            destinations.forEachIndexed { index, item ->
                item(
                    icon = { Icon(item, contentDescription = null) },
                    label = { Text(item.name.substringAfterLast(".")) },
                    selected = index == currentDestination,
                    onClick = { currentDestination = index },
                )
            }
        }
    ) {
        Scaffold { innerPadding ->
            Text("Hello NavigationSuiteScaffold!", modifier = Modifier.padding(innerPadding))
        }
    }
}

@PreviewScreenSizes
@Composable
private fun NavigationSuiteScaffoldSamplePreview() {
    WindowInsetsSampleTheme {
        NavigationSuiteScaffoldSample()
    }
}
