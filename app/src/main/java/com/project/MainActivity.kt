package com.project
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.project.databinding.ActivityMainBinding
import com.project.models.Plant
import com.project.services.PlantApiService
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var fetchButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var thumbnailImageView: ImageView
    private val plantApiService = PlantApiService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchButton = findViewById(R.id.fetchButton)
        resultTextView = findViewById(R.id.resultTextView)

        fetchButton.setOnClickListener { fetchRandomPlantData() }
    }

    private fun fetchRandomPlantData() {
        lifecycleScope.launch {
            try {
                val randomPlant = plantApiService.getRandomPlant()
                if (randomPlant != null) {
                    displayPlantData(randomPlant)
                } else {
                    displayNoPlantFound()
                }
            } catch (e: Exception) {
                Log.e("TAG_", "Error fetching plant data: ${e.message}")
            }
        }
    }

    private fun displayPlantData(plant: Plant) {
        resultTextView.text = buildString {
        append("Common Name: ${plant.commonName}\n")
        append("Scientific Name: ${plant.scientificName.joinToString(", ")}\n")
        append("Other Names: ${plant.otherName.joinToString(", ")}\n")
        append("Cycle: ${plant.cycle}\n")
        append("Watering: ${plant.watering}\n")
        append("Sunlight: ${plant.sunlight.joinToString(", ")}") // Load and render the thumbnail image
    }

        // Load and render the thumbnail image
        Glide.with(this)
            .load(plant.defaultImage.thumbnail)
            .fitCenter()
            .into(binding.thumbnailImageView)
    }

    private fun displayNoPlantFound() {
        resultTextView.text = "No plant was found!"
    }
}
