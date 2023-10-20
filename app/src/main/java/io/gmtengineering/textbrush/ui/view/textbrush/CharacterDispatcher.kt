package io.gmtengineering.textbrush.ui.view.textbrush

internal class CharacterDispatcher(text: String) {

    private val defaultTextIndex = -1

    private var textIndex = defaultTextIndex

    private val characters: CharArray = if (!text.endsWith(" ")) {
        "$text ".toCharArray()
    } else {
        text.toCharArray()
    }

    fun reset() {
        textIndex = defaultTextIndex
    }

    fun getCharacter(): Char {
        textIndex = if (textIndex == characters.size - 1) {
            0
        } else {
            textIndex + 1
        }

        return characters[textIndex]
    }
}
