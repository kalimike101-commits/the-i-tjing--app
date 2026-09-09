package com.example.data.model

/**
 * The 8 fundamental Trigrams (Ba Gua / 八卦) of the I-Ching.
 * Each consists of 3 lines (bottom, middle, top), where true is Yang (⚊) and false is Yin (⚋).
 */
enum class Trigram(
    val chinese: String,
    val pinyin: String,
    val englishName: String,
    val element: String,
    val symbol: String,
    val lines: List<Boolean> // line 1 (bottom), line 2, line 3 (top)
) {
    QIAN("乾", "Qián", "Heaven", "Metal", "☰", listOf(true, true, true)),
    KUN("坤", "Kūn", "Earth", "Earth", "☷", listOf(false, false, false)),
    ZHEN("震", "Zhèn", "Thunder", "Wood", "☳", listOf(true, false, false)),
    KAN("坎", "Kǎn", "Water", "Water", "☵", listOf(false, true, false)),
    GEN("艮", "Gèn", "Mountain", "Earth", "☶", listOf(false, false, true)),
    XUN("巽", "Xùn", "Wind / Wood", "Wood", "☴", listOf(false, true, true)),
    LI("離", "Lí", "Fire", "Fire", "☲", listOf(true, false, true)),
    DUI("兌", "Duì", "Lake", "Metal", "☱", listOf(true, true, false));

    companion object {
        fun fromLines(l1: Boolean, l2: Boolean, l3: Boolean): Trigram? {
            return entries.firstOrNull { it.lines[0] == l1 && it.lines[1] == l2 && it.lines[2] == l3 }
        }

        fun fromLines(lines: List<Boolean>): Trigram? {
            if (lines.size != 3) return null
            return fromLines(lines[0], lines[1], lines[2])
        }
    }
}

/**
 * Representation of one of the 64 Hexagrams (Gua / 卦).
 * Lines are indexed 0 to 5 (Line 1 at bottom to Line 6 at top).
 *
 * Separates historical/source materials from modern interpretive guidance while
 * preserving backward-compatible structural and existing textual properties.
 */
data class Hexagram(
    // Canonical structural fields
    val number: Int,
    val chinese: String,
    val pinyin: String,
    val englishName: String,
    val upperTrigram: Trigram,
    val lowerTrigram: Trigram,
    val lines: List<Boolean>, // 6 lines: index 0 = bottom (Line 1), index 5 = top (Line 6)

    // Existing textual fields (preserved for backwards compatibility with the current library)
    val judgment: String = "",     // 彖辭 / 卦辭
    val theImage: String = "",     // 象辭
    val commentary: String = "",   // General insight & situation guidance
    val lineTexts: List<String> = emptyList(), // Guidance for changing lines 1 to 6 (index 0 to 5)

    // Historical / source text layer (distinct fields for authentic classical statements)
    val sourceJudgment: String? = null,
    val sourceImage: String? = null,
    val sourceLineTexts: List<String>? = null,

    // Contemporary / modern interpretive layer
    val modernMeaning: String? = null,
    val themes: List<String> = emptyList(),
    val advice: String? = null,
    val caution: String? = null,
    val lineInterpretations: List<String>? = null
) {
    val symbolUnicode: String
        get() = try {
            // Hexagram unicode characters start at U+4DC0 for #1 (乾)
            String(Character.toChars(0x4DC0 + (number - 1)))
        } catch (e: Exception) {
            "䷀"
        }
}

/**
 * Result of tossing 3 coins for a single line:
 * - Heads (Yang) = 3
 * - Tails (Yin) = 2
 * Sum:
 * - 6: Old Yin (Changing ⚋ ➔ ⚊)
 * - 7: Young Yang (Stable ⚊)
 * - 8: Young Yin (Stable ⚋)
 * - 9: Old Yang (Changing ⚊ ➔ ⚋)
 */
data class TossResult(
    val lineIndex: Int, // 0 to 5 (0 = Line 1, bottom)
    val coinValues: Triple<Int, Int, Int>, // each 2 or 3
    val sum: Int // 6, 7, 8, or 9
) {
    val isYang: Boolean = (sum == 7 || sum == 9)
    val isChanging: Boolean = (sum == 6 || sum == 9)
    val transformedIsYang: Boolean = when (sum) {
        6 -> true   // Old Yin turns into Yang
        9 -> false  // Old Yang turns into Yin
        else -> isYang
    }

    val typeDescription: String = when (sum) {
        6 -> "Old Yin (Changing)"
        7 -> "Young Yang (Stable)"
        8 -> "Young Yin (Stable)"
        9 -> "Old Yang (Changing)"
        else -> "Line"
    }

    val lineSymbol: String = when (sum) {
        6 -> "⚋ ➔ ⚊"
        7 -> "⚊"
        8 -> "⚋"
        9 -> "⚊ ➔ ⚋"
        else -> "—"
    }
}
