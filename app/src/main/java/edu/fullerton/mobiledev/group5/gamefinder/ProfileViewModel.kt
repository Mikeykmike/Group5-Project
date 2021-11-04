package edu.fullerton.mobiledev.group5.gamefinder

import android.app.Application
import androidx.lifecycle.*
import edu.fullerton.ecs.mdap.profiledb.database.Profile
import edu.fullerton.ecs.mdap.profiledb.database.ProfileDao
import kotlinx.coroutines.launch

class ProfileViewModel(
    val database: ProfileDao, // Data access object for the Intersection entity
    application: Application) : AndroidViewModel(application) {

    var name = MutableLiveData("")
    var email = MutableLiveData("")

    val profileList = database.getAllProfiles()

    var profileString = Transformations.map(profileList) {
            profiles -> // intersections refer to the underlying data List<Intersection>
        var result = ""
        for (profile in profiles) {
            result += "${profile.name} @ ${profile.email}\n"
        }
        result
    }

    fun insert() {
        viewModelScope.launch {
            var profile = Profile()
            profile.name = name.value.toString()
            profile.email = email.value.toString()

            database.insert(profile)
        }

    }

    fun clear() {
        viewModelScope.launch {
            database.clear()
        }
    }
}