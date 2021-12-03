package edu.fullerton.mobiledev.group5.gamefinder.userDetails

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.fullerton.mobiledev.group5.gamefinder.database.RegisterRepository
import java.lang.IllegalArgumentException

abstract class UserDetailsFactory (
    private  val repository: RegisterRepository,
    private val application: Application
): ViewModelProvider.Factory{
    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserDetailsViewModel::class.java)) {
            return UserDetailsViewModel(repository, application) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}