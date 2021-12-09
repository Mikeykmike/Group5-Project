package edu.fullerton.mobiledev.group5.gamefinder

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao

interface FavDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavorites(favEntity: FavEntity)

    @Query(value = "SELECT * from favoritesData ORDER BY id ASC")
    fun readAllData(): LiveData<List<FavEntity>>
}