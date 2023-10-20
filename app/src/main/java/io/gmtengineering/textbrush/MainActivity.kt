package io.gmtengineering.textbrush

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.gmtengineering.textbrush.ui.TextBrushApp
import io.gmtengineering.textbrush.ui.theme.TextBrushTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextBrushTheme {
                TextBrushApp()
            }
        }
    }
}
