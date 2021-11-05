package edu.fullerton.mobiledev.group5.gamefinder

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class Game(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    @ColumnInfo()
    var name: String = "",

    @ColumnInfo()
    var description: String = ""
)