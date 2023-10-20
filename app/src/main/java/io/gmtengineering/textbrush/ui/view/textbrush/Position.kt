package io.gmtengineering.textbrush.ui.view.textbrush

import kotlin.math.pow
import kotlin.math.sqrt

internal data class Position(val x: Float, val y: Float) {
    fun distance(other: Position): Float {
        return sqrt((this.x - other.x).pow(2) + (this.y - other.y).pow(2))
    }
}
