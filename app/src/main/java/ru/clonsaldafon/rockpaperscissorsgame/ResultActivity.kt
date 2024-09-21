package ru.clonsaldafon.rockpaperscissorsgame

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    private var rockText: String? = null
    private var scissorsText: String? = null
    private var paperText: String? = null

    companion object {
        const val USER_KEY = "result_user_key"
        const val COMPUTER_KEY = "result_computer_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        rockText = getString(R.string.rock_text)
        scissorsText = getString(R.string.scissors_text)
        paperText = getString(R.string.paper_text)

        val textUserChoice = findViewById<TextView>(R.id.text_user_choice)
        val textComputerChoice = findViewById<TextView>(R.id.text_computer_choice)

        val userChoice = intent.getStringExtra(USER_KEY)
        val computerChoice = intent.getStringExtra(COMPUTER_KEY)

        textUserChoice.text = userChoice
        textComputerChoice.text = computerChoice

        checkWinner(userChoice!!, computerChoice!!)
    }

    private fun checkWinner(userChoice: String, computerChoice: String) {
        val textWinner = findViewById<TextView>(R.id.text_winner)

        when {
            userChoice == computerChoice -> textWinner.text = getString(R.string.draw)
            (userChoice == rockText && computerChoice == scissorsText) ||
                    (userChoice == scissorsText && computerChoice == paperText) ||
                    (userChoice == paperText && computerChoice == rockText) -> {
                                textWinner.text = getString(R.string.you_win)
                                textWinner.setTextColor(Color.GREEN)
                            }
            else -> {
                textWinner.text = getString(R.string.computer_win)
                textWinner.setTextColor(Color.RED)
            }
        }
    }
}