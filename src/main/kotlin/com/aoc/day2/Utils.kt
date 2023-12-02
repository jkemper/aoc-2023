package com.aoc.day2


fun String.gameId(): Int {
    val gameStr = this.subSequence(0, this.indexOf(":"))
    val idString = gameStr.substring("Game ".length, gameStr.length).trim()
    return idString.toInt()
}

fun String.games(): List<String> {
    val gamesStr = this.subSequence(this.indexOf(":") + 1, this.length).trim()
    return gamesStr.split(";")
}

fun String.cubes(): Map<String, Int> {
    val cubes = this.trim().split(",")
    val mapOfCubes = mutableMapOf<String, Int>()
    cubes.forEach { cube ->
        val cubeStr = cube.trim()
        val key = cubeStr.substring(cubeStr.indexOf(" "), cubeStr.length).trim()
        val value = cubeStr.substring(0, cubeStr.indexOf(" ")).trim()
        mapOfCubes[key] = value.toInt()
    }
    return mapOfCubes
}