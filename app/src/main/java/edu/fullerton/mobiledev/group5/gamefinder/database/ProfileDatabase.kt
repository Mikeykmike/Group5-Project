package edu.fullerton.mobiledev.group5.gamefinder.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.fullerton.mobiledev.group5.gamefinder.database.ProfileDao

@Database(entities = [Profile::class], version = 1, exportSchema = false)
abstract class ProfileDatabase: RoomDatabase() {
    abstract val profileDao: ProfileDao

    companion object {

        @Volatile
        private var INSTANCE: ProfileDatabase? = null

        fun getInstance(context: Context): ProfileDatabase {

            synchronized(this) {

                var instance = INSTANCE


                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProfileDatabase::class.java,
                        "<user_details_database>"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}