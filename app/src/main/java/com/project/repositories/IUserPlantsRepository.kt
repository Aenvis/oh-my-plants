package com.project.repositories

import com.project.models.Plant

interface IUserPlantsRepository {
    fun getPlantById(plantId: Int): Plant
    fun getAllPlants(): List<Plant>
    fun insertPlant(plant: Plant)
    fun updatePlant(plant: Plant)
    fun deletePlant(plantId: Int)
}