package com.example.instagramclone.core.designsystem.components

import androidx.compose.foundation.border
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.instagramclone.core.designsystem.theme.InstagramSunsetColors

/**
 * Reusable diagonal gradient border modifier matching Instagram's story ring design.
 */
fun Modifier.diagonalGradientBorder(
    colors: List<Color> = InstagramSunsetColors,
    borderSize: Dp = 2.dp,
    shape: Shape,
    isFromRight: Boolean = true
): Modifier = composed {
    val (start, end) = if (isFromRight) {
        Pair(Offset(100f, 0.0f), Offset(0.0f, 100.0f))
    } else {
        Pair(Offset.Zero, Offset.Infinite)
    }

    border(
        width = borderSize,
        brush = Brush.linearGradient(colors = colors, start = start, end = end),
        shape = shape
    )
}
