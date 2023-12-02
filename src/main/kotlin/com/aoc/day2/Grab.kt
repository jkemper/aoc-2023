package com.aoc.day2

data class Grab(
    val blue: Int?,
    val red: Int?,
    val green: Int?
) {
    fun overLimit(): Boolean {
        return if (blue != null && blue > 14) {
            true
        } else if (green != null && green > 13) {
            true
        } else red != null && red > 12
    }
}