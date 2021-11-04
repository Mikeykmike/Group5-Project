package edu.fullerton.mobiledev.group5.gamefinder.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Data access object for the Intersection entity. The class describes how data is
 * stored, updated, retrieved, or deleted from the database.
 */
@Dao
interface ProfileDao {
    @Insert
    suspend fun insert(profile: Profile)

    @Update
    suspend fun update(profile: Profile)

    @Query("SELECT * from profile_table WHERE profileId = :key")
    fun get(key: Long): LiveData<Profile>?

    @Query("SELECT * from profile_table ORDER BY profileId DESC")
    fun getAllProfiles(): LiveData<List<Profile>>

    @Query("DELETE from profile_table")
    suspend fun clear()
}