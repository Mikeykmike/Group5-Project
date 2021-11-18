package edu.fullerton.mobiledev.group5.gamefinder.database

import androidx.lifecycle.MutableLiveData
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "profile_table")
data class Profile(

    @PrimaryKey(autoGenerate = true)
    var profileId: Long = 0L,

    @ColumnInfo()
    var et_first_name: String = "",

    @ColumnInfo()
    var et_last_name: String = "",

    @ColumnInfo()
    var et_email: String = "",

    @ColumnInfo()
    var et_password: String = "",

    @ColumnInfo()
    var et_repeat_password: String = ""
)
