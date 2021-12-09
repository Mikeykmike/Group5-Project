package edu.fullerton.mobiledev.group5.gamefinder

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavViewModel (application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<FavEntity>>
    private val repository: FavRepo

    init {
        val FavDao= FavDatabase.getDatabase(application)!!.FavDao()
        repository = FavRepo(FavDao)
        readAllData = repository.readAllData
    }

    fun addFavorite(favEntity: FavEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.addFavorites(favEntity)
        }
    }
}