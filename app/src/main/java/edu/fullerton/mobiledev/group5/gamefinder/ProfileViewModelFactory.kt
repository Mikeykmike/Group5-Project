package edu.fullerton.mobiledev.group5.gamefinder

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.fullerton.ecs.mdap.profiledb.database.ProfileDao

/**
 * Generates an IntersectionViewModel tied to the database.
 */
class ProfileViewModelFactory(
    private val dataSource: ProfileDao, // Data access object
    private val application: Application): ViewModelProvider.Factory {

    /**
     * Creates the ProfileViewModel
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) { // ViewModel class
            return ProfileViewModel(dataSource, application) as T // Call ViewModel constructor
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}