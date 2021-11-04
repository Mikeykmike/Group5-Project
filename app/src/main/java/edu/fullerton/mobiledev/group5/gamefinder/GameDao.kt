package edu.fullerton.mobiledev.group5.gamefinder

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface GameDao {
    @Insert
    suspend fun insert(game: Game)

    @Update
    suspend fun update(game: Game)

    @Query("SELECT * from games WHERE id = :key")
    fun get(key: Long): LiveData<Game>?

    @Query("SELECT * from games ORDER BY id DESC")
    fun getAllGames(): LiveData<List<Game>>

    @Query("DELETE from games")
    suspend fun clear()
}