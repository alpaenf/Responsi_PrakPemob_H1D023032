package com.example.responsi1mobileh1d023032

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.responsi1mobileh1d023032.data.api.ApiClient
import com.example.responsi1mobileh1d023032.data.model.Player
import kotlinx.coroutines.launch

class TeamSquadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_squad)

        val squadRecyclerView: RecyclerView = findViewById(R.id.squadRecyclerView)
        squadRecyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            try {
                val team = ApiClient.apiService.getTeam(387)
                val players = team.squad

                if (!players.isNullOrEmpty()) {
                    // Sort players by position category
                    val sortedPlayers = players.sortedBy { player ->
                        getPositionCategory(player.position)
                    }
                    val adapter = PlayerAdapter(sortedPlayers)
                    squadRecyclerView.adapter = adapter
                } else {
                    Toast.makeText(this@TeamSquadActivity, "Squad data not available", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.e("TeamSquadActivity", "Error fetching squad data", e)
                Toast.makeText(this@TeamSquadActivity, "Failed to load squad data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getPositionCategory(position: String?): Int {
        return when {
            // Goalkeeper
            "Goalkeeper".equals(position, ignoreCase = true) -> 0

            // Defenders
            "Defence".equals(position, ignoreCase = true) -> 1
            "Centre-Back".equals(position, ignoreCase = true) -> 1
            "Left-Back".equals(position, ignoreCase = true) -> 1
            "Right-Back".equals(position, ignoreCase = true) -> 1

            // Midfielders
            "Midfield".equals(position, ignoreCase = true) -> 2
            "Attacking Midfield".equals(position, ignoreCase = true) -> 2
            "Defensive Midfield".equals(position, ignoreCase = true) -> 2
            "Central Midfield".equals(position, ignoreCase = true) -> 2
            "Right Midfield".equals(position, ignoreCase = true) -> 2

            // Forwards/Attackers
            "Offence".equals(position, ignoreCase = true) -> 3
            "Right Winger".equals(position, ignoreCase = true) -> 3
            "Left Winger".equals(position, ignoreCase = true) -> 3
            "Centre-Forward".equals(position, ignoreCase = true) -> 3

            else -> 4 // Group unknown positions at the end
        }
    }
}
