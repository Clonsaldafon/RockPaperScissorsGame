package ru.clonsaldafon.rockpaperscissorsgame

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textUserChoice = findViewById<TextView>(R.id.text_user_choice)
        val textComputerChoice = findViewById<TextView>(R.id.text_computer_choice)

        val userChoice = intent.getStringExtra(USER_KEY)
        val computerChoice = intent.getStringExtra(COMPUTER_KEY)

        textUserChoice.text = userChoice
        textComputerChoice.text = computerChoice

        checkWinner(userChoice!!, computerChoice!!)
    }

    companion object {
        const val USER_KEY = "result_user_key"
        const val COMPUTER_KEY = "result_computer_key"
    }

    private fun checkWinner(userChoice: String, computerChoice: String) {
        val textWinner = findViewById<TextView>(R.id.text_winner)

        when {
            userChoice == computerChoice -> textWinner.text = getString(R.string.draw)
            (userChoice == getString(R.string.rock_text) &&
                    computerChoice == getString(R.string.scissors_text)) ||
                    (userChoice == getString(R.string.scissors_text) &&
                            computerChoice == getString(R.string.paper_text)) ||
                    (userChoice == getString(R.string.paper_text) &&
                            computerChoice == getString(R.string.rock_text)) -> {
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