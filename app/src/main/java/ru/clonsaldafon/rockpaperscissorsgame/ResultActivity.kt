package ru.clonsaldafon.rockpaperscissorsgame

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textUserChoice = findViewById<TextView>(R.id.text_user_choice)
        val textComputerChoice = findViewById<TextView>(R.id.text_computer_choice)

        textUserChoice.text = intent.getStringExtra(USER_KEY)
        textComputerChoice.text = intent.getStringExtra(COMPUTER_KEY)
    }

    companion object {
        const val USER_KEY = "result_user_key"
        const val COMPUTER_KEY = "result_computer_key"
    }
}