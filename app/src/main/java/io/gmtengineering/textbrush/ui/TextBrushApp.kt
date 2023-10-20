package io.gmtengineering.textbrush.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.gmtengineering.textbrush.ui.screens.HomeScreen
import io.gmtengineering.textbrush.ui.theme.TextBrushTheme

@Composable
fun TextBrushApp() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        HomeScreen()
    }
}

@Preview
@Composable
fun TextBrushAppPreview() {
    TextBrushTheme {
        TextBrushApp()
    }
}
