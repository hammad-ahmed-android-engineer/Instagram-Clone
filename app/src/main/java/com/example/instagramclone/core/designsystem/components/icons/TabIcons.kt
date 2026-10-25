package com.example.instagramclone.core.designsystem.components.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions

/**
 * Instagram Profile Tab Icons (Grid, Tagged).
 */
object TabIcons {

    val GridTab: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramGridTab",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.8f
            ) {
                moveTo(3f, 3f)
                horizontalLineTo(9f)
                verticalLineTo(9f)
                horizontalLineTo(3f)
                close()
                moveTo(11f, 3f)
                horizontalLineTo(17f)
                verticalLineTo(9f)
                horizontalLineTo(11f)
                close()
                moveTo(19f, 3f)
                horizontalLineTo(21f)
                verticalLineTo(9f)
                horizontalLineTo(19f)
                close()
                moveTo(3f, 11f)
                horizontalLineTo(9f)
                verticalLineTo(17f)
                horizontalLineTo(3f)
                close()
                moveTo(11f, 11f)
                horizontalLineTo(17f)
                verticalLineTo(17f)
                horizontalLineTo(11f)
                close()
                moveTo(19f, 11f)
                horizontalLineTo(21f)
                verticalLineTo(17f)
                horizontalLineTo(19f)
                close()
                moveTo(3f, 19f)
                horizontalLineTo(9f)
                verticalLineTo(21f)
                horizontalLineTo(3f)
                close()
                moveTo(11f, 19f)
                horizontalLineTo(17f)
                verticalLineTo(21f)
                horizontalLineTo(11f)
                close()
            }
        }.build()

    val TaggedTab: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramTaggedTab",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.8f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(4f, 4f)
                horizontalLineTo(20f)
                curveTo(21.1f, 4f, 22f, 4.9f, 22f, 6f)
                verticalLineTo(18f)
                curveTo(22f, 19.1f, 21.1f, 20f, 20f, 20f)
                horizontalLineTo(4f)
                curveTo(2.9f, 20f, 2f, 19.1f, 2f, 18f)
                verticalLineTo(6f)
                curveTo(2f, 4.9f, 2.9f, 4f, 4f, 4f)
                close()
                moveTo(12f, 10f)
                curveTo(13.1f, 10f, 14f, 9.1f, 14f, 8f)
                curveTo(14f, 6.9f, 13.1f, 6f, 12f, 6f)
                curveTo(10.9f, 6f, 10f, 6.9f, 10f, 8f)
                curveTo(10f, 9.1f, 10.9f, 10f, 12f, 10f)
                close()
                moveTo(7f, 16f)
                curveTo(7f, 13.8f, 9.2f, 12f, 12f, 12f)
                curveTo(14.8f, 12f, 17f, 13.8f, 17f, 16f)
            }
        }.build()
}
