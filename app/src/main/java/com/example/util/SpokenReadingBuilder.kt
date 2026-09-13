package com.example.util

import com.example.data.model.Hexagram

/**
 * Builds a natural, conversational spoken consultation from an I Ching reading result:
 * 1. Primary hexagram number and name.
 * 2. Main interpretation/meaning shown for that hexagram.
 * 3. Relevant changing-line interpretations, if there are changing lines.
 * 4. Transformed hexagram number and name, if one exists.
 * 5. The relevant concluding interpretation/advice already available in the result.
 *
 * Omits UI labels, buttons, navigation, and technical metadata.
 */
object SpokenReadingBuilder {

    fun buildSpokenText(
        primary: Hexagram,
        changingLineIndices: List<Int> = emptyList(),
        transformed: Hexagram? = null
    ): String {
        val segments = mutableListOf<String>()

        // 1. Primary hexagram number and name
        segments.add("Hexagram ${primary.number}, ${primary.englishName}.")

        // 2. Main interpretation / meaning shown for that hexagram (Judgment and Image)
        val mainMeaning = listOf(primary.judgment.trim(), primary.theImage.trim())
            .filter { it.isNotEmpty() }
            .joinToString(" ")
        if (mainMeaning.isNotEmpty()) {
            segments.add(mainMeaning)
        }

        // 3. Relevant changing-line interpretations, if there are changing lines
        val hasChangingLines = changingLineIndices.isNotEmpty()
        if (hasChangingLines) {
            val spokenLines = changingLineIndices.sorted().mapNotNull { lineNum ->
                primary.lineTexts.getOrNull(lineNum - 1)?.trim()?.takeIf { it.isNotEmpty() }
            }
            if (spokenLines.isNotEmpty()) {
                segments.add(spokenLines.joinToString(" "))
            }
        }

        // 4. Transformed hexagram number and name, if one exists
        if (hasChangingLines && transformed != null) {
            segments.add("This transforms into Hexagram ${transformed.number}, ${transformed.englishName}.")
        }

        // 5. The relevant concluding interpretation / advice already available in the result
        val concludingAdviceParts = mutableListOf<String>()
        if (primary.commentary.isNotBlank()) {
            concludingAdviceParts.add(primary.commentary.trim())
        }
        if (hasChangingLines && transformed != null && transformed.commentary.isNotBlank()) {
            concludingAdviceParts.add(transformed.commentary.trim())
        }
        if (concludingAdviceParts.isNotEmpty()) {
            segments.add(concludingAdviceParts.joinToString(" "))
        }

        return segments.joinToString(" ")
    }
}
