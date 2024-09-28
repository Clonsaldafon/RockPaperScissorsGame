package ru.clonsaldafon.rockpaperscissorsgame.utils

import android.content.Context
import ru.clonsaldafon.rockpaperscissorsgame.model.GameChoice
import ru.clonsaldafon.rockpaperscissorsgame.model.GameResult

object GameManager {

    fun computerChoose(): GameChoice = listOf(
        GameChoice.ROCK,
        GameChoice.SCISSORS,
        GameChoice.PAPER
    ).random()

    fun checkWinner(user: String, computer: String, context: Context): GameResult =
        when {
            user == computer -> GameResult.DRAW
            isUserWinner(user, computer, context) -> GameResult.USER_IS_WINNER
            else -> GameResult.COMPUTER_IS_WINNER
        }

    private fun isUserWinner(user: String, computer: String, context: Context): Boolean {
        val rockText = GameChoice.ROCK.getText(context)
        val scissorsText = GameChoice.SCISSORS.getText(context)
        val paperText = GameChoice.PAPER.getText(context)

        return (user == rockText && computer == scissorsText) ||
                (user == scissorsText && computer == paperText) ||
                (user == paperText && computer == rockText)
    }
}