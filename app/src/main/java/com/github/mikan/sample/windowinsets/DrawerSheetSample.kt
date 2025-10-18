package com.github.mikan.sample.windowinsets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.github.mikan.sample.windowinsets.ui.theme.WindowInsetsSampleTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerSheetSample() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                LazyColumn {
                    items(100) { index ->
                        NavigationDrawerItem(
                            label = { Text("Drawer Item $index") },
                            selected = false,
                            onClick = { /* Handle navigation */ }
                        )
                    }
                }
            }
        },
        drawerState = drawerState,
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("ModalNavigationDrawer Sample") },
                    navigationIcon = {
                        IconButton({
                            scope.launch { drawerState.toggle() }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Text(
                text = "Drawer Sample",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

private suspend fun DrawerState.toggle() {
    if (isClosed) open() else close()
}

@PreviewScreenSizes
@Composable
private fun DrawerSheetSamplePreview() {
    WindowInsetsSampleTheme {
        DrawerSheetSample()
    }
}