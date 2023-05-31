package com.project.repositories

import com.project.models.Plant

class UserPlantsRepository : IUserPlantsRepository {

    var userPlants: List<Plant> = listOf()

    override fun getPlantById(plantId: Int): Plant {
        TODO("Not yet implemented")
    }

    override fun getAllPlants(): List<Plant> {
        TODO("Not yet implemented")
    }

    override fun insertPlant(plant: Plant) {
        TODO("Not yet implemented")
    }

    override fun updatePlant(plant: Plant) {
        TODO("Not yet implemented")
    }

    override fun deletePlant(plantId: Int) {
        TODO("Not yet implemented")
    }
}