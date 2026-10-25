package com.example.instagramclone.core.designsystem.components.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions

/**
 * Instagram System, Badges, and Control Icons (Verified, Dropdown, Threads, Sliders, MoreHorizontal).
 */
object SystemIcons {

    val MoreHorizontal: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramMoreHorizontal",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(6f, 12f)
                curveTo(6f, 10.9f, 5.1f, 10f, 4f, 10f)
                curveTo(2.9f, 10f, 2f, 10.9f, 2f, 12f)
                curveTo(2f, 13.1f, 2.9f, 14f, 4f, 14f)
                curveTo(5.1f, 14f, 6f, 13.1f, 6f, 12f)
                close()
                moveTo(14f, 12f)
                curveTo(14f, 10.9f, 13.1f, 10f, 12f, 10f)
                curveTo(10.9f, 10f, 10f, 10.9f, 10f, 12f)
                curveTo(10.9f, 10f, 10f, 10.9f, 10f, 12f)
                curveTo(10f, 13.1f, 10.9f, 14f, 12f, 14f)
                curveTo(13.1f, 14f, 14f, 13.1f, 14f, 12f)
                close()
                moveTo(22f, 12f)
                curveTo(22f, 10.9f, 21.1f, 10f, 20f, 10f)
                curveTo(18.9f, 10f, 18f, 10.9f, 18f, 12f)
                curveTo(18f, 13.1f, 18.9f, 14f, 20f, 14f)
                curveTo(21.1f, 14f, 22f, 13.1f, 22f, 12f)
                close()
            }
        }.build()

    val VerifiedBadge: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramVerified",
            defaultWidth = AppDimensions.dp(16),
            defaultHeight = AppDimensions.dp(16),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF0095F6))) {
                moveTo(12f, 2f)
                lineTo(14.4f, 4.5f)
                lineTo(17.8f, 4.2f)
                lineTo(19f, 7.3f)
                lineTo(22.2f, 8.6f)
                lineTo(21.8f, 12f)
                lineTo(23.4f, 15f)
                lineTo(21f, 17.4f)
                lineTo(20.7f, 20.8f)
                lineTo(17.5f, 21.6f)
                lineTo(15f, 23.9f)
                lineTo(12f, 22.4f)
                lineTo(9f, 23.9f)
                lineTo(6.5f, 21.6f)
                lineTo(3.3f, 20.8f)
                lineTo(3f, 17.4f)
                lineTo(0.6f, 15f)
                lineTo(2.2f, 12f)
                lineTo(1.8f, 8.6f)
                lineTo(5f, 7.3f)
                lineTo(6.2f, 4.2f)
                lineTo(9.6f, 4.5f)
                close()
            }
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 2.4f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(7.5f, 12.5f)
                lineTo(10.5f, 15.5f)
                lineTo(16.5f, 9.5f)
            }
        }.build()

    val DropdownCaret: ImageVector
        get() = ImageVector.Builder(
            name = "DropdownCaret",
            defaultWidth = AppDimensions.dp(14),
            defaultHeight = AppDimensions.dp(14),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(6f, 9f)
                lineTo(12f, 15f)
                lineTo(18f, 9f)
            }
        }.build()

    val Threads: ImageVector
        get() = ImageVector.Builder(
            name = "Threads",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.9f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(12f, 21.5f)
                curveTo(6.75f, 21.5f, 2.5f, 17.25f, 2.5f, 12f)
                curveTo(2.5f, 6.75f, 6.75f, 2.5f, 12f, 2.5f)
                curveTo(17.25f, 2.5f, 21.5f, 6.75f, 21.5f, 12f)
                curveTo(21.5f, 14.8f, 20.3f, 17.2f, 18.4f, 18.7f)
                curveTo(16.8f, 20f, 14.5f, 20.3f, 12.8f, 19.3f)
                curveTo(10.7f, 18.1f, 9.8f, 15.6f, 9.8f, 13.2f)
                curveTo(9.8f, 9.8f, 12.2f, 8.2f, 14.8f, 8.2f)
                curveTo(17.5f, 8.2f, 19.2f, 10.1f, 19.2f, 12.5f)
                curveTo(19.2f, 14.2f, 18.2f, 15.2f, 16.8f, 15.2f)
                curveTo(15.7f, 15.2f, 15f, 14.5f, 15f, 13.3f)
                verticalLineTo(10.5f)
            }
        }.build()

    val TuneSliders: ImageVector
        get() = ImageVector.Builder(
            name = "TuneSliders",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            // Top track & slider
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(3f, 7f)
                horizontalLineTo(9f)
                moveTo(15f, 7f)
                horizontalLineTo(21f)
            }
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2f
            ) {
                moveTo(12f, 5f)
                curveTo(10.9f, 5f, 10f, 5.9f, 10f, 7f)
                curveTo(10f, 8.1f, 10.9f, 9f, 12f, 9f)
                curveTo(13.1f, 9f, 14f, 8.1f, 14f, 7f)
                curveTo(14f, 5.9f, 13.1f, 5f, 12f, 5f)
                close()
            }

            // Bottom track & slider
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(3f, 17f)
                horizontalLineTo(13f)
                moveTo(19f, 17f)
                horizontalLineTo(21f)
            }
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2f
            ) {
                moveTo(16f, 15f)
                curveTo(14.9f, 15f, 14f, 15.9f, 14f, 17f)
                curveTo(14f, 18.1f, 14.9f, 19f, 16f, 19f)
                curveTo(17.1f, 19f, 18f, 18.1f, 18f, 17f)
                curveTo(18f, 15.9f, 17.1f, 15f, 16f, 15f)
                close()
            }
        }.build()
}
