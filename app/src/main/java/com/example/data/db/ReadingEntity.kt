package com.example.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "readings")
data class ReadingEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val timestamp: Long = System.currentTimeMillis(),
    val question: String,
    val primaryHexagramNumber: Int,
    val changingLines: String, // Comma-separated 1-based indices, e.g. "2,5" or ""
    val transformedHexagramNumber: Int?,
    val notes: String = ""
)
