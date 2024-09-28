package ru.clonsaldafon.rockpaperscissorsgame.model

import android.content.Context
import ru.clonsaldafon.rockpaperscissorsgame.R

enum class GameChoice(private val resourceId: Int) {

    ROCK(R.string.rock_text),
    SCISSORS(R.string.scissors_text),
    PAPER(R.string.paper_text);

    fun getText(context: Context): String {
        return context.getString(resourceId)
    }
}