package io.gmtengineering.textbrush.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.gmtengineering.textbrush.R
import io.gmtengineering.textbrush.ui.view.textbrush.TextBrush

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var hasToCleanCanvas by remember {
        mutableStateOf(false)
    }

    var undo by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            contentDescription = null,
            painter = painterResource(id = R.drawable.background),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        TextBrush(
            text = "Text Brush",
            hasToCleanCanvas = hasToCleanCanvas,
            cleaningDone = {
                hasToCleanCanvas = false
            },
            hasToUndo = undo,
            undoDone = {
                undo = false
            },
            modifier = modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .padding(end = 10.dp)
                .align(Alignment.TopEnd)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            ActionButton(
                drawable = R.drawable.clear,
                action = { hasToCleanCanvas = true },
                contentDescription = R.string.clear,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(10.dp))
            ActionButton(
                drawable = R.drawable.undo,
                action = { undo = true },
                contentDescription = R.string.undo,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun ActionButton(drawable: Int, action: () -> Unit, contentDescription: Int, modifier: Modifier) {
    Button(
        onClick = action,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black
        ),
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = stringResource(id = contentDescription)
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
