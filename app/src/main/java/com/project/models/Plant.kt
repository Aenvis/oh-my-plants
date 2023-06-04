package com.project.models
import com.google.gson.annotations.SerializedName

data class Plant(
    val id: Int,
    @SerializedName("common_name") val commonName: String,
    @SerializedName("scientific_name") val scientificName: List<String>,
    @SerializedName("other_name") val otherName: List<String>,
    val cycle: String,
    val watering: String,
    val sunlight: List<String>,
    @SerializedName("default_image") val defaultImage: PlantImage
)

data class PlantImage(
    val thumbnail: String,
    @SerializedName("original_url") val imageUrl: String
)