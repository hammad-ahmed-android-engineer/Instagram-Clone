package com.example.instagramclone.core.common.utils

import java.util.Locale

object NumberFormatUtils {
    /**
     * Formats a large number into a compact string (e.g., 1200 -> '1.2K', 1500000 -> '1.5M').
     */
    fun formatCompact(count: Long): String {
        if (count < 1000) return count.toString()

        val exp = (Math.log10(count.toDouble()) / 3).toInt()
        val suffix = "KMGTPE"[exp - 1]
        val value = count / Math.pow(1000.0, exp.toDouble())

        return if (value % 1 == 0.0 || value >= 10) {
            // No decimal if it's a whole number or >= 10 (e.g., 15K instead of 15.0K)
            String.format(Locale.US, "%.0f%c", value, suffix)
        } else {
            String.format(Locale.US, "%.1f%c", value, suffix)
        }
    }
    
    fun formatCompact(count: Int): String {
        return formatCompact(count.toLong())
    }
}
