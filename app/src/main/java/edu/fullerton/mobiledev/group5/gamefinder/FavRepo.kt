package edu.fullerton.mobiledev.group5.gamefinder

import androidx.lifecycle.LiveData

class FavRepo (private val favDao: FavDao) {

    val readAllData: LiveData<List<FavEntity>> = favDao.readAllData()

    suspend fun addFavorites(favEntity: FavEntity) {
        favDao.addFavorites(favEntity)
    }
}