package ru.clonsaldafon.rockpaperscissorsgame.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.clonsaldafon.rockpaperscissorsgame.R
import ru.clonsaldafon.rockpaperscissorsgame.model.GameChoice
import ru.clonsaldafon.rockpaperscissorsgame.utils.GameManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setView()

        setButtons()
    }

    private fun setView() {
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setButtons() {
        setButtonClick(R.id.button_rock, GameChoice.ROCK)
        setButtonClick(R.id.button_scissors, GameChoice.SCISSORS)
        setButtonClick(R.id.button_paper, GameChoice.PAPER)
    }

    private fun setButtonClick(buttonId: Int, userChoice: GameChoice) {
        findViewById<Button>(buttonId).setOnClickListener {
            startResultActivity(userChoice, GameManager.computerChoose(), this)
        }
    }

    private fun startResultActivity(user: GameChoice, computer: GameChoice, context: Context) {
        startActivity(Intent(this, ResultActivity::class.java).apply {
            putExtras(Bundle().apply {
                putString(ResultActivity.USER_KEY, user.getText(context))
                putString(ResultActivity.COMPUTER_KEY, computer.getText(context))
            })
        })
    }
}