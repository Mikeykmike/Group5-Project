package edu.fullerton.mobiledev.group5.gamefinder

import android.icu.text.CaseMap
import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoritesData")
data class FavEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val gameTitle: String
        )

