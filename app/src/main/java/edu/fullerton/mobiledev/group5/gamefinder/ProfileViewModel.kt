package edu.fullerton.mobiledev.group5.gamefinder

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import edu.fullerton.mobiledev.group5.gamefinder.database.Profile
import edu.fullerton.mobiledev.group5.gamefinder.database.ProfileDao
import kotlinx.coroutines.launch

class ProfileViewModel(
    val database: ProfileDao, // Data access object for the Intersection entity
    application: Application) : AndroidViewModel(application) {

    var et_first_name = MutableLiveData("")
    var et_last_name = MutableLiveData("")
    var et_email = MutableLiveData("")
    var et_password = MutableLiveData("")
    var et_repeat_password = MutableLiveData("")




    val profileList = database.getAllProfiles()

    var profileString = Transformations.map(profileList) {
            profiles -> // intersections refer to the underlying data List<Intersection>
        var result = ""
        for (profile in profiles) {
            result += "${profile.et_first_name} @ ${profile.et_last_name} @ ${profile.et_email} @ ${profile.et_password} @ ${profile.et_repeat_password }\n"
        }
        result
    }

    fun insert() {
        viewModelScope.launch {
            var profile = Profile()
            profile.et_first_name = et_first_name.value.toString()
            profile.et_last_name = et_last_name.value.toString()
            profile.et_email = et_email.value.toString()
            profile.et_password = et_password.value.toString()
            profile.et_repeat_password  = et_repeat_password .value.toString()

            database.insert(profile)
        }

    }

    fun clear() {
        viewModelScope.launch {
            database.clear()
        }
    }
}