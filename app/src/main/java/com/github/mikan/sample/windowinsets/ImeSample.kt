package com.github.mikan.sample.windowinsets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.mikan.sample.windowinsets.ui.theme.WindowInsetsSampleTheme

@Composable
fun ImeSample() {
    var text by remember { mutableStateOf("") }
    Surface {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .imePadding()
                .padding(horizontal = 8.dp),
        ) {
            item {
                Spacer(Modifier.windowInsetsTopHeight(WindowInsets.systemBars))
            }
            items(20) { index ->
                if (index == 10) {
                    Card {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            TextField(
                                value = text,
                                onValueChange = { text = it },
                                label = { Text("Input here") },
                            )
                        }
                    }
                } else {
                    Card {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text("Item #$index")
                        }
                    }
                }
            }
            item {
                Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.systemBars))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ImeSamplePreview() {
    WindowInsetsSampleTheme {
        ImeSample()
    }
}