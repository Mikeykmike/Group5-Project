package edu.fullerton.mobiledev.group5.gamefinder.register

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.fullerton.mobiledev.group5.gamefinder.database.RegisterRepository
import java.lang.IllegalArgumentException

abstract class RegisterViewModelFactory(
    private  val repository: RegisterRepository,
    private val application: Application):ViewModelProvider.Factory{
    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(repository, application) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}