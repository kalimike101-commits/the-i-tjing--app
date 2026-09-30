package com.example.data

import com.example.data.model.Hexagram
import com.example.data.model.Trigram

/**
 * Complete King Wen sequence of all 64 I-Ching Hexagrams.
 * Each hexagram includes authentic trigram pairs, canonical Chinese characters,
 * Pinyin, English titles, Judgment (彖辭), The Image (象辭), Situational Wisdom,
 * and 6-line commentaries.
 */
object HexagramLibrary {

    val allHexagrams: List<Hexagram> by lazy {
        listOf(
            Hexagram(
                number = 1,
                chinese = "乾",
                pinyin = "Qián",
                englishName = "The Creative",
                upperTrigram = Trigram.QIAN,
                lowerTrigram = Trigram.QIAN,
                lines = listOf(true, true, true, true, true, true),
                judgment = "The Creative works sublime success, furthering through perseverance. Pure Yang power initiates creation with boundless vitality.",
                theImage = "The movement of heaven is full of power. Thus the superior person makes himself strong and untiring.",
                commentary = "A time of supreme initiative, strength, and creative energy. Channel your inner power with unwavering integrity and clear moral purpose.",
                lineTexts = listOf(
                    "Line 1: Hidden dragon. Do not act. Conserve energy and prepare quietly.",
                    "Line 2: Dragon appearing in the field. It furthers one to seek out the great person.",
                    "Line 3: All day long active; at night watchful. Though in danger, no blame.",
                    "Line 4: Wavering flight over the depths. No blame. A testing of strength before leaping.",
                    "Line 5: Flying dragon in the heavens. Supreme achievement and harmonious influence.",
                    "Line 6: Arrogant dragon will have cause to repent. Pride invites downfall."
                )
            ),
            Hexagram(
                number = 2,
                chinese = "坤",
                pinyin = "Kūn",
                englishName = "The Receptive",
                upperTrigram = Trigram.KUN,
                lowerTrigram = Trigram.KUN,
                lines = listOf(false, false, false, false, false, false),
                judgment = "The Receptive brings sublime success. If the superior person undertakes something and tries to lead, he goes astray; if he follows, he finds guidance.",
                theImage = "The earth's condition is receptive devotion. Thus the superior person who has breadth of character sustains all things.",
                commentary = "Embrace devotion, patience, and yielding receptivity. Success comes not from aggressive pushing, but from allowing things to mature and supporting others.",
                lineTexts = listOf(
                    "Line 1: Frost underfoot; solid ice will soon follow. Recognize earliest signs.",
                    "Line 2: Straight, square, great. Without purpose, yet nothing remains unfurthered.",
                    "Line 3: Hidden lines of excellence. One is able to remain steadfast. Keep talent concealed.",
                    "Line 4: A tied sack. No blame, no praise. Strict discretion preserves peace.",
                    "Line 5: A yellow lower garment brings supreme good fortune. Modesty is celebrated.",
                    "Line 6: Dragons fighting in the meadow. Their blood is black and yellow. Extreme yielding turns to conflict."
                )
            ),
            Hexagram(
                number = 3,
                chinese = "屯",
                pinyin = "Zhūn",
                englishName = "Difficulty at the Beginning",
                upperTrigram = Trigram.KAN,
                lowerTrigram = Trigram.ZHEN,
                lines = listOf(true, false, false, false, true, false),
                judgment = "Difficulty at the Beginning works supreme success, furthering through perseverance. Nothing should be undertaken lightly. It furthers one to appoint helpers.",
                theImage = "Clouds and thunder: The image of Difficulty at the Beginning. Thus the superior person brings order out of confusion.",
                commentary = "A newborn seedling pushing through frozen soil. Chaos and uncertainty precede growth. Gather trusted allies and establish clarity before advancing.",
                lineTexts = listOf(
                    "Line 1: Hesitation and hindrance. It furthers one to remain steadfast and build alliances.",
                    "Line 2: Difficulties pile up. Horses and chariot part. Wait for natural right timing.",
                    "Line 3: Hunting deer without a guide; entering deep woods. Better to turn back.",
                    "Line 4: Seeking union. Going forward brings good fortune. Everything furthers.",
                    "Line 5: Difficulties in dispensing favors. A little perseverance brings good fortune; too much brings misfortune.",
                    "Line 6: Horses and chariot part. Striving in vain leads to tears of blood."
                )
            ),
            Hexagram(
                number = 4,
                chinese = "蒙",
                pinyin = "Méng",
                englishName = "Youthful Folly",
                upperTrigram = Trigram.GEN,
                lowerTrigram = Trigram.KAN,
                lines = listOf(false, true, false, false, false, true),
                judgment = "Youthful folly has success. It is not I who seek the young fool; the young fool seeks me. At the first oracle I inform him; if he importunes, it is disrespectful.",
                theImage = "A spring wells up at the foot of the mountain: The image of Youth. Thus the superior person fosters character by thoroughness in all that he does.",
                commentary = "Beginner's mind, inexperience, and the quest for wisdom. Approach learning with humility, respect the master's counsel, and learn from mistakes without vanity.",
                lineTexts = listOf(
                    "Line 1: To discipline a fool, remove his fetters. Too much severity causes regret.",
                    "Line 2: Bearing with fools in kindliness brings good fortune. Knowing how to accept inner weakness.",
                    "Line 3: Take not a maiden who forgets herself. Do not chase superficial desire.",
                    "Line 4: Entangled in folly. Humiliation follows when one stubbornly resists insight.",
                    "Line 5: Childlike folly brings good fortune. Innocence open to instruction.",
                    "Line 6: In punishing folly, it does not further one to commit excesses. Only guard against transgression."
                )
            ),
            Hexagram(
                number = 5,
                chinese = "需",
                pinyin = "Xū",
                englishName = "Waiting (Nourishment)",
                upperTrigram = Trigram.KAN,
                lowerTrigram = Trigram.QIAN,
                lines = listOf(true, true, true, false, true, false),
                judgment = "Waiting. If you are sincere, you have light and success. Perseverance brings good fortune. It furthers one to cross the great water.",
                theImage = "Clouds rise up to heaven: The image of Waiting. Thus the superior person eats, drinks, and is joyous of good cheer.",
                commentary = "Patient endurance while gathering inner strength. Danger lies ahead (Water above), but with inner power (Heaven below), waiting peacefully produces victory.",
                lineTexts = listOf(
                    "Line 1: Waiting in the meadow. It furthers one to abide in what endures. No blame.",
                    "Line 2: Waiting on the sand. There is some gossip. The end brings good fortune.",
                    "Line 3: Waiting in the mud brings about the arrival of the enemy. Guard your flank.",
                    "Line 4: Waiting in blood. Get out of the pit. Yield calmly to unavoidable storms.",
                    "Line 5: Waiting at meat and drink. Perseverance brings good fortune.",
                    "Line 6: One falls into the pit. Three uninvited guests arrive. Honor them and all ends well."
                )
            ),
            Hexagram(
                number = 6,
                chinese = "訟",
                pinyin = "Sòng",
                englishName = "Conflict",
                upperTrigram = Trigram.QIAN,
                lowerTrigram = Trigram.KAN,
                lines = listOf(false, true, false, true, true, true),
                judgment = "Conflict. You are sincere and are being obstructed. A cautious halt halfway brings good fortune. Going through to the end brings misfortune. Seek mediation.",
                theImage = "Heaven and water go their opposite ways: The image of Conflict. Thus the superior person carefully considers the beginning before planning.",
                commentary = "Clashing wills and divergent paths. Victory in contention is hollow and leaves bitterness. Strive for compromise and settle disagreements through fair counsel.",
                lineTexts = listOf(
                    "Line 1: If one does not perpetuate the affair, there is a little gossip. In the end, good fortune.",
                    "Line 2: One cannot contend; he returns home and yields. The people of his town remain free from guilt.",
                    "Line 3: Nourishing oneself on ancient virtue. Perseverance brings danger, but in the end good fortune.",
                    "Line 4: One cannot contend; he turns back and submits to fate. Peaceful perseverance brings good fortune.",
                    "Line 5: To contend before him brings supreme good fortune. An impartial judge delivers equity.",
                    "Line 6: Even if a leather belt is bestowed upon someone, by the end of morning it will be snatched away three times."
                )
            ),
            Hexagram(
                number = 7,
                chinese = "師",
                pinyin = "Shī",
                englishName = "The Army",
                upperTrigram = Trigram.KUN,
                lowerTrigram = Trigram.KAN,
                lines = listOf(false, true, false, false, false, false),
                judgment = "The Army requires perseverance and a strong, righteous leader. Good fortune without blame. Power must be governed by justice.",
                theImage = "In the middle of the earth is water: The image of the Army. Thus the superior person increases his masses by generosity toward the people.",
                commentary = "Discipline, collective mobilization, and unified purpose. Great endeavors demand selfless leadership, absolute order, and justice.",
                lineTexts = listOf(
                    "Line 1: An army must set forth in proper order. If the order is bad, misfortune threatens.",
                    "Line 2: In the midst of the army. Good fortune. No blame. The king bestows a triple decoration.",
                    "Line 3: Perchance the army carries corpses in the wagon. Misfortune.",
                    "Line 4: The army retreats in good order. No blame.",
                    "Line 5: Game in the field. It furthers one to catch it. Let the oldest lead; if the younger leads, corpses are carried.",
                    "Line 6: The great prince issues commands, founds states, and vests families with fiefs. Inferior people must not be employed."
                )
            ),
            Hexagram(
                number = 8,
                chinese = "比",
                pinyin = "Bǐ",
                englishName = "Holding Together (Union)",
                upperTrigram = Trigram.KAN,
                lowerTrigram = Trigram.KUN,
                lines = listOf(false, false, false, false, true, false),
                judgment = "Holding together brings good fortune. Inquire of the oracle once again whether you have sublimity, constancy, and perseverance; then there is no blame.",
                theImage = "Water over earth: The image of Holding Together. Thus the kings of antiquity established states and maintained friendly relations with princes.",
                commentary = "Cultivate harmony, solidarity, and mutual trust. Like water soaking naturally into the earth, join with others around shared principles. Hesitation brings isolation.",
                lineTexts = listOf(
                    "Line 1: Hold to him in truth and sincerity; this is without blame. Truth like a full earthen bowl brings unexpected good fortune.",
                    "Line 2: Hold to him inwardly. Perseverance brings good fortune.",
                    "Line 3: You hold together with the wrong people. Regret follows.",
                    "Line 4: Hold together with him openly. Perseverance brings good fortune.",
                    "Line 5: Manifestation of holding together. In the royal hunt, beaters drive game from three sides only, letting the front quarry escape.",
                    "Line 6: He finds no head for holding together. Misfortune."
                )
            ),
            Hexagram(
                number = 9,
                chinese = "小畜",
                pinyin = "Xiǎo Chù",
                englishName = "The Taming Power of the Small",
                upperTrigram = Trigram.XUN,
                lowerTrigram = Trigram.QIAN,
                lines = listOf(true, true, true, false, true, true),
                judgment = "The Taming Power of the Small has success. Dense clouds, no rain from our western borders. Gentle restraint paves the way.",
                theImage = "The wind drives across the sky: The image of Small Taming. Thus the superior person refines the outward aspect of his virtue.",
                commentary = "Gentle influence rather than forceful imposition. When big shifts are not yet ripe, small adjustments, courtesy, and quiet preparation accomplish great things.",
                lineTexts = listOf(
                    "Line 1: Return to the way. How could there be blame? This leads to good fortune.",
                    "Line 2: He allows himself to be drawn into returning. Good fortune.",
                    "Line 3: The spokes burst from the wagon wheels. Man and wife roll their eyes.",
                    "Line 4: If you are sincere, blood vanishes and fear gives way. No blame.",
                    "Line 5: If you are sincere and loyally attached, you are rich in your neighbor.",
                    "Line 6: The rain falls, the rest has come. Virtue is accumulated. Rest content and do not press further."
                )
            ),
            Hexagram(
                number = 10,
                chinese = "履",
                pinyin = "Lǚ",
                englishName = "Treading (Conduct)",
                upperTrigram = Trigram.QIAN,
                lowerTrigram = Trigram.DUI,
                lines = listOf(true, true, false, true, true, true),
                judgment = "Treading upon the tail of the tiger. It does not bite the man. Success. Tread carefully with respect and composure.",
                theImage = "Heaven above, lake below: The image of Treading. Thus the superior person distinguishes between high and low, settling the aims of the people.",
                commentary = "Moving with grace and mindful awareness through delicate or perilous situations. Politeness, self-control, and integrity disarm hostility.",
                lineTexts = listOf(
                    "Line 1: Simple conduct. Progress without blame.",
                    "Line 2: Treading a smooth, level path. The quiet persevering person has good fortune.",
                    "Line 3: A one-eyed man can see, a lame man can tread. He treads upon the tiger's tail; it bites him. Misfortune.",
                    "Line 4: He treads on the tiger's tail. Circumspection and caution lead at last to good fortune.",
                    "Line 5: Resolute conduct. Perseverance with awareness of danger.",
                    "Line 6: Look to your conduct and weigh the favorable signs. When everything is fulfilled, supreme good fortune follows."
                )
            ),
            Hexagram(
                number = 11,
                chinese = "泰",
                pinyin = "Tài",
                englishName = "Peace (Harmony)",
                upperTrigram = Trigram.KUN,
                lowerTrigram = Trigram.QIAN,
                lines = listOf(true, true, true, false, false, false),
                judgment = "Peace. The small departs, the great approaches. Good fortune. Success. Heaven and Earth intermingle in fertile bloom.",
                theImage = "Heaven and earth unite: The image of Peace. Thus the ruler divides and completes the course of heaven and earth, aiding the people.",
                commentary = "A golden era of mutual understanding, prosperity, and communion between higher and lower realms. Cultivate goodwill and prepare for future cycles.",
                lineTexts = listOf(
                    "Line 1: When ribbon grass is pulled up, the sod comes with it. Each according to his kind. Undertakings bring good fortune.",
                    "Line 2: Bearing with the uncultured in gentleness, fording the river with resolution, neglecting not the distant. Thus one walks in the middle.",
                    "Line 3: No plain not followed by a slope, no going not followed by a return. He who remains steadfast in danger is without blame.",
                    "Line 4: He flutters down, not boasting of his wealth, together with his neighbor, guileless and sincere.",
                    "Line 5: The sovereign gives his daughter in marriage. This brings blessing and supreme good fortune.",
                    "Line 6: The wall falls back into the moat. Use no army now. Make your orders known in your own town. Perseverance brings humiliation."
                )
            ),
            Hexagram(
                number = 12,
                chinese = "否",
                pinyin = "Pǐ",
                englishName = "Standstill (Stagnation)",
                upperTrigram = Trigram.QIAN,
                lowerTrigram = Trigram.KUN,
                lines = listOf(false, false, false, true, true, true),
                judgment = "Standstill. Evil people do not further the perseverance of the superior person. The great departs, the small approaches.",
                theImage = "Heaven and earth do not unite: The image of Standstill. Thus the superior person falls back upon his inner worth in order to escape difficulties.",
                commentary = "Disconnection, obstruction, and creative winter. Withdraw gracefully into inner virtue rather than casting pearls before swine.",
                lineTexts = listOf(
                    "Line 1: When ribbon grass is pulled up, the sod comes with it. Perseverance brings good fortune and success.",
                    "Line 2: They bear and endure; this means good fortune for inferior people. The standstill serves to help the great person attain success.",
                    "Line 3: They bear shame. Covert misconduct is exposed.",
                    "Line 4: He who acts at the command of the highest remains without blame. Those of like mind partake of the blessing.",
                    "Line 5: Standstill is giving way. Good fortune for the great person. 'What if it should fail, what if it should fail?' Thus he ties it to a cluster of mulberry shoots.",
                    "Line 6: The standstill comes to an end. First standstill, then good fortune."
                )
            ),
            Hexagram(
                number = 13,
                chinese = "同人",
                pinyin = "Tóng Rén",
                englishName = "Fellowship with Men",
                upperTrigram = Trigram.QIAN,
                lowerTrigram = Trigram.LI,
                lines = listOf(true, false, true, true, true, true),
                judgment = "Fellowship with Men in the open. Success. It furthers one to cross the great water. The perseverance of the superior person furthers.",
                theImage = "Heaven together with fire: The image of Fellowship. Thus the superior person organizes the clans and makes distinctions between things.",
                commentary = "Broad universal community transcending narrow ego, prejudice, and private cliques. Gather openly under the sun of mutual respect.",
                lineTexts = listOf(
                    "Line 1: Fellowship with men at the gate. No blame.",
                    "Line 2: Fellowship with men in the clan. Humiliation.",
                    "Line 3: He hides weapons in the thicket; he climbs the high hill. For three years he does not rise up.",
                    "Line 4: He climbs up on his wall; he cannot attack. Good fortune.",
                    "Line 5: Men bound in fellowship first weep and lament, but afterward they laugh. After great struggles they succeed in meeting.",
                    "Line 6: Fellowship with men in the meadow. No regret."
                )
            ),
            Hexagram(
                number = 14,
                chinese = "大有",
                pinyin = "Dà Yǒu",
                englishName = "Possession in Great Measure",
                upperTrigram = Trigram.LI,
                lowerTrigram = Trigram.QIAN,
                lines = listOf(true, true, true, true, false, true),
                judgment = "Possession in Great Measure. Supreme success. Sun shining high in the heaven brings clarity and abundance.",
                theImage = "Fire in heaven above: The image of Possession in Great Measure. Thus the superior person curbs evil and furthers good, obeying the benevolent will of heaven.",
                commentary = "A period of radiant prosperity, influence, and strength. True wealth is exercised through modesty, generosity, and service to the greater good.",
                lineTexts = listOf(
                    "Line 1: No relationship with what is harmful; there is no blame in this. Remain conscious of difficulties.",
                    "Line 2: A big wagon for loading. One may undertake something. No blame.",
                    "Line 3: A prince offers it to the Son of Heaven. A petty man cannot do this.",
                    "Line 4: He makes a difference between himself and his neighbor. No blame.",
                    "Line 5: He whose truth is accessible, yet dignified, has good fortune.",
                    "Line 6: He is blessed by heaven. Good fortune. Everything furthers."
                )
            ),
            Hexagram(
                number = 15,
                chinese = "謙",
                pinyin = "Qiān",
                englishName = "Modesty",
                upperTrigram = Trigram.KUN,
                lowerTrigram = Trigram.GEN,
                lines = listOf(false, false, true, false, false, false),
                judgment = "Modesty creates success. The superior person carries things through to completion without boasting.",
                theImage = "Within the earth, a mountain: The image of Modesty. Thus the superior person reduces that which is too much and augments that which is too little.",
                commentary = "The mountain hides its towering grandeur beneath the flat earth. Modesty balances extremes, wins friends, and preserves enduring fortune.",
                lineTexts = listOf(
                    "Line 1: A modest superior person may cross the great water. Good fortune.",
                    "Line 2: Modesty that comes to expression. Perseverance brings good fortune.",
                    "Line 3: A superior person of modesty and merit carries things to completion. Good fortune.",
                    "Line 4: Nothing that would not further modesty in movement.",
                    "Line 5: No boasting of wealth before one's neighbor. It is favorable to attack with force. Everything furthers.",
                    "Line 6: Modesty that comes to expression. It is favorable to set armies marching to discipline one's own city and one's country."
                )
            ),
            Hexagram(
                number = 16,
                chinese = "豫",
                pinyin = "Yù",
                englishName = "Enthusiasm",
                upperTrigram = Trigram.ZHEN,
                lowerTrigram = Trigram.KUN,
                lines = listOf(false, false, false, true, false, false),
                judgment = "Enthusiasm. It furthers one to install helpers and to set armies marching. Joyful inspiration moves mountains.",
                theImage = "Thunder comes resounding out of the earth: The image of Enthusiasm. Thus the ancient kings made music in order to honor merit.",
                commentary = "A surge of inspiring vitality, music, and collective energy. Align with natural laws and inspire others from genuine sincerity.",
                lineTexts = listOf(
                    "Line 1: Enthusiasm that expresses itself brings misfortune.",
                    "Line 2: Firm as a rock. Not a whole day. Perseverance brings good fortune.",
                    "Line 3: Enthusiasm that looks upward creates remorse. Hesitation brings remorse.",
                    "Line 4: The source of enthusiasm. He achieves great things. Doubt not. You gather friends around you.",
                    "Line 5: Persistently ill, and still does not die. Enduring hardship.",
                    "Line 6: Deluded enthusiasm. But if after completion one changes, there is no blame."
                )
            ),
            Hexagram(
                number = 17,
                chinese = "隨",
                pinyin = "Suí",
                englishName = "Following",
                upperTrigram = Trigram.DUI,
                lowerTrigram = Trigram.ZHEN,
                lines = listOf(true, false, false, true, true, false),
                judgment = "Following has supreme success. Perseverance furthers. No blame. Adapt gracefully to circumstances.",
                theImage = "Thunder in the middle of the lake: The image of Following. Thus the superior person at nightfall goes indoors for rest and recuperation.",
                commentary = "Lead by serving, achieve by yielding. When thunder rests contentedly beneath joyous water, natural movement brings effortless success.",
                lineTexts = listOf(
                    "Line 1: The standard changes. Perseverance brings good fortune. To go out of the door produces deeds.",
                    "Line 2: If one clings to the little boy, one loses the experienced man.",
                    "Line 3: If one clings to the experienced man, one loses the little boy. Through following one finds what one seeks.",
                    "Line 4: Following creates success. Perseverance brings misfortune. Go your way with sincerity.",
                    "Line 5: Sincere in the good. Good fortune.",
                    "Line 6: He meets with firm allegiance and is still further bound. The king introduces him to the Western Mountain."
                )
            ),
            Hexagram(
                number = 18,
                chinese = "蠱",
                pinyin = "Gǔ",
                englishName = "Work on the Decayed (Corruption)",
                upperTrigram = Trigram.GEN,
                lowerTrigram = Trigram.XUN,
                lines = listOf(false, true, true, false, false, true),
                judgment = "Work on what has been spoiled has supreme success. It furthers one to cross the great water. Before the starting point, three days; after the starting point, three days.",
                theImage = "The wind blows low on the mountain: The image of Decay. Thus the superior person stirs up the people and strengthens their spirit.",
                commentary = "Addressing neglect, repairing past mistakes, and clearing away stagnation. Renovation requires courage, careful planning, and conscious resolve.",
                lineTexts = listOf(
                    "Line 1: Setting right what has been spoiled by the father. If there is a son, no blame rests upon the departed father.",
                    "Line 2: Setting right what has been spoiled by the mother. One must not be too persevering.",
                    "Line 3: Setting right what has been spoiled by the father. There will be a little remorse. No great blame.",
                    "Line 4: Tolerating what has been spoiled by the father. In continuing one sees humiliation.",
                    "Line 5: Setting right what has been spoiled by the father. One meets with praise.",
                    "Line 6: He does not serve kings and princes, sets himself higher goals."
                )
            ),
            Hexagram(
                number = 19,
                chinese = "臨",
                pinyin = "Lín",
                englishName = "Approach",
                upperTrigram = Trigram.KUN,
                lowerTrigram = Trigram.DUI,
                lines = listOf(true, true, false, false, false, false),
                judgment = "Approach has supreme success. Perseverance furthers. When the eighth month comes, there will be misfortune. Act while the light rises.",
                theImage = "The earth above the lake: The image of Approach. Thus the superior person is inexhaustible in his will to teach, and without bounds in protecting the people.",
                commentary = "Expanding influence, springtime warmth, and welcoming leadership. Seize the momentum of growth now, anticipating future shifts with foresight.",
                lineTexts = listOf(
                    "Line 1: Joint approach. Perseverance brings good fortune.",
                    "Line 2: Joint approach. Good fortune. Everything furthers.",
                    "Line 3: Comfortable approach. Nothing that would further. If one is induced to grieve over it, one becomes free of blame.",
                    "Line 4: Complete approach. No blame.",
                    "Line 5: Wise approach. This is right for a great prince. Good fortune.",
                    "Line 6: Greathearted approach. Good fortune. No blame."
                )
            ),
            Hexagram(
                number = 20,
                chinese = "觀",
                pinyin = "Guān",
                englishName = "Contemplation (View)",
                upperTrigram = Trigram.XUN,
                lowerTrigram = Trigram.KUN,
                lines = listOf(false, false, false, false, true, true),
                judgment = "Contemplation. The ablution has been made, but not yet the offering. Full of trust they look up to him. Be an example of serene reverence.",
                theImage = "The wind blows over the earth: The image of Contemplation. Thus the ancient kings examined the regions of the world and guided the people.",
                commentary = "Step back to see the grand panorama. Deep observation, inner meditation, and setting an inspiring moral standard guide others effortlessly.",
                lineTexts = listOf(
                    "Line 1: Boylike contemplation. For an inferior man, no blame. For a superior person, humiliation.",
                    "Line 2: Contemplation through the crack of the door. Furthering for the perseverance of a woman.",
                    "Line 3: Contemplation of my life decides the choice between advance and retreat.",
                    "Line 4: Contemplation of the light of the realm. It furthers one to exert influence as the guest of a king.",
                    "Line 5: Contemplation of my life. The superior person is without blame.",
                    "Line 6: Contemplation of their life. The superior person is without blame."
                )
            ),
            Hexagram(
                number = 21,
                chinese = "噬嗑",
                pinyin = "Shì Kè",
                englishName = "Biting Through",
                upperTrigram = Trigram.LI,
                lowerTrigram = Trigram.ZHEN,
                lines = listOf(true, false, false, true, false, true),
                judgment = "Biting Through has success. It is favorable to let justice be administered. Remove obstacles decisively.",
                theImage = "Thunder and lightning: The image of Biting Through. Thus the kings of former times made firm the laws through clearly defined penalties.",
                commentary = "An obstruction between the jaws must be bitten through firmly. Clear misunderstandings, enforce fair rules, and confront difficulties without hesitation.",
                lineTexts = listOf(
                    "Line 1: His feet are fastened in the stocks, so that his toes disappear. No blame.",
                    "Line 2: Bites through tender meat, so that his nose disappears. No blame.",
                    "Line 3: Bites on old dried meat and strikes on something poisonous. Slight humiliation. No blame.",
                    "Line 4: Bites on dried gristly meat. Receives metal arrows. It furthers one to be mindful of difficulties and persevering.",
                    "Line 5: Bites on dried lean meat. Receives yellow gold. Steadfast perseverance with awareness of danger. No blame.",
                    "Line 6: His neck is fastened in the wooden cangue, so that his ears disappear. Misfortune."
                )
            ),
            Hexagram(
                number = 22,
                chinese = "賁",
                pinyin = "Bì",
                englishName = "Grace (Beauty)",
                upperTrigram = Trigram.GEN,
                lowerTrigram = Trigram.LI,
                lines = listOf(true, false, true, false, false, true),
                judgment = "Grace has success. In small matters it is favorable to undertake something. Form should express substance, not conceal it.",
                theImage = "Fire at the foot of the mountain: The image of Grace. Thus does the superior person proceed when clearing up small matters. But he does not dare decide grave issues this way.",
                commentary = "Aesthetic harmony, elegance, and culture. True grace illuminates inner truth rather than masking empty pretension.",
                lineTexts = listOf(
                    "Line 1: He lends grace to his toes, leaves the carriage, and walks.",
                    "Line 2: Lends grace to the beard on his chin.",
                    "Line 3: Graceful and moist. Constant perseverance brings good fortune.",
                    "Line 4: Grace or simplicity? A white horse comes as if on wings. He is not a robber, he will woo at the right time.",
                    "Line 5: Grace in hills and gardens. The roll of silk is meager and small. Humiliation, but in the end good fortune.",
                    "Line 6: Simple grace. No blame. True beauty returns to white simplicity."
                )
            ),
            Hexagram(
                number = 23,
                chinese = "剝",
                pinyin = "Bō",
                englishName = "Splitting Apart",
                upperTrigram = Trigram.GEN,
                lowerTrigram = Trigram.KUN,
                lines = listOf(false, false, false, false, false, true),
                judgment = "Splitting Apart. It does not further one to go anywhere. Inferior elements undermine the foundation. Endure patiently.",
                theImage = "The mountain rests on the earth: The image of Splitting Apart. Thus those above can ensure their position only by giving generously to those below.",
                commentary = "Autumn decay and erosion. Only one line of Yang remains at the summit. Do not initiate new attacks; yield gracefully and protect your core integrity.",
                lineTexts = listOf(
                    "Line 1: The leg of the bed is split. Those who persevere are destroyed. Misfortune.",
                    "Line 2: The bed is split at the edge. Those who persevere are destroyed. Misfortune.",
                    "Line 3: He splits with them. No blame.",
                    "Line 4: The bed is split up to the skin. Misfortune.",
                    "Line 5: A shoal of fishes. Favor comes through the court ladies. Everything furthers.",
                    "Line 6: There is a large fruit still uneaten. The superior person receives a carriage. The house of the inferior person is split apart."
                )
            ),
            Hexagram(
                number = 24,
                chinese = "復",
                pinyin = "Fù",
                englishName = "Return (The Turning Point)",
                upperTrigram = Trigram.KUN,
                lowerTrigram = Trigram.ZHEN,
                lines = listOf(true, false, false, false, false, false),
                judgment = "Return. Success. Going out and coming in without error. Friends come without blame. To and fro goes the way. On the seventh day comes return. It furthers one to have somewhere to go.",
                theImage = "Thunder within the earth: The image of the Turning Point. Thus the kings of antiquity closed the passes at the solstice.",
                commentary = "The winter solstice; the rebirth of light in the depths of darkness. Gentle beginnings require calm nurturing. Rest and let vitality renew itself.",
                lineTexts = listOf(
                    "Line 1: Return from a short distance. No need for remorse. Great good fortune.",
                    "Line 2: Quiet return. Good fortune.",
                    "Line 3: Repeated return. Danger. No blame.",
                    "Line 4: Walking in the midst of others, one returns alone.",
                    "Line 5: Noblehearted return. No remorse.",
                    "Line 6: Missing the return. Misfortune. Calamity and devastation. If armies are set marching, one suffers a great defeat."
                )
            ),
            Hexagram(
                number = 25,
                chinese = "無妄",
                pinyin = "Wú Wàng",
                englishName = "Innocence (The Unexpected)",
                upperTrigram = Trigram.QIAN,
                lowerTrigram = Trigram.ZHEN,
                lines = listOf(true, false, false, true, true, true),
                judgment = "Innocence. Supreme success. Perseverance furthers. If someone is not as he should be, he has misfortune, and it does not further him to undertake anything.",
                theImage = "Under heaven thunder rolls: All things attain the natural state of innocence. Thus the kings of old nurtured all beings with rich and timely care.",
                commentary = "Acting purely without hidden ulterior motives or contrived schemes. Follow the spontaneous promptings of a pure heart, accepting whatever fortune arrives.",
                lineTexts = listOf(
                    "Line 1: Innocent action brings good fortune.",
                    "Line 2: If one does not count on the harvest while plowing, nor on the use of the ground while clearing it, it furthers one to undertake something.",
                    "Line 3: Undeserved misfortune. The cow that was tethered by someone is the wanderer's gain, the citizen's loss.",
                    "Line 4: He who can be steadfast in innocence remains without blame.",
                    "Line 5: Use no medicine in an illness incurred through no fault of your own. It will pass of itself.",
                    "Line 6: Innocent action brings misfortune. Time is not ripe to advance."
                )
            ),
            Hexagram(
                number = 26,
                chinese = "大畜",
                pinyin = "Dà Chù",
                englishName = "The Taming Power of the Great",
                upperTrigram = Trigram.GEN,
                lowerTrigram = Trigram.QIAN,
                lines = listOf(true, true, true, false, false, true),
                judgment = "The Taming Power of the Great. Perseverance furthers. Not eating at home brings good fortune. It furthers one to cross the great water.",
                theImage = "Heaven within the mountain: The image of the Great Taming. Thus the superior person acquaints himself with many sayings and deeds of antiquity to store up virtue.",
                commentary = "Immense potential contained and disciplined through inner restraint. Channel great vitality toward noble and enduring achievements.",
                lineTexts = listOf(
                    "Line 1: Danger is at hand. It furthers one to desist.",
                    "Line 2: The axletrees are taken off the wagon.",
                    "Line 3: A good horse that follows others. Awareness of danger, with perseverance, furthers.",
                    "Line 4: The headboard on a young bull. Great good fortune.",
                    "Line 5: The tusk of a gelded boar. Good fortune.",
                    "Line 6: One attains the way of heaven. Success."
                )
            ),
            Hexagram(
                number = 27,
                chinese = "頤",
                pinyin = "Yí",
                englishName = "The Corners of the Mouth (Nourishment)",
                upperTrigram = Trigram.GEN,
                lowerTrigram = Trigram.ZHEN,
                lines = listOf(true, false, false, false, false, true),
                judgment = "The Corners of the Mouth. Perseverance brings good fortune. Pay heed to the providing of nourishment and to what a person seeks to fill his mouth with.",
                theImage = "At the foot of the mountain, thunder: The image of Nourishment. Thus the superior person is careful of his words and temperate in eating and drinking.",
                commentary = "Discernment in what you consume and what you express. Nourish body, mind, and spirit with wholesome truth and refrain from careless speech.",
                lineTexts = listOf(
                    "Line 1: You let your magic tortoise go, and look at me with the corners of your mouth drooping. Misfortune.",
                    "Line 2: Turning down from the path to seek nourishment from the hill. Continuing brings misfortune.",
                    "Line 3: Turning away from nourishment. Perseverance brings misfortune. Do not act thus for ten years.",
                    "Line 4: Turning to the summit for nourishment brings good fortune. Spying around like a tiger with insatiable craving. No blame.",
                    "Line 5: Turning away from the path. To remain persevering brings good fortune. One should not cross the great water.",
                    "Line 6: The source of nourishment. Awareness of danger brings good fortune. It furthers one to cross the great water."
                )
            ),
            Hexagram(
                number = 28,
                chinese = "大過",
                pinyin = "Dà Guò",
                englishName = "Preponderance of the Great",
                upperTrigram = Trigram.DUI,
                lowerTrigram = Trigram.XUN,
                lines = listOf(false, true, true, true, true, false),
                judgment = "Preponderance of the Great. The ridgepole sags to the breaking point. It furthers one to have somewhere to go. Success through decisive action.",
                theImage = "The lake rises above the trees: The image of Preponderance of the Great. Thus the superior person, when standing alone, is unconcerned, and if he must renounce the world, he is undaunted.",
                commentary = "Extraordinary pressure requiring extraordinary measures. The beam is overburdened; act courageously and stand steadfast without fear.",
                lineTexts = listOf(
                    "Line 1: To spread white rushes underneath. No blame. Extraordinary caution.",
                    "Line 2: A dry poplar puts forth sprouts. An older man takes a young wife. Everything furthers.",
                    "Line 3: The ridgepole sags to the breaking point. Misfortune.",
                    "Line 4: The ridgepole is braced. Good fortune. If there are ulterior motives, it is humiliating.",
                    "Line 5: A withered poplar puts forth flowers. An older woman takes a husband. No blame, no praise.",
                    "Line 6: One must go through the water. It rises over one's head. Misfortune. No blame."
                )
            ),
            Hexagram(
                number = 29,
                chinese = "坎",
                pinyin = "Kǎn",
                englishName = "The Abysmal (Water / Danger)",
                upperTrigram = Trigram.KAN,
                lowerTrigram = Trigram.KAN,
                lines = listOf(false, true, false, false, true, false),
                judgment = "The Abysmal repeated. If you are sincere, you have success in your heart, and whatever you do succeeds. Water flows constantly without losing its nature.",
                theImage = "Water flows on unabated and reaches its goal: The image of the Abysmal repeated. Thus the superior person walks in lasting virtue and carries on the business of teaching.",
                commentary = "Navigating perilous depths with unwavering sincerity. Like a river flowing through ravines, stay true to your essence and forge forward calmly.",
                lineTexts = listOf(
                    "Line 1: Pit within pit. In danger one enters a ravine. Misfortune.",
                    "Line 2: The abyss is dangerous. One should strive to attain small things only.",
                    "Line 3: Forward and backward, abyss on abyss. In such danger, pause at first, else you will fall into the pit.",
                    "Line 4: A jug of wine, a bowl of rice, earthen vessels simply handed through the window. No blame in the end.",
                    "Line 5: The abyss is not filled to overflowing, it is filled only to the rim. No blame.",
                    "Line 6: Bound with cords and ropes, shut in between thorny prison walls. For three years he does not find the way. Misfortune."
                )
            ),
            Hexagram(
                number = 30,
                chinese = "離",
                pinyin = "Lí",
                englishName = "The Clinging (Fire)",
                upperTrigram = Trigram.LI,
                lowerTrigram = Trigram.LI,
                lines = listOf(true, false, true, true, false, true),
                judgment = "The Clinging. Perseverance furthers. It brings success. Care of the cow brings good fortune. Fire must cling to fuel to shine.",
                theImage = "Brightness doubled: The image of Fire. Thus the great person, by perpetuating this brightness, illumines the four quarters of the world.",
                commentary = "Clarity of vision, radiant intellect, and warm illumination. Ensure that your energy is grounded in dependable fuel and gentle devotion.",
                lineTexts = listOf(
                    "Line 1: The footprints run crisscross. If one is seriously intent, no blame.",
                    "Line 2: Yellow light. Supreme good fortune.",
                    "Line 3: In the light of the setting sun, men either beat the pot and sing or loudly bewail the approach of old age. Misfortune.",
                    "Line 4: Its coming is sudden; it flames up, dies down, is thrown away.",
                    "Line 5: Tears in floods, sighing and lamenting. Good fortune.",
                    "Line 6: The king uses him to march forth and chastise. Then it is best to kill the leaders and take captive the followers. No blame."
                )
            ),
            Hexagram(
                number = 31,
                chinese = "咸",
                pinyin = "Xián",
                englishName = "Influence (Wooing)",
                upperTrigram = Trigram.DUI,
                lowerTrigram = Trigram.GEN,
                lines = listOf(false, false, true, true, true, false),
                judgment = "Influence. Success. Perseverance furthers. To take a maiden to wife brings good fortune. Mutual attraction creates open harmony.",
                theImage = "A lake on the mountain: The image of Influence. Thus the superior person encourages people to approach him by his readiness to receive them.",
                commentary = "Mutual resonance, genuine chemistry, and heart-to-heart communication. Empty the mind of preconceptions to allow subtle feelings to connect.",
                lineTexts = listOf(
                    "Line 1: The influence shows itself in the big toe.",
                    "Line 2: The influence shows itself in the calves of the legs. Misfortune. Tarrying brings good fortune.",
                    "Line 3: The influence shows itself in the thighs. Clinging to that which follows. To continue brings humiliation.",
                    "Line 4: Perseverance brings good fortune. Remorse disappears. If a man is agitated in mind, only friends follow his thoughts.",
                    "Line 5: The influence shows itself in the back of the neck. No remorse.",
                    "Line 6: The influence shows itself in the jaws, cheeks, and tongue. Mere chatter."
                )
            ),
            Hexagram(
                number = 32,
                chinese = "恆",
                pinyin = "Héng",
                englishName = "Duration (Constancy)",
                upperTrigram = Trigram.ZHEN,
                lowerTrigram = Trigram.XUN,
                lines = listOf(false, true, true, true, false, false),
                judgment = "Duration. Success. No blame. Perseverance furthers. It furthers one to have somewhere to go. Enduring rhythm outlasts transient storms.",
                theImage = "Thunder and wind: The image of Duration. Thus the superior person stands firm and does not change his direction.",
                commentary = "Long-term dedication and unwavering consistency of character. Like the wind and thunder in perpetual seasonal movement, cultivate endurance.",
                lineTexts = listOf(
                    "Line 1: Seeking duration too hastily brings misfortune persistently. Nothing that would further.",
                    "Line 2: Remorse disappears.",
                    "Line 3: He who does not give duration to his character meets with disgrace. Persistent humiliation.",
                    "Line 4: No game in the field. Lack of persistence where it counts.",
                    "Line 5: Giving duration to one's character through perseverance. Good fortune for a woman, misfortune for a man.",
                    "Line 6: Restlessness as an enduring condition brings misfortune."
                )
            ),
            Hexagram(
                number = 33,
                chinese = "遯",
                pinyin = "Dùn",
                englishName = "Retreat",
                upperTrigram = Trigram.QIAN,
                lowerTrigram = Trigram.GEN,
                lines = listOf(false, false, true, true, true, true),
                judgment = "Retreat. Success. In what is small, perseverance furthers. Knowing when to step back preserves dignity and strength.",
                theImage = "Mountain under heaven: The image of Retreat. Thus the superior person keeps the petty man at a distance, not with anger but with reserve.",
                commentary = "A strategic, graceful withdrawal before mounting obstacles. Retreat is not defeat; it is an intelligent preservation of vital forces.",
                lineTexts = listOf(
                    "Line 1: At the tail in retreat. This is perilous. One must not undertake anything.",
                    "Line 2: He holds him fast with yellow oxhide. No one can tear him away.",
                    "Line 3: A halted retreat is nerve-wracking and dangerous. To retain people as men- and maidservants brings good fortune.",
                    "Line 4: Voluntary retreat brings good fortune to the superior person and downfall to the inferior man.",
                    "Line 5: Friendly retreat. Perseverance brings good fortune.",
                    "Line 6: Cheerful retreat. Everything furthers."
                )
            ),
            Hexagram(
                number = 34,
                chinese = "大壯",
                pinyin = "Dà Zhuàng",
                englishName = "The Power of the Great",
                upperTrigram = Trigram.ZHEN,
                lowerTrigram = Trigram.QIAN,
                lines = listOf(true, true, true, true, false, false),
                judgment = "The Power of the Great. Perseverance furthers. Power must be accompanied by righteousness and restraint, never reckless force.",
                theImage = "Thunder in heaven above: The image of the Power of the Great. Thus the superior person does not tread upon paths that do not accord with established order.",
                commentary = "Robust vigor and abundant power. Avoid the temptation of brute force (the ram butting the hedge). Guide great strength with ethical restraint.",
                lineTexts = listOf(
                    "Line 1: Power in the toes. Continuing brings misfortune. This is certainly true.",
                    "Line 2: Perseverance brings good fortune.",
                    "Line 3: The inferior man works through power; the superior person does not act thus. Danger. A goat butts against a hedge and gets his horns entangled.",
                    "Line 4: Perseverance brings good fortune. Remorse disappears. The hedge opens; there is no entanglement.",
                    "Line 5: Loses the goat with ease. No remorse.",
                    "Line 6: A goat butts against a hedge. It cannot go backward, it cannot go forward. Nothing serves to further. If one notes the difficulty, this brings good fortune."
                )
            ),
            Hexagram(
                number = 35,
                chinese = "晉",
                pinyin = "Jìn",
                englishName = "Progress",
                upperTrigram = Trigram.LI,
                lowerTrigram = Trigram.KUN,
                lines = listOf(false, false, false, true, false, true),
                judgment = "Progress. The powerful prince is honored with horses in large numbers. In a single day he is granted audience three times.",
                theImage = "The sun rises over the earth: The image of Progress. Thus the superior person himself brightens his bright virtue.",
                commentary = "The morning sun ascending above the horizon, spreading light across the kingdom. Rapid advancement, public recognition, and noble duty.",
                lineTexts = listOf(
                    "Line 1: Progressing, but turned back. Perseverance brings good fortune. If one meets with no confidence, one should remain calm. No blame.",
                    "Line 2: Progressing, but in sorrow. Perseverance brings good fortune. Then one obtains great happiness from one's ancestress.",
                    "Line 3: All are in accord. Remorse disappears.",
                    "Line 4: Progress like a hamster. Perseverance brings danger.",
                    "Line 5: Remorse disappears. Take not gain and loss to heart. Undertakings bring good fortune. Everything furthers.",
                    "Line 6: Making progress with the horns is permissible only for the purpose of punishing one's own city. Awareness of danger brings good fortune. No blame."
                )
            ),
            Hexagram(
                number = 36,
                chinese = "明夷",
                pinyin = "Míng Yí",
                englishName = "Darkening of the Light",
                upperTrigram = Trigram.KUN,
                lowerTrigram = Trigram.LI,
                lines = listOf(true, false, true, false, false, false),
                judgment = "Darkening of the Light. In adversity it furthers one to be persevering. Conceal your brilliance when dark forces prevail.",
                theImage = "The light has sunk into the earth: The image of Darkening of the Light. Thus does the superior person live with the great mass: he veils his light, yet still shines.",
                commentary = "Surviving periods of oppression or injustice. Do not needlessly flaunt your gifts to provoke envy; preserve your inner flame secretly and patiently.",
                lineTexts = listOf(
                    "Line 1: Darkening of the light in flight. He lowers his wings. The superior person does not eat for three days on his wanderings.",
                    "Line 2: Darkening of the light injures him in the left thigh. He gives aid with the strength of a horse. Good fortune.",
                    "Line 3: Darkening of the light during the hunt in the south. Their great leader is captured. One must not expect perseverance too soon.",
                    "Line 4: He penetrates the left side of the belly. One gets at the very heart of the darkening of the light, and leaves gate and courtyard.",
                    "Line 5: Darkening of the light as with Prince Chi. Perseverance furthers.",
                    "Line 6: Not light but darkness. First he climbed up to heaven, then he plunged into the depths of the earth."
                )
            ),
            Hexagram(
                number = 37,
                chinese = "家人",
                pinyin = "Jiā Rén",
                englishName = "The Family (The Clan)",
                upperTrigram = Trigram.XUN,
                lowerTrigram = Trigram.LI,
                lines = listOf(true, false, true, false, true, true),
                judgment = "The Family. The perseverance of the woman furthers. Order and warmth in the household lay the bedrock for peace in the world.",
                theImage = "Wind comes forth from fire: The image of the Family. Thus the superior person has substance in his words and duration in his way of life.",
                commentary = "Mutual affection, appropriate roles, and trustworthy communication at home. When the inner sphere is harmonious, all external affairs prosper.",
                lineTexts = listOf(
                    "Line 1: Firm seclusion within the family. Remorse disappears.",
                    "Line 2: She should not follow her whims. She must attend within to the food. Perseverance brings good fortune.",
                    "Line 3: When tempers flare in the family, too great severity brings remorse; yet it brings good fortune. When women and children waste, it leads to humiliation.",
                    "Line 4: She is the treasure of the house. Great good fortune.",
                    "Line 5: As a king he approaches his family. Fear not. Good fortune.",
                    "Line 6: His work commands respect. In the end, good fortune comes."
                )
            ),
            Hexagram(
                number = 38,
                chinese = "睽",
                pinyin = "Kuí",
                englishName = "Opposition",
                upperTrigram = Trigram.LI,
                lowerTrigram = Trigram.DUI,
                lines = listOf(true, true, false, true, false, true),
                judgment = "Opposition. In small matters, good fortune. Understand differences and seek common ground where possible.",
                theImage = "Above, fire; below, the lake: The image of Opposition. Thus amid all fellowship the superior person retains his individuality.",
                commentary = "Contrast and divergence of outlook. Do not force artificial consensus; celebrate diverse perspectives and achieve small successes patiently.",
                lineTexts = listOf(
                    "Line 1: Remorse disappears. If you lose your horse, do not run after it; it will come back of its own accord.",
                    "Line 2: One meets his lord in a narrow street. No blame.",
                    "Line 3: One sees the wagon dragged back, the oxen halted, a man's hair and nose cut off. Not a good beginning, but a good end.",
                    "Line 4: Isolated through opposition, one meets a companion with whom one can associate in mutual trust. No blame.",
                    "Line 5: Remorse disappears. The companion bites his way through the wrappings. Going to him brings no mistake.",
                    "Line 6: Isolated through opposition, one sees one's companion as a pig covered with mud, as a wagon full of devils. Draw bow, then lay it aside. Union in the end."
                )
            ),
            Hexagram(
                number = 39,
                chinese = "蹇",
                pinyin = "Jiǎn",
                englishName = "Obstruction",
                upperTrigram = Trigram.KAN,
                lowerTrigram = Trigram.GEN,
                lines = listOf(false, false, true, false, true, false),
                judgment = "Obstruction. The southwest furthers; the northeast does not further. It furthers one to see the great man. Perseverance brings good fortune.",
                theImage = "Water on the mountain: The image of Obstruction. Thus the superior person turns his attention to himself and molds his character.",
                commentary = "Steep crags ahead and perilous rapids below. When blocked by impassable circumstances, pause, look inward, and seek wise counsel.",
                lineTexts = listOf(
                    "Line 1: Going leads to obstructions; coming brings praise.",
                    "Line 2: The king's servant meets obstruction on obstruction, but not through his own fault.",
                    "Line 3: Going leads to obstructions; hence he comes back.",
                    "Line 4: Going leads to obstructions; coming leads to union.",
                    "Line 5: In the midst of the greatest obstructions, friends come.",
                    "Line 6: Going leads to obstructions; coming leads to great good fortune. It furthers one to see the great man."
                )
            ),
            Hexagram(
                number = 40,
                chinese = "解",
                pinyin = "Xiè",
                englishName = "Deliverance",
                upperTrigram = Trigram.ZHEN,
                lowerTrigram = Trigram.KAN,
                lines = listOf(false, true, false, true, false, false),
                judgment = "Deliverance. The southwest furthers. If there is no longer anything where one has to go, return brings good fortune. If there is still something, haste brings good fortune.",
                theImage = "Thunder and rain set in: The image of Deliverance. Thus the superior person pardons mistakes and forgives misdeeds.",
                commentary = "Tension breaks and spring rain releases long-held frozen knots. Act swiftly to resolve lingering issues, forgive debts, and return to simplicity.",
                lineTexts = listOf(
                    "Line 1: Without blame.",
                    "Line 2: One kills three foxes in the field and receives a yellow arrow. Perseverance brings good fortune.",
                    "Line 3: If a man carries a burden on his back and nonetheless rides in a carriage, he thereby encourages robbers to draw near. Humiliation.",
                    "Line 4: Deliver yourself from your great toe. Then the companion comes, and in him you can have trust.",
                    "Line 5: If only the superior person can deliver himself, it brings good fortune. Thus he proves to inferior men that he is in earnest.",
                    "Line 6: The prince shoots at a hawk on a high wall. He hits it. Everything furthers."
                )
            ),
            Hexagram(
                number = 41,
                chinese = "損",
                pinyin = "Sǔn",
                englishName = "Decrease",
                upperTrigram = Trigram.GEN,
                lowerTrigram = Trigram.DUI,
                lines = listOf(true, true, false, false, false, true),
                judgment = "Decrease combined with sincerity brings supreme good fortune without blame. One may be persevering. Even with two small bowls, one may offer sacrifice.",
                theImage = "At the foot of the mountain, the lake: The image of Decrease. Thus the superior person restrains his anger and represses his desires.",
                commentary = "Pruning the superfluous to nourish the essential. Simplicity, restraint of appetites, and genuine heartfelt devotion outweigh lavish extravagance.",
                lineTexts = listOf(
                    "Line 1: Going quickly when one's work is done is not a mistake. But one must consider how much one may decrease the other.",
                    "Line 2: Perseverance furthers. To undertake something brings misfortune. Without decreasing oneself, one is able to bring increase to others.",
                    "Line 3: When three people journey together, their number increases by one. When one man journeys alone, he finds a companion.",
                    "Line 4: If a man decreases his faults, it makes the other hasten to come and rejoice. No blame.",
                    "Line 5: Someone increases him. Ten pairs of tortoises cannot oppose it. Supreme good fortune.",
                    "Line 6: If one is increased without depriving others, there is no blame. Perseverance brings good fortune."
                )
            ),
            Hexagram(
                number = 42,
                chinese = "益",
                pinyin = "Yì",
                englishName = "Increase",
                upperTrigram = Trigram.XUN,
                lowerTrigram = Trigram.ZHEN,
                lines = listOf(true, false, false, false, true, true),
                judgment = "Increase. It furthers one to undertake something. It furthers one to cross the great water. Generosity circulates blessings.",
                theImage = "Wind and thunder: The image of Increase. Thus the superior person: if he sees good, he imitates it; if he has faults, he rids himself of them.",
                commentary = "Generous expansion, fruitful opportunities, and social enrichment. Pour resources from above into those below to create shared prosperity.",
                lineTexts = listOf(
                    "Line 1: It furthers one to accomplish great deeds. Supreme good fortune. No blame.",
                    "Line 2: Someone does increase him; ten pairs of tortoises cannot oppose it. Constant perseverance brings good fortune.",
                    "Line 3: One is enriched through unfortunate events. No blame, if you are sincere and walk in the middle, reporting with seal.",
                    "Line 4: If you walk in the middle and report to the prince, he will follow. It furthers one to be used in moving the capital.",
                    "Line 5: If in truth you have a kind heart, ask not. Supreme good fortune. Truly, your virtue will be recognized.",
                    "Line 6: He brings increase to no one. Indeed, someone even strikes him. He does not keep his heart constantly steady. Misfortune."
                )
            ),
            Hexagram(
                number = 43,
                chinese = "夬",
                pinyin = "Guài",
                englishName = "Breakthrough (Resoluteness)",
                upperTrigram = Trigram.DUI,
                lowerTrigram = Trigram.QIAN,
                lines = listOf(true, true, true, true, true, false),
                judgment = "Breakthrough. One must resolutely make the matter known at the court of the king. It must be announced truthfully. Danger. It is not favorable to resort to arms.",
                theImage = "The lake has risen up to heaven: The image of Breakthrough. Thus the superior person dispenses riches downward and refrains from resting on his virtue.",
                commentary = "Decisive elimination of negative habits or corruption. Act openly with moral authority rather than clandestine violence.",
                lineTexts = listOf(
                    "Line 1: Mighty in the forward-striding toes. When one goes and is not equal to the task, one makes a mistake.",
                    "Line 2: A cry of alarm. Arms in the evening and at night. Fear nothing.",
                    "Line 3: To be powerful in the cheekbones brings misfortune. The superior person is firmly resolved. He walks alone in the rain.",
                    "Line 4: There is no skin on his thighs, and walking comes hard. If a man were to let himself be led like a sheep, remorse would disappear.",
                    "Line 5: In dealing with weeds, firm resolution is necessary. Walking in the middle remains free of blame.",
                    "Line 6: No cry. In the end misfortune comes. One cannot banish darkness while ignoring one's own shadow."
                )
            ),
            Hexagram(
                number = 44,
                chinese = "姤",
                pinyin = "Gòu",
                englishName = "Coming to Meet",
                upperTrigram = Trigram.QIAN,
                lowerTrigram = Trigram.XUN,
                lines = listOf(false, true, true, true, true, true),
                judgment = "Coming to Meet. The maiden is powerful. One should not marry such a maiden. Guard against subtle seduction and insidious drift.",
                theImage = "Under heaven, wind: The image of Coming to Meet. Thus does the prince act when disseminating his commands and proclaiming them to the four quarters.",
                commentary = "A sudden meeting with a subtle, tempting influence. Do not underestimate small compromises; recognize underlying dynamics early.",
                lineTexts = listOf(
                    "Line 1: It must be checked with a brake of bronze. Perseverance brings good fortune. If one lets it take its course, one experiences misfortune.",
                    "Line 2: There is a fish in the tank. No blame. Does not further guests.",
                    "Line 3: There is no skin on his thighs, and walking comes hard. If one is mindful of danger, no great mistake is made.",
                    "Line 4: No fish in the tank. This leads to misfortune.",
                    "Line 5: A melon covered with willow leaves. Hidden lines. Then it falls to one's lot as from heaven.",
                    "Line 6: He comes to meet with his horns. Humiliation. No blame."
                )
            ),
            Hexagram(
                number = 45,
                chinese = "萃",
                pinyin = "Cuì",
                englishName = "Gathering Together (Massing)",
                upperTrigram = Trigram.DUI,
                lowerTrigram = Trigram.KUN,
                lines = listOf(false, false, false, true, true, false),
                judgment = "Gathering Together. Success. The king approaches his temple. It furthers one to see the great man. This brings success. Perseverance furthers.",
                theImage = "Over the earth, the lake: The image of Gathering Together. Thus the superior person renews his weapons in order to meet the unforeseen.",
                commentary = "People congregating around a common center or spiritual temple. Unify the assembly through shared reverence and wise precautions against discord.",
                lineTexts = listOf(
                    "Line 1: If you are sincere, but not to the end, there will be now confusion, now gathering. If you cry out, then after one grasp of the hand you can laugh again.",
                    "Line 2: Letting oneself be drawn brings good fortune and remains blameless. If one is sincere, it furthers one to bring even a small offering.",
                    "Line 3: Gathering together amid sighs. Nothing that would further. Going is without blame; slight humiliation.",
                    "Line 4: Great good fortune. No blame.",
                    "Line 5: If in gathering together one has position, this brings no blame. If there are some who are not yet sincerely in the work, sublime perseverance is needed.",
                    "Line 6: Lamenting and sighing, floods of tears. No blame."
                )
            ),
            Hexagram(
                number = 46,
                chinese = "升",
                pinyin = "Shēng",
                englishName = "Pushing Upward",
                upperTrigram = Trigram.KUN,
                lowerTrigram = Trigram.XUN,
                lines = listOf(false, true, true, false, false, false),
                judgment = "Pushing Upward has supreme success. One must see the great man. Fear not. Departure toward the south brings good fortune.",
                theImage = "Within the earth, wood grows: The image of Pushing Upward. Thus the superior person of devoted character heaps up small things to achieve height and greatness.",
                commentary = "Steady, organic ascent like a tree growing silently from fertile soil. Step by step, cumulative devotion achieves great prominence.",
                lineTexts = listOf(
                    "Line 1: Pushing upward that meets with confidence brings great good fortune.",
                    "Line 2: If one is sincere, it furthers one to bring even a small offering. No blame.",
                    "Line 3: One pushes upward into an empty city.",
                    "Line 4: The king offers him sacrifice on Mount Chi. Good fortune. No blame.",
                    "Line 5: Perseverance brings good fortune. One pushes upward by steps.",
                    "Line 6: Pushing upward in the dark. It furthers one to remain unremittingly persevering."
                )
            ),
            Hexagram(
                number = 47,
                chinese = "困",
                pinyin = "Kùn",
                englishName = "Oppression (Exhaustion)",
                upperTrigram = Trigram.DUI,
                lowerTrigram = Trigram.KAN,
                lines = listOf(false, true, false, true, true, false),
                judgment = "Oppression. Success. Perseverance. The great man brings about good fortune. No blame. When one has something to say, it is not believed.",
                theImage = "There is no water in the lake: The image of Exhaustion. Thus the superior person stakes his life on following his will.",
                commentary = "Water has leaked away beneath the lake bed; extreme constraint and trial. Do not waste energy complaining; endure with serene nobility.",
                lineTexts = listOf(
                    "Line 1: One sits oppressed under a bare tree and strays into a gloomy valley. For three years one sees nothing.",
                    "Line 2: One is oppressed while at meat and drink. The man with the scarlet knee bands is just coming. It furthers one to offer sacrifice.",
                    "Line 3: A man permits himself to be oppressed by stone, and leans on thistles. He enters his house and does not see his wife. Misfortune.",
                    "Line 4: He comes very quietly, oppressed in a golden carriage. Humiliation, but the end is reached.",
                    "Line 5: His nose and feet are cut off. Oppression at the hands of the man with the purple knee bands. Joy comes softly.",
                    "Line 6: He is oppressed by creepers. He moves uncertainly and says, 'Movement brings remorse.' If one feels remorse and sets forth, good fortune comes."
                )
            ),
            Hexagram(
                number = 48,
                chinese = "井",
                pinyin = "Jǐng",
                englishName = "The Well",
                upperTrigram = Trigram.KAN,
                lowerTrigram = Trigram.XUN,
                lines = listOf(false, true, true, false, true, false),
                judgment = "The Well. The town may be changed, but the well cannot be changed. It neither decreases nor increases. They come and go and draw from the well.",
                theImage = "Water over wood: The image of the Well. Thus the superior person encourages the people at their work and exhorts them to help one another.",
                commentary = "The inexhaustible fountain of perennial wisdom and spiritual nourishment. Tend to the rope and the vessel so that all may drink freely.",
                lineTexts = listOf(
                    "Line 1: One does not drink the mud of the well. No animals come to an old well.",
                    "Line 2: At the wellhole one shoots fishes. The jug is broken and leaks.",
                    "Line 3: The well is cleaned, but no one drinks from it. This is my heart's sorrow, for one might draw from it. If the king were clear-minded, good fortune would be enjoyed.",
                    "Line 4: The well is being lined. No blame.",
                    "Line 5: In the well there is a clear, cold spring from which one can drink.",
                    "Line 6: One draws from the well without hindrance. It is dependable. Supreme good fortune."
                )
            ),
            Hexagram(
                number = 49,
                chinese = "革",
                pinyin = "Gé",
                englishName = "Revolution (Molting)",
                upperTrigram = Trigram.DUI,
                lowerTrigram = Trigram.LI,
                lines = listOf(true, false, true, true, true, false),
                judgment = "Revolution. On your own day you are believed. Supreme success, furthering through perseverance. Remorse disappears. Change with the right season.",
                theImage = "Fire in the lake: The image of Revolution. Thus the superior person sets the calendar in order and makes the seasons clear.",
                commentary = "Transformative shedding of the outdated skin. True revolution must be timed in complete resonance with cosmic necessity and public trust.",
                lineTexts = listOf(
                    "Line 1: Wrapped in the hide of a yellow cow.",
                    "Line 2: When one's own day comes, one may make radical change. Starting brings good fortune. No blame.",
                    "Line 3: Starting brings misfortune. Perseverance brings danger. When talk of change has gone the rounds three times, one may commit oneself.",
                    "Line 4: Remorse disappears. Men believe him. Changing the form of state brings good fortune.",
                    "Line 5: The great man changes like a tiger. Even before he questions the oracle, he is believed.",
                    "Line 6: The superior person changes like a leopard. The inferior man molts in the face. Starting brings misfortune. To remain persevering brings good fortune."
                )
            ),
            Hexagram(
                number = 50,
                chinese = "鼎",
                pinyin = "Dǐng",
                englishName = "The Cauldron",
                upperTrigram = Trigram.LI,
                lowerTrigram = Trigram.XUN,
                lines = listOf(false, true, true, true, false, true),
                judgment = "The Cauldron. Supreme good fortune. Success. Sacred vessel transforms raw sustenance into spiritual nourishment.",
                theImage = "Fire over wood: The image of the Cauldron. Thus the superior person consolidates his fate by making his position correct.",
                commentary = "Spiritual alchemical refinement, culture, and nourishment of sages. Cook your thoughts with patience until pure wisdom emerges.",
                lineTexts = listOf(
                    "Line 1: A ting with overturned legs. Furthers removal of stagnant stuff. One takes a concubine for the sake of her son. No blame.",
                    "Line 2: There is food in the ting. My comrades are envious, but they cannot harm me. Good fortune.",
                    "Line 3: The handle of the ting is altered. One is impeded in his way of life. The fat of the pheasant is not eaten. Once rain falls, remorse spent, good fortune.",
                    "Line 4: The legs of the ting are broken. The prince's meal is spilled and his person soiled. Misfortune.",
                    "Line 5: The ting has yellow handles and golden carrying rings. Perseverance furthers.",
                    "Line 6: The ting has rings of jade. Great good fortune. Nothing that would not act to further."
                )
            ),
            Hexagram(
                number = 51,
                chinese = "震",
                pinyin = "Zhèn",
                englishName = "The Arousing (Shock / Thunder)",
                upperTrigram = Trigram.ZHEN,
                lowerTrigram = Trigram.ZHEN,
                lines = listOf(true, false, false, true, false, false),
                judgment = "Shock brings success. Shock comes—oh, oh! Laughing words—ha, ha! The shock terrifies for a hundred miles, and he does not let fall the sacrificial spoon and chalice.",
                theImage = "Thunder repeated: The image of Shock. Thus in fear and trembling the superior person sets his life in order and examines himself.",
                commentary = "A sudden awakening or startling thunderclap. It shatters complacency. Those who maintain inner composure emerge untouched and smiling.",
                lineTexts = listOf(
                    "Line 1: Shock comes—oh, oh! Then follow laughing words—ha, ha! Good fortune.",
                    "Line 2: Shock comes bringing danger. A hundred thousand times you lose your treasures and must climb the nine hills. Do not run after them; after seven days you get them back.",
                    "Line 3: Shock comes and makes one distraught. If through shock one is impelled to action, one remains free of misfortune.",
                    "Line 4: Shock is mired in mud.",
                    "Line 5: Shock goes to and fro. Danger. However, nothing at all is lost. Yet there are things to be done.",
                    "Line 6: Shock brings ruin and terrified gazing around. Going ahead brings misfortune. If it has not yet touched one's own body, no blame."
                )
            ),
            Hexagram(
                number = 52,
                chinese = "艮",
                pinyin = "Gèn",
                englishName = "Keeping Still (Mountain)",
                upperTrigram = Trigram.GEN,
                lowerTrigram = Trigram.GEN,
                lines = listOf(false, false, true, false, false, true),
                judgment = "Keeping Still. Keeping his back still so that he no longer feels his body. He goes into his courtyard and does not see his people. No blame.",
                theImage = "Mountains standing close together: The image of Keeping Still. Thus the superior person does not permit his thoughts to go beyond his situation.",
                commentary = "Meditative stillness, inner tranquility, and mindfulness. Silence the restless chatter of desires and abide peacefully in the present moment.",
                lineTexts = listOf(
                    "Line 1: Keeping his toes still. No blame. Continued perseverance furthers.",
                    "Line 2: Keeping his calves still. He cannot rescue him whom he follows. His heart is not glad.",
                    "Line 3: Keeping his hips still. Making his sacrum stiff. Dangerous. The heart suffocates.",
                    "Line 4: Keeping his trunk still. No blame.",
                    "Line 5: Keeping his jaws still. The words have order. Remorse disappears.",
                    "Line 6: Noblehearted keeping still. Good fortune."
                )
            ),
            Hexagram(
                number = 53,
                chinese = "漸",
                pinyin = "Jiàn",
                englishName = "Development (Gradual Progress)",
                upperTrigram = Trigram.XUN,
                lowerTrigram = Trigram.GEN,
                lines = listOf(false, false, true, false, true, true),
                judgment = "Development. The maiden is given in marriage. Good fortune. Perseverance furthers. Natural organic pacing ensures enduring foundations.",
                theImage = "On the mountain, a tree: The image of Development. Thus the superior person abides in dignity and virtue in order to improve manners.",
                commentary = "Like wild geese flying in elegant V-formation from shore to summit, progress must unfold step by step without frantic haste.",
                lineTexts = listOf(
                    "Line 1: The wild goose gradually draws near the shore. The young son is in danger. There is gossip. No blame.",
                    "Line 2: The wild goose gradually draws near the cliff. Eating and drinking in peace and concord. Good fortune.",
                    "Line 3: The wild goose gradually draws near the plateau. The man goes forth and does not return. The woman carries a child who is not brought forth. Misfortune. It furthers one to fight off evil.",
                    "Line 4: The wild goose gradually draws near the tree. Perhaps it will find a flat branch. No blame.",
                    "Line 5: The wild goose gradually draws near the summit. For three years the woman has no child. In the end nothing can hinder her. Good fortune.",
                    "Line 6: The wild goose gradually draws near the clouds heights. Its feathers can be used for the sacred dance. Good fortune."
                )
            ),
            Hexagram(
                number = 54,
                chinese = "歸妹",
                pinyin = "Guī Mèi",
                englishName = "The Marrying Maiden",
                upperTrigram = Trigram.ZHEN,
                lowerTrigram = Trigram.DUI,
                lines = listOf(true, true, false, true, false, false),
                judgment = "The Marrying Maiden. Undertakings bring misfortune. Nothing that would further. Passion without proper custom brings regret.",
                theImage = "Thunder over the lake: The image of the Marrying Maiden. Thus the superior person understands the transitory in the light of the eternity of the end.",
                commentary = "Impulsive desires leading into a secondary or compromising position. Beware entanglements driven by infatuation rather than clear wisdom.",
                lineTexts = listOf(
                    "Line 1: The marrying maiden as a concubine. A lame man who can tread. Undertakings bring good fortune.",
                    "Line 2: A one-eyed man who can see. The perseverance of a solitary person furthers.",
                    "Line 3: The marrying maiden as a slave. She gives herself in marriage as a concubine.",
                    "Line 4: The marrying maiden draws out the allotted time. A late marriage comes in due course.",
                    "Line 5: The sovereign gave his daughter in marriage. The embroidered garments of the princess were not as gorgeous as those of the servingmaid. Good fortune.",
                    "Line 6: The woman holds the basket, but there are no fruits in it. The man stabs the sheep, but no blood flows. Nothing that acts to further."
                )
            ),
            Hexagram(
                number = 55,
                chinese = "豐",
                pinyin = "Fēng",
                englishName = "Abundance (Fullness)",
                upperTrigram = Trigram.ZHEN,
                lowerTrigram = Trigram.LI,
                lines = listOf(true, false, true, true, false, false),
                judgment = "Abundance has success. The king attains abundance. Be not sad; be like the sun at midday. Shed light and dispense justice generously.",
                theImage = "Both thunder and lightning come: The image of Abundance. Thus the superior person decides lawsuits and carries out punishments.",
                commentary = "The zenith of power and clarity. Enjoy the zenith without fear, but remember that the sun at noon must eventually begin its descent.",
                lineTexts = listOf(
                    "Line 1: When a man meets his destined ruler, they can be together ten days, and it is not a mistake. Going brings advancement.",
                    "Line 2: The curtain is of such fullness that the polar star can be seen at noon. Through going one meets suspicion and hate. Awaken confidence by sincerity.",
                    "Line 3: The underbrush is of such abundance that the small stars can be seen at noon. He breaks his right arm. No blame.",
                    "Line 4: The curtain is of such fullness that the polar star can be seen at noon. He meets his destined ruler. Good fortune.",
                    "Line 5: Lines of brilliance arrive; blessing and fame draw near. Good fortune.",
                    "Line 6: His house is in a state of abundance. He screens off his family. He peers through the gate and no longer perceives anyone. For three years he sees nothing. Misfortune."
                )
            ),
            Hexagram(
                number = 56,
                chinese = "旅",
                pinyin = "Lǚ",
                englishName = "The Wanderer",
                upperTrigram = Trigram.LI,
                lowerTrigram = Trigram.GEN,
                lines = listOf(false, false, true, true, false, true),
                judgment = "The Wanderer. Success through smallness. Perseverance brings good fortune to the wanderer. Humility and discretion protect the stranger.",
                theImage = "Fire on the mountain: The image of the Wanderer. Thus the superior person is clear-minded and cautious in imposing penalties, and protracts no lawsuits.",
                commentary = "Journeying through unfamiliar territory where you have no roots. Walk lightly, observe local customs, avoid arrogance, and maintain your integrity.",
                lineTexts = listOf(
                    "Line 1: If the wanderer busies himself with trivial things, he draws down misfortune upon himself.",
                    "Line 2: The wanderer comes to an inn. He has his property with him. He wins the steadfastness of a young servant.",
                    "Line 3: The wanderer's inn burns down. He loses the steadfastness of his young servant. Danger.",
                    "Line 4: The wanderer rests in a shelter. He obtains his property and an ax. My heart is not glad.",
                    "Line 5: He shoots a pheasant. It drops with the first arrow. In the end this brings both praise and office.",
                    "Line 6: The bird's nest burns up. The wanderer laughs at first, then must needs lament and weep. Through carelessness he loses his cow. Misfortune."
                )
            ),
            Hexagram(
                number = 57,
                chinese = "巽",
                pinyin = "Xùn",
                englishName = "The Gentle (Wind / Penetrating)",
                upperTrigram = Trigram.XUN,
                lowerTrigram = Trigram.XUN,
                lines = listOf(false, true, true, false, true, true),
                judgment = "The Gentle. Success through what is small. It furthers one to have somewhere to go. It furthers one to see the great man.",
                theImage = "Winds following one upon the other: The image of the Gently Penetrating. Thus the superior person spreads his commands abroad and carries out his undertakings.",
                commentary = "Gentle, invisible, persistent influence like wind shaping the landscape. Continuous soft persuasion reaches hearts that force can never touch.",
                lineTexts = listOf(
                    "Line 1: In advancing and in retreating, the perseverance of a warrior furthers.",
                    "Line 2: Penetration under the bed. Priests and magicians are used in great numbers. Good fortune. No blame.",
                    "Line 3: Repeated penetration. Humiliation.",
                    "Line 4: Remorse disappears. During the hunt three kinds of game are caught.",
                    "Line 5: Perseverance brings good fortune. Remorse disappears. Nothing that does not further. No beginning, but an end. Before the change, three days; after, three days.",
                    "Line 6: Penetration under the bed. He loses his property and his ax. Perseverance brings misfortune."
                )
            ),
            Hexagram(
                number = 58,
                chinese = "兌",
                pinyin = "Duì",
                englishName = "The Joyous (Lake)",
                upperTrigram = Trigram.DUI,
                lowerTrigram = Trigram.DUI,
                lines = listOf(true, true, false, true, true, false),
                judgment = "The Joyous. Success. Perseverance is favorable. True joy stems from an unshakeable inner core shared with companions.",
                theImage = "Lakes resting one on the other: The image of the Joyous. Thus the superior person joins with his friends for discussion and practice.",
                commentary = "Serene happiness, open-hearted dialogue, and mutual inspiration. Keep joy grounded in moral firmness rather than superficial flattery.",
                lineTexts = listOf(
                    "Line 1: Contented joyousness. Good fortune.",
                    "Line 2: Sincere joyousness. Good fortune. Remorse disappears.",
                    "Line 3: Coming joyousness. Misfortune. Seeking pleasure from outside.",
                    "Line 4: Joyousness that is weighed is not at peace. After ridding himself of mistakes a man has joy.",
                    "Line 5: Sincerity toward disintegrating influences is dangerous.",
                    "Line 6: Seductive joyousness leads one astray."
                )
            ),
            Hexagram(
                number = 59,
                chinese = "渙",
                pinyin = "Huàn",
                englishName = "Dispersion (Dissolution)",
                upperTrigram = Trigram.XUN,
                lowerTrigram = Trigram.KAN,
                lines = listOf(false, true, false, false, true, true),
                judgment = "Dispersion. Success. The king approaches his temple. It furthers one to cross the great water. Perseverance furthers.",
                theImage = "The wind drives over the water: The image of Dispersion. Thus the kings of old sacrificed to the Lord and built temples.",
                commentary = "Melting cold barriers of egotism and isolation. Dissolve hardened separation by uniting around an inspiring shared ideal.",
                lineTexts = listOf(
                    "Line 1: He brings help with the strength of a horse. Good fortune.",
                    "Line 2: At the dissolution he hurries to that which supports him. Remorse disappears.",
                    "Line 3: He dissolves his self. No remorse.",
                    "Line 4: He dissolves his bond with his group. Supreme good fortune. Dispersion leads in turn to accumulation.",
                    "Line 5: His loud cries are as dissolving as sweat. Dissolution! A king abides without blame.",
                    "Line 6: He gets rid of his blood. Departing, keeping at a distance, going out, is without blame."
                )
            ),
            Hexagram(
                number = 60,
                chinese = "節",
                pinyin = "Jié",
                englishName = "Limitation",
                upperTrigram = Trigram.KAN,
                lowerTrigram = Trigram.DUI,
                lines = listOf(true, true, false, false, true, false),
                judgment = "Limitation. Success. Galling limitation must not be persevered in. Boundaries give shape to beauty and protect resources.",
                theImage = "Water over lake: The image of Limitation. Thus the superior person creates number and measure, and examines the nature of virtue and correct conduct.",
                commentary = "Like bamboo joints that give strength to the stalk, healthy boundaries provide structure, save energy, and allow music to resonate.",
                lineTexts = listOf(
                    "Line 1: Not going out of the door and courtyard is without blame.",
                    "Line 2: Not going out of the gate and courtyard brings misfortune.",
                    "Line 3: He who knows no limitation will have cause to lament. No blame.",
                    "Line 4: Contented limitation. Success.",
                    "Line 5: Sweet limitation brings good fortune. Going brings esteem.",
                    "Line 6: Galling limitation. Perseverance brings misfortune. Remorse disappears."
                )
            ),
            Hexagram(
                number = 61,
                chinese = "中孚",
                pinyin = "Zhōng Fú",
                englishName = "Inner Truth",
                upperTrigram = Trigram.XUN,
                lowerTrigram = Trigram.DUI,
                lines = listOf(true, true, false, false, true, true),
                judgment = "Inner Truth. Pigs and fishes. Good fortune. It furthers one to cross the great water. Perseverance furthers.",
                theImage = "Wind over lake: The image of Inner Truth. Thus the superior person discusses criminal cases in order to execute penalties with compassion.",
                commentary = "Profound heart-sincerity that touches even the most difficult souls. When you are empty of prejudice and full of empathy, truth resonates effortlessly.",
                lineTexts = listOf(
                    "Line 1: Being prepared brings good fortune. If there are secret designs, it is disquieting.",
                    "Line 2: A crane calling in the shade. Its young answers it. I have a good goblet; I will share it with you.",
                    "Line 3: He finds a comrade. Now he beats the drum, now he stops. Now he sobs, now he sings.",
                    "Line 4: The moon is nearly full. The team horse goes astray. No blame.",
                    "Line 5: He possesses truth, which binds together. No blame.",
                    "Line 6: Cockcrow mounting to heaven. Perseverance brings misfortune."
                )
            ),
            Hexagram(
                number = 62,
                chinese = "小過",
                pinyin = "Xiǎo Guò",
                englishName = "Preponderance of the Small",
                upperTrigram = Trigram.ZHEN,
                lowerTrigram = Trigram.GEN,
                lines = listOf(false, false, true, true, false, false),
                judgment = "Preponderance of the Small. Success. Perseverance furthers. Small things may be done; great things should not be done. The flying bird brings the message: It is not well to strive upward, it is well to remain below.",
                theImage = "Thunder on the mountain: The image of Preponderance of the Small. Thus in his conduct the superior person gives preponderance to reverence.",
                commentary = "A time for meticulous attention to fine details, modesty, and careful adherence to protocol. Stay close to the ground like a nesting bird.",
                lineTexts = listOf(
                    "Line 1: The bird meets with misfortune through flying.",
                    "Line 2: She passes by her ancestor and meets her ancestress. He does not reach his prince and meets the minister. No blame.",
                    "Line 3: If one is not on guard, someone may come up from behind and strike him. Misfortune.",
                    "Line 4: No blame. He meets him without passing by. Going brings danger. One must be on guard. Do not act. Be constantly persevering.",
                    "Line 5: Dense clouds, no rain from our western territory. The prince shoots and hits him who is in the cave.",
                    "Line 6: He passes him by and does not meet him. The flying bird leaves him. Misfortune. This means bad luck and injury."
                )
            ),
            Hexagram(
                number = 63,
                chinese = "既濟",
                pinyin = "Jì Jì",
                englishName = "After Completion",
                upperTrigram = Trigram.KAN,
                lowerTrigram = Trigram.LI,
                lines = listOf(true, false, true, false, true, false),
                judgment = "After Completion. Success in small matters. Perseverance furthers. At the beginning good fortune, at the end disorder. Maintain vigilant care.",
                theImage = "Water over fire: The image of the condition in After Completion. Thus the superior person takes thought of misfortune and arms himself against it in advance.",
                commentary = "All pieces are in their perfect alternating places. But perfection is the beginning of decay. Stay alert, attend to minor maintenance, and do not relax vigilance.",
                lineTexts = listOf(
                    "Line 1: He brakes his wheels. He gets his tail in the water. No blame.",
                    "Line 2: The woman loses the curtain of her carriage. Do not run after it; on the seventh day you will get it back.",
                    "Line 3: The Illustrious Ancestor disciplines the Devil's Country. After three years he conquers it. Inferior people must not be employed.",
                    "Line 4: The finest clothes turn to rags. Be careful all day long.",
                    "Line 5: The neighbor in the east who slaughters an ox does not attain as much real happiness as the neighbor in the west with his small sacrifice.",
                    "Line 6: He gets his head in the water. Danger."
                )
            ),
            Hexagram(
                number = 64,
                chinese = "未濟",
                pinyin = "Wèi Jì",
                englishName = "Before Completion",
                upperTrigram = Trigram.LI,
                lowerTrigram = Trigram.KAN,
                lines = listOf(false, true, false, true, false, true),
                judgment = "Before Completion. Success. But if the little fox, after nearly completing the crossing, gets his tail in the water, there is nothing that would further.",
                theImage = "Fire over water: The image of the condition before transition. Thus the superior person is careful and differentiates things, that each may find its place.",
                commentary = "The eternal cycle begins anew. The transition is at hand, full of hope and promise. Cross the final stretch with acute awareness and fresh resolve.",
                lineTexts = listOf(
                    "Line 1: He gets his tail in the water. Humiliating.",
                    "Line 2: He brakes his wheels. Perseverance brings good fortune.",
                    "Line 3: Before completion, attack brings misfortune. It furthers one to cross the great water.",
                    "Line 4: Perseverance brings good fortune. Remorse disappears. Shock, thus to discipline the Devil's Country. For three years, great rewards in the realm.",
                    "Line 5: Perseverance brings good fortune. No remorse. The light of the superior person is true. Good fortune.",
                    "Line 6: There is drinking of wine in genuine confidence. No blame. But if one wets his head, he loses it, in truth."
                )
            )
        )
    }

    private val mapByNumber by lazy {
        allHexagrams.associateBy { it.number }
    }

    private val mapByTrigrams by lazy {
        allHexagrams.associateBy { it.upperTrigram to it.lowerTrigram }
    }

    private val mapByLines by lazy {
        allHexagrams.associateBy { it.lines }
    }

    /**
     * Retrieves a hexagram by its canonical King Wen number (1–64).
     * Returns null if the number is invalid, avoiding silent fallback to Hexagram 1.
     */
    fun getByNumber(number: Int): Hexagram? {
        return mapByNumber[number]
    }

    /**
     * Looks up a hexagram matching the exact 6-line Yin/Yang configuration.
     * Returns null if the list does not contain exactly 6 lines or has no match,
     * avoiding silent fallback to Hexagram 1.
     */
    fun findByLines(lines: List<Boolean>): Hexagram? {
        if (lines.size != 6) return null
        return mapByLines[lines]
    }

    /**
     * Looks up a hexagram by its upper and lower trigrams.
     * Returns null if no match is found, avoiding silent fallback to Hexagram 1.
     */
    fun findByTrigrams(upper: Trigram, lower: Trigram): Hexagram? {
        return mapByTrigrams[upper to lower]
    }

    fun getByNumberOrNull(number: Int): Hexagram? = getByNumber(number)
    fun findByLinesOrNull(lines: List<Boolean>): Hexagram? = findByLines(lines)
    fun findByTrigramsOrNull(upper: Trigram, lower: Trigram): Hexagram? = findByTrigrams(upper, lower)

    /**
     * Retrieves a hexagram by King Wen number or throws NoSuchElementException if not found.
     */
    fun getByNumberOrThrow(number: Int): Hexagram {
        return mapByNumber[number]
            ?: throw NoSuchElementException("Hexagram #$number does not exist in the 64-hexagram library.")
    }

    fun search(query: String): List<Hexagram> {
        val trimmed = query.trim()
        if (trimmed.isEmpty()) return allHexagrams

        val exactNum = trimmed.toIntOrNull()?.let { mapByNumber[it] }
        val prefixNumMatches = if (trimmed.all { it.isDigit() }) {
            allHexagrams.filter {
                it.number.toString().startsWith(trimmed) && it != exactNum
            }.sortedBy { it.number }
        } else {
            emptyList()
        }

        val q = trimmed.lowercase()
        val textMatches = allHexagrams.filter { hex ->
            hex != exactNum && !prefixNumMatches.contains(hex) && (
                hex.englishName.lowercase().contains(q) ||
                hex.pinyin.lowercase().contains(q) ||
                hex.chinese.contains(q) ||
                hex.upperTrigram.englishName.lowercase().contains(q) ||
                hex.lowerTrigram.englishName.lowercase().contains(q) ||
                hex.upperTrigram.chinese.contains(q) ||
                hex.lowerTrigram.chinese.contains(q)
            )
        }

        val results = mutableListOf<Hexagram>()
        if (exactNum != null) results.add(exactNum)
        results.addAll(prefixNumMatches)
        results.addAll(textMatches)
        return results
    }
}
