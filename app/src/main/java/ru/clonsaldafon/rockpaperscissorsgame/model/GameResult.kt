package ru.clonsaldafon.rockpaperscissorsgame.model

import android.content.Context
import ru.clonsaldafon.rockpaperscissorsgame.R

enum class GameResult(private val resourceId: Int) {

    USER_IS_WINNER(R.string.you_win),
    COMPUTER_IS_WINNER(R.string.computer_win),
    DRAW(R.string.draw);

    fun getText(context: Context): String {
        return context.getString(resourceId)
    }
}