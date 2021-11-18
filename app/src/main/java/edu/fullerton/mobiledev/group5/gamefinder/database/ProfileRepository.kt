package edu.fullerton.mobiledev.group5.gamefinder.database

import android.util.Log
import androidx.lifecycle.LiveData

class ProfileRepository(private val dao: ProfileDao) {
    val profiles = dao.getAllProfiles()

    suspend fun insert(profile: Profile) {
        return dao.insert(profile)
    }

    suspend fun get(key: Long):Profile?{
        Log.i("MYTAG", "inside Repository Getusers fun ")
        return dao.get(key)
    }

}