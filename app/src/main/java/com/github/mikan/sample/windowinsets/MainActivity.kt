package com.github.mikan.sample.windowinsets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.github.mikan.sample.windowinsets.ui.theme.WindowInsetsSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var destination by remember { mutableStateOf(Destination.ImeSample) }
            WindowInsetsSampleTheme {
                when (destination) {
                    Destination.ScaffoldSample -> ScaffoldSample()
                    Destination.BottomSheetSample -> BottomSheetSample()
                    Destination.ImeSample -> ImeSample()
                }
            }
        }
    }
}

private enum class Destination {
    ScaffoldSample,
    BottomSheetSample,
    ImeSample,
}
