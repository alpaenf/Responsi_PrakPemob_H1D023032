package com.example.responsi1mobileh1d023032

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.responsi1mobileh1d023032.data.api.ApiClient
import kotlinx.coroutines.launch

class CoachActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coach)

        val coachName: TextView = findViewById(R.id.coachName)
        val coachDob: TextView = findViewById(R.id.coachDob)
        val coachNationality: TextView = findViewById(R.id.coachNationality)

        lifecycleScope.launch {
            try {
                val team = ApiClient.apiService.getTeam(387)
                val coach = team.coach

                if (coach != null) {
                    coachName.text = coach.name
                    coachDob.text = coach.dateOfBirth
                    coachNationality.text = coach.nationality
                } else {
                    // Handle the case where coach data is not available
                    coachName.text = "Coach data not available"
                    coachDob.text = ""
                    coachNationality.text = ""
                }
            } catch (e: Exception) {
                Log.e("CoachActivity", "Error fetching coach data", e)
                Toast.makeText(this@CoachActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
