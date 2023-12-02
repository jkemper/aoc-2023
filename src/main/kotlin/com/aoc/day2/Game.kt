package com.aoc.day2

data class Game(
    val id: Int,
    val grabs: List<Grab>
) {
    fun addId(): Int {
        val grab = grabs.firstOrNull() { it.overLimit() }
        return if (grab != null) {
            0
        } else {
            id
        }
    }

    fun powerCubes(): Int {
        var maxGreen = 1
        var maxRed = 1
        var maxBlue = 1
        grabs.forEach { grab ->
            grab.red?.let {
                if (maxRed == 1) {
                    maxRed = it
                } else if (maxRed < grab.red) {
                    maxRed = it
                }
            }
            grab.green?.let {
                if (maxGreen == 1) {
                    maxGreen = it
                } else if (maxGreen < grab.green) {
                    maxGreen = it
                }
            }

            grab.blue?.let {
                if (maxBlue == 1) {
                    maxBlue = it
                } else if (maxBlue < grab.blue) {
                    maxBlue = it
                }
            }
        }
        return maxRed * maxGreen * maxBlue
    }
}