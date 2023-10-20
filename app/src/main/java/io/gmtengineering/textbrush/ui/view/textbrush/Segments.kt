package io.gmtengineering.textbrush.ui.view.textbrush

import android.graphics.Canvas
import android.graphics.Paint

internal class Segments {

    private val segments = mutableListOf<Segment>()

    fun add(segment: Segment?) {
        segment?.let { segments.add(it) }
    }

    fun get(): List<Segment> {
        return segments.toList()
    }

    fun removeAll() {
        segments.clear()
    }

    fun removeLast() {
        if (segments.isNotEmpty()) {
            segments.removeLast()
        }
    }

    fun draw(canvas: Canvas, paint: Paint) {
        for (segment in segments) {
            segment.draw(canvas, paint)
        }
    }
}
