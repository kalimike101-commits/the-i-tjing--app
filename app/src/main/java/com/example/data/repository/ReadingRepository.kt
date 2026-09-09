package com.example.data.repository

import com.example.data.db.ReadingDao
import com.example.data.db.ReadingEntity
import kotlinx.coroutines.flow.Flow

class ReadingRepository(private val readingDao: ReadingDao) {
    val allReadings: Flow<List<ReadingEntity>> = readingDao.getAllReadings()

    suspend fun getById(id: Long): ReadingEntity? = readingDao.getReadingById(id)

    suspend fun insert(reading: ReadingEntity): Long = readingDao.insertReading(reading)

    suspend fun update(reading: ReadingEntity) = readingDao.updateReading(reading)

    suspend fun delete(reading: ReadingEntity) = readingDao.deleteReading(reading)

    suspend fun deleteById(id: Long) = readingDao.deleteById(id)
}
