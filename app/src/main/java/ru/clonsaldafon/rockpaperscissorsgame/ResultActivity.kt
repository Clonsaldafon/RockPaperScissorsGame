package ru.clonsaldafon.rockpaperscissorsgame

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textUserChoice = findViewById<TextView>(R.id.text_user_choice)
        textUserChoice.text = intent.getStringExtra(KEY)
    }

    companion object {
        const val KEY = "result_key"
    }
}