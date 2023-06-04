package com.project.repositories

import com.project.models.Plant

class UserPlantsRepository : IUserPlantsRepository {

    var userPlants: Set<Plant> = setOf()

    override fun getPlantById(plantId: Int): Plant {
        val plant = userPlants.find { it.Id == plantId }

        return plant!!
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