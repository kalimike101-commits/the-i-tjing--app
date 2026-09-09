package com.example

import com.example.data.HexagramLibrary
import com.example.data.model.Hexagram
import com.example.data.model.TossResult
import com.example.data.model.Trigram
import com.example.data.model.UserProfile
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {

  @Test
  fun addition_isCorrect() {
    assertEquals(4, 2 + 2)
  }

  @Test
  fun userProfileModelValidation() {
    val defaultProfile = UserProfile()
    assertFalse(defaultProfile.isCompleted)
    assertEquals("", defaultProfile.age)
    assertEquals("Not specified", defaultProfile.displayGender)

    val filledProfile = UserProfile(
      age = "32",
      gender = "Woman",
      educationLevel = "Bachelor's Degree",
      iChingExperience = "Some experience",
      isCompleted = true
    )
    assertTrue(filledProfile.isCompleted)
    assertEquals("32", filledProfile.age)
    assertEquals("Woman", filledProfile.displayGender)
    assertEquals("Bachelor's Degree", filledProfile.educationLevel)
    assertEquals("Some experience", filledProfile.iChingExperience)

    val customGenderProfile = UserProfile(
      age = "25",
      gender = "Self-describe",
      customGender = "Agender",
      educationLevel = "Master's Degree",
      iChingExperience = "First time",
      isCompleted = true
    )
    assertEquals("Agender", customGenderProfile.displayGender)

    assertTrue(UserProfile.GENDER_OPTIONS.contains("Woman"))
    assertTrue(UserProfile.GENDER_OPTIONS.contains("Man"))
    assertTrue(UserProfile.GENDER_OPTIONS.contains("Non-binary"))
    assertTrue(UserProfile.GENDER_OPTIONS.contains("Self-describe"))
    assertTrue(UserProfile.GENDER_OPTIONS.contains("Prefer not to say"))

    assertTrue(UserProfile.EXPERIENCE_OPTIONS.contains("First time"))
    assertTrue(UserProfile.EXPERIENCE_OPTIONS.contains("Some experience"))
    assertTrue(UserProfile.EXPERIENCE_OPTIONS.contains("Experienced"))
  }

  @Test
  fun all64HexagramsAreLoadedAndOrdered() {
    val hexagrams = HexagramLibrary.allHexagrams
    assertEquals(64, hexagrams.size)

    for (i in 1..64) {
      val hex = HexagramLibrary.getByNumber(i)
      assertNotNull(hex)
      assertEquals(i, hex!!.number)
      assertNotNull(hex.chinese)
      assertNotNull(hex.pinyin)
      assertNotNull(hex.englishName)
      assertEquals(6, hex.lines.size)
      assertEquals(6, hex.lineTexts.size)
    }
  }

  @Test
  fun hexagram1And2Properties() {
    val qian = HexagramLibrary.getByNumber(1)
    assertNotNull(qian)
    assertEquals("乾", qian!!.chinese)
    assertEquals("The Creative", qian.englishName)
    assertTrue(qian.lines.all { it }) // All lines Yang

    val kun = HexagramLibrary.getByNumber(2)
    assertNotNull(kun)
    assertEquals("坤", kun!!.chinese)
    assertEquals("The Receptive", kun.englishName)
    assertTrue(kun.lines.none { it }) // All lines Yin
  }

  @Test
  fun hexagramSearch() {
    val peaceResults = HexagramLibrary.search("Peace")
    assertFalse(peaceResults.isEmpty())
    assertEquals(11, peaceResults.first().number)

    val numericSearch = HexagramLibrary.search("64")
    assertEquals(1, numericSearch.size)
    assertEquals("未濟", numericSearch.first().chinese)
  }

  @Test
  fun coinTossCalculations() {
    // 3 Tails (2+2+2 = 6): Old Yin (Changing Yin -> Yang)
    val oldYin = TossResult(0, Triple(2, 2, 2), 6)
    assertFalse(oldYin.isYang)
    assertTrue(oldYin.isChanging)
    assertTrue(oldYin.transformedIsYang)

    // 2 Tails + 1 Head (2+2+3 = 7): Young Yang (Stable)
    val youngYang = TossResult(1, Triple(2, 2, 3), 7)
    assertTrue(youngYang.isYang)
    assertFalse(youngYang.isChanging)
    assertTrue(youngYang.transformedIsYang)

    // 1 Tail + 2 Heads (2+3+3 = 8): Young Yin (Stable)
    val youngYin = TossResult(2, Triple(2, 3, 3), 8)
    assertFalse(youngYin.isYang)
    assertFalse(youngYin.isChanging)
    assertFalse(youngYin.transformedIsYang)

    // 3 Heads (3+3+3 = 9): Old Yang (Changing Yang -> Yin)
    val oldYang = TossResult(3, Triple(3, 3, 3), 9)
    assertTrue(oldYang.isYang)
    assertTrue(oldYang.isChanging)
    assertFalse(oldYang.transformedIsYang)
  }

  @Test
  fun kingWenSequenceAndTrigramsMatchAll64Hexagrams() {
    val expectedTrigrams = listOf(
      // Pair(upper, lower) for 1 to 64
      1 to (com.example.data.model.Trigram.QIAN to com.example.data.model.Trigram.QIAN),
      2 to (com.example.data.model.Trigram.KUN to com.example.data.model.Trigram.KUN),
      3 to (com.example.data.model.Trigram.KAN to com.example.data.model.Trigram.ZHEN),
      4 to (com.example.data.model.Trigram.GEN to com.example.data.model.Trigram.KAN),
      5 to (com.example.data.model.Trigram.KAN to com.example.data.model.Trigram.QIAN),
      6 to (com.example.data.model.Trigram.QIAN to com.example.data.model.Trigram.KAN),
      7 to (com.example.data.model.Trigram.KUN to com.example.data.model.Trigram.KAN),
      8 to (com.example.data.model.Trigram.KAN to com.example.data.model.Trigram.KUN),
      9 to (com.example.data.model.Trigram.XUN to com.example.data.model.Trigram.QIAN),
      10 to (com.example.data.model.Trigram.QIAN to com.example.data.model.Trigram.DUI),
      11 to (com.example.data.model.Trigram.KUN to com.example.data.model.Trigram.QIAN),
      12 to (com.example.data.model.Trigram.QIAN to com.example.data.model.Trigram.KUN),
      13 to (com.example.data.model.Trigram.QIAN to com.example.data.model.Trigram.LI),
      14 to (com.example.data.model.Trigram.LI to com.example.data.model.Trigram.QIAN),
      15 to (com.example.data.model.Trigram.KUN to com.example.data.model.Trigram.GEN),
      16 to (com.example.data.model.Trigram.ZHEN to com.example.data.model.Trigram.KUN),
      17 to (com.example.data.model.Trigram.DUI to com.example.data.model.Trigram.ZHEN),
      18 to (com.example.data.model.Trigram.GEN to com.example.data.model.Trigram.XUN),
      19 to (com.example.data.model.Trigram.KUN to com.example.data.model.Trigram.DUI),
      20 to (com.example.data.model.Trigram.XUN to com.example.data.model.Trigram.KUN),
      21 to (com.example.data.model.Trigram.LI to com.example.data.model.Trigram.ZHEN),
      22 to (com.example.data.model.Trigram.GEN to com.example.data.model.Trigram.LI),
      23 to (com.example.data.model.Trigram.GEN to com.example.data.model.Trigram.KUN),
      24 to (com.example.data.model.Trigram.KUN to com.example.data.model.Trigram.ZHEN),
      25 to (com.example.data.model.Trigram.QIAN to com.example.data.model.Trigram.ZHEN),
      26 to (com.example.data.model.Trigram.GEN to com.example.data.model.Trigram.QIAN),
      27 to (com.example.data.model.Trigram.GEN to com.example.data.model.Trigram.ZHEN),
      28 to (com.example.data.model.Trigram.DUI to com.example.data.model.Trigram.XUN),
      29 to (com.example.data.model.Trigram.KAN to com.example.data.model.Trigram.KAN),
      30 to (com.example.data.model.Trigram.LI to com.example.data.model.Trigram.LI),
      31 to (com.example.data.model.Trigram.DUI to com.example.data.model.Trigram.GEN),
      32 to (com.example.data.model.Trigram.ZHEN to com.example.data.model.Trigram.XUN),
      33 to (com.example.data.model.Trigram.QIAN to com.example.data.model.Trigram.GEN),
      34 to (com.example.data.model.Trigram.ZHEN to com.example.data.model.Trigram.QIAN),
      35 to (com.example.data.model.Trigram.LI to com.example.data.model.Trigram.KUN),
      36 to (com.example.data.model.Trigram.KUN to com.example.data.model.Trigram.LI),
      37 to (com.example.data.model.Trigram.XUN to com.example.data.model.Trigram.LI),
      38 to (com.example.data.model.Trigram.LI to com.example.data.model.Trigram.DUI),
      39 to (com.example.data.model.Trigram.KAN to com.example.data.model.Trigram.GEN),
      40 to (com.example.data.model.Trigram.ZHEN to com.example.data.model.Trigram.KAN),
      41 to (com.example.data.model.Trigram.GEN to com.example.data.model.Trigram.DUI),
      42 to (com.example.data.model.Trigram.XUN to com.example.data.model.Trigram.ZHEN),
      43 to (com.example.data.model.Trigram.DUI to com.example.data.model.Trigram.QIAN),
      44 to (com.example.data.model.Trigram.QIAN to com.example.data.model.Trigram.XUN),
      45 to (com.example.data.model.Trigram.DUI to com.example.data.model.Trigram.KUN),
      46 to (com.example.data.model.Trigram.KUN to com.example.data.model.Trigram.XUN),
      47 to (com.example.data.model.Trigram.DUI to com.example.data.model.Trigram.KAN),
      48 to (com.example.data.model.Trigram.KAN to com.example.data.model.Trigram.XUN),
      49 to (com.example.data.model.Trigram.DUI to com.example.data.model.Trigram.LI),
      50 to (com.example.data.model.Trigram.LI to com.example.data.model.Trigram.XUN),
      51 to (com.example.data.model.Trigram.ZHEN to com.example.data.model.Trigram.ZHEN),
      52 to (com.example.data.model.Trigram.GEN to com.example.data.model.Trigram.GEN),
      53 to (com.example.data.model.Trigram.XUN to com.example.data.model.Trigram.GEN),
      54 to (com.example.data.model.Trigram.ZHEN to com.example.data.model.Trigram.DUI),
      55 to (com.example.data.model.Trigram.ZHEN to com.example.data.model.Trigram.LI),
      56 to (com.example.data.model.Trigram.LI to com.example.data.model.Trigram.GEN),
      57 to (com.example.data.model.Trigram.XUN to com.example.data.model.Trigram.XUN),
      58 to (com.example.data.model.Trigram.DUI to com.example.data.model.Trigram.DUI),
      59 to (com.example.data.model.Trigram.XUN to com.example.data.model.Trigram.KAN),
      60 to (com.example.data.model.Trigram.KAN to com.example.data.model.Trigram.DUI),
      61 to (com.example.data.model.Trigram.XUN to com.example.data.model.Trigram.DUI),
      62 to (com.example.data.model.Trigram.ZHEN to com.example.data.model.Trigram.GEN),
      63 to (com.example.data.model.Trigram.KAN to com.example.data.model.Trigram.LI),
      64 to (com.example.data.model.Trigram.LI to com.example.data.model.Trigram.KAN)
    )

    assertEquals(64, expectedTrigrams.size)

    for ((number, trigramPair) in expectedTrigrams) {
      val (expectedUpper, expectedLower) = trigramPair
      val hex = HexagramLibrary.getByNumber(number)
      assertNotNull(hex)
      assertEquals("Hexagram $number upper trigram mismatch", expectedUpper, hex!!.upperTrigram)
      assertEquals("Hexagram $number lower trigram mismatch", expectedLower, hex.lowerTrigram)

      // Lower trigram corresponds to lines 0, 1, 2 (bottom to top)
      assertEquals("Hexagram $number line 1 mismatch", expectedLower.lines[0], hex.lines[0])
      assertEquals("Hexagram $number line 2 mismatch", expectedLower.lines[1], hex.lines[1])
      assertEquals("Hexagram $number line 3 mismatch", expectedLower.lines[2], hex.lines[2])

      // Upper trigram corresponds to lines 3, 4, 5 (bottom to top)
      assertEquals("Hexagram $number line 4 mismatch", expectedUpper.lines[0], hex.lines[3])
      assertEquals("Hexagram $number line 5 mismatch", expectedUpper.lines[1], hex.lines[4])
      assertEquals("Hexagram $number line 6 mismatch", expectedUpper.lines[2], hex.lines[5])

      // findByLines must find this exact hexagram
      val foundByLines = HexagramLibrary.findByLines(hex.lines)
      assertNotNull(foundByLines)
      assertEquals("findByLines for hexagram $number mismatch", number, foundByLines!!.number)

      // findByTrigrams must find this exact hexagram
      val foundByTrigrams = HexagramLibrary.findByTrigrams(expectedUpper, expectedLower)
      assertNotNull(foundByTrigrams)
      assertEquals("findByTrigrams for hexagram $number mismatch", number, foundByTrigrams!!.number)
    }
  }

  @Test
  fun allTrigramCombinationsAreUnique() {
    val trigramPairs = HexagramLibrary.allHexagrams.map { it.upperTrigram to it.lowerTrigram }
    assertEquals(64, trigramPairs.toSet().size)

    val lineSequences = HexagramLibrary.allHexagrams.map { it.lines }
    assertEquals(64, lineSequences.toSet().size)
  }

  @Test
  fun testHexagramTransformationLogic() {
    // Scenario 1: No changing lines (all 7s and 8s)
    // Lines: 7, 8, 7, 8, 7, 8 -> [true, false, true, false, true, false]
    val stableTosses = listOf(
      TossResult(0, Triple(3, 2, 2), 7),
      TossResult(1, Triple(2, 3, 3), 8),
      TossResult(2, Triple(3, 2, 2), 7),
      TossResult(3, Triple(2, 3, 3), 8),
      TossResult(4, Triple(3, 2, 2), 7),
      TossResult(5, Triple(2, 3, 3), 8)
    )
    val stablePrimaryLines = stableTosses.map { it.isYang }
    val stablePrimaryHex = HexagramLibrary.findByLines(stablePrimaryLines)
    assertNotNull(stablePrimaryHex)
    val stableChanging = stableTosses.filter { it.isChanging }
    assertEquals(0, stableChanging.size)
    assertEquals(63, stablePrimaryHex!!.number) // Water over Fire = Ji Ji

    // Scenario 2: Hexagram 1 (All Yang) with Line 1 changing (Old Yang = 9)
    // Line 1: 9 (changes to Yin / false), Lines 2-6: 7 (remain Yang / true)
    // Transformed lines: [false, true, true, true, true, true]
    // Lower trigram becomes: false, true, true -> Xun (Wind)
    // Upper trigram remains: true, true, true -> Qian (Heaven)
    // Wind below Heaven = Hexagram 44 (Gou / Coming to Meet)
    val changingTosses = listOf(
      TossResult(0, Triple(3, 3, 3), 9), // Line 1 is Old Yang
      TossResult(1, Triple(3, 2, 2), 7),
      TossResult(2, Triple(3, 2, 2), 7),
      TossResult(3, Triple(3, 2, 2), 7),
      TossResult(4, Triple(3, 2, 2), 7),
      TossResult(5, Triple(3, 2, 2), 7)
    )
    val primaryLines = changingTosses.map { it.isYang }
    val primaryHex = HexagramLibrary.findByLines(primaryLines)
    assertNotNull(primaryHex)
    assertEquals(1, primaryHex!!.number) // Pure Qian

    val changingIndices = changingTosses.filter { it.isChanging }.map { it.lineIndex + 1 }
    assertEquals(listOf(1), changingIndices)

    val transformedLines = changingTosses.map { it.transformedIsYang }
    assertEquals(listOf(false, true, true, true, true, true), transformedLines)
    val transformedHex = HexagramLibrary.findByLines(transformedLines)
    assertNotNull(transformedHex)
    assertEquals(44, transformedHex!!.number) // Qian over Xun = Gou

    // Scenario 3: Hexagram 2 (All Yin) with Line 6 changing (Old Yin = 6)
    // Lines 1-5: 8 (remain Yin / false), Line 6: 6 (changes to Yang / true)
    // Transformed lines: [false, false, false, false, false, true]
    // Lower trigram remains: Kun (Earth)
    // Upper trigram becomes: Gen (Mountain)
    // Mountain over Earth = Hexagram 23 (Bo / Splitting Apart)
    val kunChangingTosses = listOf(
      TossResult(0, Triple(2, 3, 3), 8),
      TossResult(1, Triple(2, 3, 3), 8),
      TossResult(2, Triple(2, 3, 3), 8),
      TossResult(3, Triple(2, 3, 3), 8),
      TossResult(4, Triple(2, 3, 3), 8),
      TossResult(5, Triple(2, 2, 2), 6) // Line 6 is Old Yin
    )
    val kunPrimary = HexagramLibrary.findByLines(kunChangingTosses.map { it.isYang })
    assertNotNull(kunPrimary)
    assertEquals(2, kunPrimary!!.number) // Kun
    val kunTransformed = HexagramLibrary.findByLines(kunChangingTosses.map { it.transformedIsYang })
    assertNotNull(kunTransformed)
    assertEquals(23, kunTransformed!!.number) // Gen over Kun = Bo
  }

  @Test
  fun invalidLookupsReturnNullWithoutFallback() {
    // Numbers outside 1..64 must return null and not silently fall back to Hexagram 1
    assertNull(HexagramLibrary.getByNumber(0))
    assertNull(HexagramLibrary.getByNumber(65))
    assertNull(HexagramLibrary.getByNumber(-1))
    assertNull(HexagramLibrary.getByNumber(100))

    // Line patterns that don't have exactly 6 lines must return null
    assertNull(HexagramLibrary.findByLines(emptyList()))
    assertNull(HexagramLibrary.findByLines(listOf(true)))
    assertNull(HexagramLibrary.findByLines(listOf(true, false, true)))
    assertNull(HexagramLibrary.findByLines(listOf(true, false, true, false, true)))
    assertNull(HexagramLibrary.findByLines(listOf(true, false, true, false, true, false, true)))

    // Trigram lookups with invalid line lengths must return null without falling back
    assertNull(Trigram.fromLines(emptyList()))
    assertNull(Trigram.fromLines(listOf(true, true)))
    assertNull(Trigram.fromLines(listOf(true, true, true, true)))
  }

  @Test
  fun hexagramModelSupportsSeparatedHistoricalAndModernLayers() {
    // Existing 64 hexagrams retain their structural data and have null defaults for new fields
    val qian = HexagramLibrary.getByNumber(1)
    assertNotNull(qian)
    assertEquals(1, qian!!.number)
    assertEquals("乾", qian.chinese)
    assertEquals("Qián", qian.pinyin)
    assertEquals("The Creative", qian.englishName)
    assertEquals(Trigram.QIAN, qian.upperTrigram)
    assertEquals(Trigram.QIAN, qian.lowerTrigram)
    assertEquals(6, qian.lines.size)

    // Unpopulated in the legacy entries (not falsely converted)
    assertNull(qian.sourceJudgment)
    assertNull(qian.sourceImage)
    assertNull(qian.sourceLineTexts)
    assertNull(qian.modernMeaning)
    assertTrue(qian.themes.isEmpty())
    assertNull(qian.advice)
    assertNull(qian.caution)
    assertNull(qian.lineInterpretations)

    // Model explicitly supports new fields for future historical interpretation system
    val modelWithSeparatedLayers = Hexagram(
      number = 1,
      chinese = "乾",
      pinyin = "Qián",
      englishName = "The Creative",
      upperTrigram = Trigram.QIAN,
      lowerTrigram = Trigram.QIAN,
      lines = listOf(true, true, true, true, true, true),
      sourceJudgment = "Historical hexagram statement",
      sourceImage = "Historical image text",
      sourceLineTexts = listOf("L1 text", "L2 text", "L3 text", "L4 text", "L5 text", "L6 text"),
      modernMeaning = "Contemporary explanation",
      themes = listOf("Initiation", "Strength", "Creative power"),
      advice = "Act with moral clarity and perseverance.",
      caution = "Beware hubris and premature action.",
      lineInterpretations = listOf("Wait", "Appear", "Labor", "Test", "Lead", "Beware")
    )

    assertEquals("Historical hexagram statement", modelWithSeparatedLayers.sourceJudgment)
    assertEquals("Historical image text", modelWithSeparatedLayers.sourceImage)
    assertEquals(6, modelWithSeparatedLayers.sourceLineTexts?.size)
    assertEquals("Contemporary explanation", modelWithSeparatedLayers.modernMeaning)
    assertEquals(3, modelWithSeparatedLayers.themes.size)
    assertEquals("Act with moral clarity and perseverance.", modelWithSeparatedLayers.advice)
    assertEquals("Beware hubris and premature action.", modelWithSeparatedLayers.caution)
    assertEquals(6, modelWithSeparatedLayers.lineInterpretations?.size)
  }
}

