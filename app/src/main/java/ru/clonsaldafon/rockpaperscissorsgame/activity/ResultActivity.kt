package ru.clonsaldafon.rockpaperscissorsgame.activity

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import ru.clonsaldafon.rockpaperscissorsgame.R
import ru.clonsaldafon.rockpaperscissorsgame.model.GameChoice
import ru.clonsaldafon.rockpaperscissorsgame.model.GameResult
import ru.clonsaldafon.rockpaperscissorsgame.utils.GameManager

class ResultActivity : AppCompatActivity() {
    companion object {
        const val USER_KEY = "USER_KEY"
        const val COMPUTER_KEY = "COMPUTER_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        setBackButtonClick()

        val userChoice = intent.getStringExtra(USER_KEY) ?: return
        val computerChoice = intent.getStringExtra(COMPUTER_KEY) ?: return

        setTextViews(userChoice, computerChoice)

        val result = GameManager.checkWinner(userChoice, computerChoice, this)
        updateWinnerText(result)
    }

    private fun setBackButtonClick() {
        findViewById<Button>(R.id.button_back).setOnClickListener {
            this.finish()
        }
    }

    private fun setTextViews(userChoice: String, computerChoice: String) {
        val textUserChoice = findViewById<TextView>(R.id.text_user_choice)
        val textComputerChoice = findViewById<TextView>(R.id.text_computer_choice)

        textUserChoice.text = userChoice
        textComputerChoice.text = computerChoice
    }

    private fun updateWinnerText(result: GameResult) {
        val textWinner = findViewById<TextView>(R.id.text_winner)
        textWinner.text = result.getText(this)

        when (result) {
            GameResult.USER_IS_WINNER -> textWinner.setTextColor(Color.GREEN)
            GameResult.COMPUTER_IS_WINNER -> textWinner.setTextColor(Color.RED)
            GameResult.DRAW -> textWinner.setTextColor(Color.BLACK)
        }

    }
}