package com.example.responsi1mobileh1d023032

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clubHistoryCard = findViewById<CardView>(R.id.clubHistoryCard)
        clubHistoryCard.setOnClickListener {
            val intent = Intent(this, ClubHistoryActivity::class.java)
            startActivity(intent)
        }

        val headCoachCard = findViewById<CardView>(R.id.headCoachCard)
        headCoachCard.setOnClickListener {
            val intent = Intent(this, CoachActivity::class.java)
            startActivity(intent)
        }

        val teamSquadCard = findViewById<CardView>(R.id.teamSquadCard)
        teamSquadCard.setOnClickListener {
            val intent = Intent(this, TeamSquadActivity::class.java)
            startActivity(intent)
        }
    }
}
