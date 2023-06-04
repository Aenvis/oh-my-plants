package com.project.services

import com.project.models.Plant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random


class PlantApiService {
    private val apiService: IPlantApiService
    private val apiBaseUrl = "https://perenual.com/api/"

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(apiBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(IPlantApiService::class.java)
    }

    suspend fun getRandomPlant(): Plant?
    {
        val plantResponse = apiService.getPlants()
        val plants = plantResponse.data
        if(plants.isNotEmpty())
        {
            val randomIndex = Random.nextInt(0, plants.size);
            return plants[randomIndex]
        }

        return null
    }
}
