package com.project.services

import com.project.models.Plant

interface IPlantsService {
    fun getPlantsFromApi(): List<Plant>
    fun getUserPlantById(plantId: Int): Plant
    fun getUserPlantByName(plantName: String): Plant
    fun addNewPlant(plant: Plant)
    fun updatePlant(plant: Plant)
    fun deletePlant(plantId: Int)

}