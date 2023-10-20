package io.gmtengineering.textbrush.ui.view.textbrush

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.view.MotionEvent
import android.view.View

@SuppressLint("ViewConstructor")
internal class TextBrushView(
    text: String,
    private var hasToCleanCanvas: Boolean,
    private val cleaningDone: () -> Unit,
    private var hasToUndo: Boolean,
    private val undoDone: () -> Unit,
    context: Context
) : View(context) {

    private val segmentBuilder = SegmentBuilder(text)

    private val segments = Segments()

    private val paint: Paint = Paint()

    init {
        paint.color = Color.YELLOW
        paint.textSize = 80F
        paint.typeface = Typeface.DEFAULT_BOLD
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        segments.draw(canvas, paint)
        segmentBuilder.draw(canvas, paint)

        if (hasToCleanCanvas) {
            segments.removeAll()
            cleaningDone()
        }

        if (hasToUndo) {
            segments.removeLast()
            undoDone()
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    segmentBuilder.newSegment(event.x, event.y)
                }

                MotionEvent.ACTION_MOVE -> {
                    segmentBuilder.updateSegment(event.x, event.y, paint.textSize)
                }

                MotionEvent.ACTION_UP -> {
                    segments.add(segmentBuilder.get())
                }

                else -> {

                }
            }
        }
        invalidate()
        return true
    }

    fun clean(hasToCleanCanvas: Boolean) {
        this.hasToCleanCanvas = hasToCleanCanvas
        invalidate()
    }

    fun undo(hasToUndo: Boolean) {
        this.hasToUndo = hasToUndo
        invalidate()
    }
}
