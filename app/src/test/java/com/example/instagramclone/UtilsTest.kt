package com.example.instagramclone

import com.example.instagramclone.core.common.utils.DateTimeUtils
import com.example.instagramclone.core.common.utils.NumberFormatUtils
import org.junit.Assert.assertEquals
import org.junit.Test

class UtilsTest {

    @Test
    fun numberFormat_isCorrect() {
        assertEquals("999", NumberFormatUtils.formatCompact(999))
        assertEquals("1.2K", NumberFormatUtils.formatCompact(1200))
        assertEquals("1.5M", NumberFormatUtils.formatCompact(1500000))
    }

    @Test
    fun relativeTimeSpan_isCorrect() {
        val now = System.currentTimeMillis()
        val oneHourAgo = now - (60 * 60 * 1000)
        assertEquals("1h", DateTimeUtils.getRelativeTimeSpan(oneHourAgo))
    }
}
