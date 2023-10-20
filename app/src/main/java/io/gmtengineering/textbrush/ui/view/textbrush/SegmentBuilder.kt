package io.gmtengineering.textbrush.ui.view.textbrush

import android.graphics.Canvas
import android.graphics.Paint

internal class SegmentBuilder(text: String) {

    private val characterDispatcher = CharacterDispatcher(text)

    private lateinit var position: Position

    private var underConstruction: Segment? = null

    fun newSegment(x: Float, y: Float) {
        characterDispatcher.reset()
        position = Position(x, y)
    }

    private fun addToSegment(character: Character) {
        if (underConstruction == null) {
            underConstruction = Segment()
        }

        underConstruction?.add(
            character
        )
    }

    fun updateSegment(x: Float, y: Float, letterSize: Float) {
        val temp = Position(x, y)
        val distanceBetweenPositions = temp.distance(position)
        if (distanceBetweenPositions >= letterSize) {
            addToSegment(
                Character(
                    position,
                    characterDispatcher.getCharacter()
                )
            )
            position = temp
        }
    }

    fun get(): Segment? {
        val segment = underConstruction
        underConstruction = null
        return segment
    }

    fun draw(canvas: Canvas, paint: Paint) {
        underConstruction?.let {
            underConstruction!!.draw(canvas, paint)
        }
    }
}
