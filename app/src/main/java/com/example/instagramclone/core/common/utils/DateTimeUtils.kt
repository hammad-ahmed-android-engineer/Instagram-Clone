package com.example.instagramclone.core.common.utils

import java.util.concurrent.TimeUnit

object DateTimeUtils {
    /**
     * Converts a timestamp in milliseconds to a relative time string (e.g., '2h', '3d', '5w').
     */
    fun getRelativeTimeSpan(timeInMillis: Long): String {
        val now = System.currentTimeMillis()
        val diff = now - timeInMillis
        
        if (diff < 0) return "just now"

        val seconds = TimeUnit.MILLISECONDS.toSeconds(diff)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(diff)
        val hours = TimeUnit.MILLISECONDS.toHours(diff)
        val days = TimeUnit.MILLISECONDS.toDays(diff)
        val weeks = days / 7
        val years = days / 365

        return when {
            seconds < 60 -> "${seconds}s"
            minutes < 60 -> "${minutes}m"
            hours < 24 -> "${hours}h"
            days < 7 -> "${days}d"
            weeks < 52 -> "${weeks}w"
            else -> "${years}y"
        }
    }
}
