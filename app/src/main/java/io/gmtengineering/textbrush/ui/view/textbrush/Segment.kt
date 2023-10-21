package io.gmtengineering.textbrush.ui.view.textbrush

import android.graphics.Canvas
import android.graphics.Paint

internal class Segment {

    private val characters = mutableListOf<Character>()

    fun add(character: Character) {
        characters.add(character)
    }

    fun draw(canvas: Canvas, paint: Paint) {
        for (character in characters) {
            canvas.rotate(character.rotation, character.position.x, character.position.y)
            canvas.drawText(
                character.symbol.toString(),
                character.position.x,
                character.position.y,
                paint
            )
            canvas.rotate(-character.rotation, character.position.x, character.position.y)
        }
    }
}
