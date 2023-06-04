package com.project.services
import com.project.models.PlantResponse
import retrofit2.http.GET

interface IPlantApiService {
    @GET("species-list?page=1&key=sk-jtUk647b585f0f2611114")
    suspend fun getRandomPlant(): PlantResponse
}