package ru.clonsaldafon.rockpaperscissorsgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonRock = findViewById<Button>(R.id.button_rock)
        val buttonScissors = findViewById<Button>(R.id.button_scissors)
        val buttonPaper = findViewById<Button>(R.id.button_paper)

        buttonRock.setOnClickListener {
            play(getString(R.string.rock_text))
        }

        buttonScissors.setOnClickListener {
            play(getString(R.string.scissors_text))
        }

        buttonPaper.setOnClickListener {
            play(getString(R.string.paper_text))
        }
    }

    private fun play(userChoice: String) {
        val intent = Intent(this, ResultActivity::class.java).apply {
            val computerChoice = computerChoose()

            val bundle = Bundle()
            bundle.putString(ResultActivity.USER_KEY, userChoice)
            bundle.putString(ResultActivity.COMPUTER_KEY, computerChoice)
            putExtras(bundle)
        }

        startActivity(intent)
    }

    private fun computerChoose(): String = listOf(
            getString(R.string.rock_text),
            getString(R.string.scissors_text),
            getString(R.string.paper_text)
        ).random()
}