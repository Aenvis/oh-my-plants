package com.project
import android.annotation.SuppressLint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.project.services.IPlantApiService
import com.project.services.PlantApiService
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var fetchButton: Button
    private lateinit var resultTextView: TextView
    private val plantApiService = PlantApiService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchButton = findViewById(R.id.fetchButton)
        resultTextView = findViewById(R.id.resultTextView)

        fetchButton.setOnClickListener{ fetchRandomPlantData() }
    }

    private fun fetchRandomPlantData()
    {
        lifecycleScope.launch{
            try {
                val randomPlant = plantApiService.getRandomPlant()
                if(randomPlant != null)
                {
                    resultTextView.text = randomPlant.commonName
                }
                else resultTextView.text = "No plant was found!"
            }
            catch (e: Exception)
            {
                Log.e("TAG_", "Error fetching plant data: ${e.message}")
            }
        }
    }
}