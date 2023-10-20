package io.gmtengineering.textbrush.ui.view.textbrush

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun TextBrush(
    text: String,
    hasToCleanCanvas: Boolean,
    cleaningDone: () -> Unit,
    hasToUndo: Boolean,
    undoDone: () -> Unit,
    modifier: Modifier = Modifier,
) {
    AndroidView(
        modifier = modifier.fillMaxSize(),
        factory = { context ->
            TextBrushView(
                text,
                hasToCleanCanvas,
                cleaningDone,
                hasToUndo,
                undoDone,
                context
            )
        }, update = {
            it.clean(hasToCleanCanvas)
            it.undo(hasToUndo)
        }
    )
}
