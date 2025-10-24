package com.example.responsi1mobileh1d023032

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.responsi1mobileh1d023032.data.model.Player
import com.google.android.material.bottomsheet.BottomSheetDialog

class PlayerAdapter(private val players: List<Player>) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.playerName.text = player.name
        holder.playerNationality.text = player.nationality

        val playerPosition = player.position

        val color = when {
            // Goalkeeper
            "Goalkeeper".equals(playerPosition, ignoreCase = true) -> Color.YELLOW

            // Defenders
            "Defence".equals(playerPosition, ignoreCase = true) -> Color.BLUE
            "Centre-Back".equals(playerPosition, ignoreCase = true) -> Color.BLUE
            "Left-Back".equals(playerPosition, ignoreCase = true) -> Color.BLUE
            "Right-Back".equals(playerPosition, ignoreCase = true) -> Color.BLUE

            // Midfielders
            "Midfield".equals(playerPosition, ignoreCase = true) -> Color.GREEN
            "Attacking Midfield".equals(playerPosition, ignoreCase = true) -> Color.GREEN
            "Defensive Midfield".equals(playerPosition, ignoreCase = true) -> Color.GREEN
            "Central Midfield".equals(playerPosition, ignoreCase = true) -> Color.GREEN
            "Right Midfield".equals(playerPosition, ignoreCase = true) -> Color.GREEN

            // Forwards/Attackers
            "Offence".equals(playerPosition, ignoreCase = true) -> Color.RED
            "Right Winger".equals(playerPosition, ignoreCase = true) -> Color.RED
            "Left Winger".equals(playerPosition, ignoreCase = true) -> Color.RED
            "Centre-Forward".equals(playerPosition, ignoreCase = true) -> Color.RED

            else -> Color.GRAY
        }
        holder.playerCard.setBackgroundColor(color)

        // Adjust text color for better contrast
        if ("Goalkeeper".equals(playerPosition, ignoreCase = true)) {
            holder.playerName.setTextColor(Color.BLACK)
            holder.playerNationality.setTextColor(Color.BLACK)
        } else {
            holder.playerName.setTextColor(Color.WHITE)
            holder.playerNationality.setTextColor(Color.WHITE)
        }

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val bottomSheetDialog = BottomSheetDialog(context)
            val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_player_detail, null)

            val detailPlayerName: TextView = dialogView.findViewById(R.id.detailPlayerName)
            val detailPlayerDob: TextView = dialogView.findViewById(R.id.detailPlayerDob)
            val detailPlayerNationality: TextView = dialogView.findViewById(R.id.detailPlayerNationality)
            val detailPlayerPosition: TextView = dialogView.findViewById(R.id.detailPlayerPosition)

            detailPlayerName.text = player.name ?: "N/A"
            detailPlayerDob.text = player.dateOfBirth ?: "N/A"
            detailPlayerNationality.text = player.nationality ?: "N/A"
            detailPlayerPosition.text = player.position ?: "N/A"

            bottomSheetDialog.setContentView(dialogView)
            bottomSheetDialog.show()
        }
    }

    override fun getItemCount() = players.size

    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val playerName: TextView = itemView.findViewById(R.id.playerName)
        val playerNationality: TextView = itemView.findViewById(R.id.playerNationality)
        val playerCard: LinearLayout = itemView.findViewById(R.id.playerCard)
    }
}
