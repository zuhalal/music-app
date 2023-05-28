package com.zuhal.musicapp.utils

object Utils {
    fun convertMinutes(second: Int): String {
        val minutes: Int = (second % 3600) / 60
        val seconds: Int = (second % 3600)% 60
        return "${minutes}:${seconds}"
    }
}