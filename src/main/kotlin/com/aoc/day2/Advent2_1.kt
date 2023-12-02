package com.aoc.day2

import java.io.FileInputStream

fun main(args: Array<String>) {
    try {
        Game::class.java.getResourceAsStream("/advent2-1.txt").bufferedReader().useLines { lines ->
            var sumOfIds = 0
            var sumOfPowers = 0
            lines.forEach { line ->
                val grabs = line.games().map {
                    val cubes = it.cubes()
                    Grab(
                        green = cubes["green"],
                        blue = cubes["blue"],
                        red = cubes["red"]
                    )
                }
                val game = Game(line.gameId(), grabs)
                sumOfIds += game.addId()
                sumOfPowers += game.powerCubes()
                println("SumOfIds:$sumOfIds - SumOfPower:$sumOfPowers - line:$line -$game")
            }
        }
    } catch (e: Exception) {
        println("error : " + e.message)
    }
}
