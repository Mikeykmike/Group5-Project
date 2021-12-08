package edu.fullerton.mobiledev.group5.gamefinder

import com.squareup.moshi.Json
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface VideoGameDatabaseService {
    @GET("games?key=${API_KEY}")
    fun getGames(): Call<GameList>

    @GET("games/{id}?key=${API_KEY}")
    fun getDetails(@Path("id") id: Int): Call<GameInformation>

    companion object {
        const val API_KEY = "46d899c1e9a440939b6ed78d1e566894"
        const val API_URL = "https://api.rawg.io/api/"
    }
}

data class GameList(
    @field:Json(name = "count") val count: Int,
    @field:Json(name = "next") val next: String?,
    @field:Json(name = "previous") val previous: String?,
    @field:Json(name = "results") val results: List<GameResult>,
)

data class GameResult(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "released") val releaseDate: String?,
    @field:Json(name = "background_image") val imageUrl: String?,
    @field:Json(name = "metacritic") val metacritic: Int?,
)

data class GameInformation(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "background_image") val imageUrl: String?,
    @field:Json(name = "metacritic") val metacritic: Int?,
    @field:Json(name = "released") val released: String?,
    @field:Json(name = "playtime") val playtime: Int?,
)