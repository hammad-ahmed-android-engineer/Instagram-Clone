package com.example.instagramclone.core.designsystem.components.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions

/**
 * Instagram Navigation Icons (Home, Search, Create, Reels) in regular and filled variants.
 */
object NavigationIcons {

    val Home: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramHome",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(3f, 9.5f)
                lineTo(12f, 2.5f)
                lineTo(21f, 9.5f)
                verticalLineTo(20f)
                curveTo(21f, 20.6f, 20.6f, 21f, 20f, 21f)
                horizontalLineTo(15f)
                verticalLineTo(14f)
                horizontalLineTo(9f)
                verticalLineTo(21f)
                horizontalLineTo(4f)
                curveTo(3.4f, 21f, 3f, 20.6f, 3f, 20f)
                close()
            }
        }.build()

    val HomeFilled: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramHomeFilled",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(12f, 2.1f)
                lineTo(2.3f, 9.7f)
                curveTo(1.9f, 10f, 1.9f, 10.6f, 2.3f, 10.9f)
                lineTo(3f, 11.5f)
                verticalLineTo(20.5f)
                curveTo(3f, 21.3f, 3.7f, 22f, 4.5f, 22f)
                horizontalLineTo(9.5f)
                verticalLineTo(15f)
                horizontalLineTo(14.5f)
                verticalLineTo(22f)
                horizontalLineTo(19.5f)
                curveTo(20.3f, 22f, 21f, 21.3f, 21f, 20.5f)
                verticalLineTo(11.5f)
                lineTo(21.7f, 10.9f)
                curveTo(22.1f, 10.6f, 22.1f, 10f, 21.7f, 9.7f)
                lineTo(12f, 2.1f)
                close()
            }
        }.build()

    val Search: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramSearch",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2.2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(18.5f, 10.5f)
                curveTo(18.5f, 14.9f, 14.9f, 18.5f, 10.5f, 18.5f)
                curveTo(6.1f, 18.5f, 2.5f, 14.9f, 2.5f, 10.5f)
                curveTo(2.5f, 6.1f, 6.1f, 2.5f, 10.5f, 2.5f)
                curveTo(14.9f, 2.5f, 18.5f, 6.1f, 18.5f, 10.5f)
                close()
                moveTo(16.5f, 16.5f)
                lineTo(21.5f, 21.5f)
            }
        }.build()

    val SearchFilled: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramSearchFilled",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 3.2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(18.5f, 10.5f)
                curveTo(18.5f, 14.9f, 14.9f, 18.5f, 10.5f, 18.5f)
                curveTo(6.1f, 18.5f, 2.5f, 14.9f, 2.5f, 10.5f)
                curveTo(2.5f, 6.1f, 6.1f, 2.5f, 10.5f, 2.5f)
                curveTo(14.9f, 2.5f, 18.5f, 6.1f, 18.5f, 10.5f)
                close()
                moveTo(16.5f, 16.5f)
                lineTo(21.5f, 21.5f)
            }
        }.build()

    val Create: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramCreate",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(3f, 7f)
                curveTo(3f, 4.8f, 4.8f, 3f, 7f, 3f)
                horizontalLineTo(17f)
                curveTo(19.2f, 3f, 21f, 4.8f, 21f, 7f)
                verticalLineTo(17f)
                curveTo(21f, 19.2f, 19.2f, 21f, 17f, 21f)
                horizontalLineTo(7f)
                curveTo(4.8f, 21f, 3f, 19.2f, 3f, 17f)
                close()
                moveTo(12f, 7f)
                verticalLineTo(17f)
                moveTo(7f, 12f)
                horizontalLineTo(17f)
            }
        }.build()

    val CreateFilled: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramCreateFilled",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(7f, 3f)
                horizontalLineTo(17f)
                curveTo(19.2f, 3f, 21f, 4.8f, 21f, 7f)
                verticalLineTo(17f)
                curveTo(21f, 19.2f, 19.2f, 21f, 17f, 21f)
                horizontalLineTo(7f)
                curveTo(4.8f, 21f, 3f, 19.2f, 3f, 17f)
                verticalLineTo(7f)
                curveTo(3f, 4.8f, 4.8f, 3f, 7f, 3f)
                close()
                moveTo(11f, 7f)
                curveTo(11f, 6.4f, 11.4f, 6f, 12f, 6f)
                curveTo(12.6f, 6f, 13f, 6.4f, 13f, 7f)
                verticalLineTo(11f)
                horizontalLineTo(17f)
                curveTo(17.6f, 11f, 18f, 11.4f, 18f, 12f)
                curveTo(18f, 12.6f, 17.6f, 13f, 17f, 13f)
                horizontalLineTo(13f)
                verticalLineTo(17f)
                curveTo(13f, 17.6f, 12.6f, 18f, 12f, 18f)
                curveTo(11.4f, 18f, 11f, 17.6f, 11f, 17f)
                verticalLineTo(13f)
                horizontalLineTo(7f)
                curveTo(6.4f, 13f, 6f, 12.6f, 6f, 12f)
                curveTo(6f, 11.4f, 6.4f, 11f, 7f, 11f)
                horizontalLineTo(11f)
                verticalLineTo(7f)
                close()
            }
        }.build()

    val Reels: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramReels",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(4f, 3f)
                horizontalLineTo(20f)
                curveTo(21.1f, 3f, 22f, 3.9f, 22f, 5f)
                verticalLineTo(19f)
                curveTo(22f, 20.1f, 21.1f, 21f, 20f, 21f)
                horizontalLineTo(4f)
                curveTo(2.9f, 21f, 2f, 20.1f, 2f, 19f)
                verticalLineTo(5f)
                curveTo(2f, 3.9f, 2.9f, 3f, 4f, 3f)
                close()
                moveTo(2f, 8.5f)
                horizontalLineTo(22f)
                moveTo(8.5f, 3f)
                lineTo(7f, 8.5f)
                moveTo(16.5f, 3f)
                lineTo(15f, 8.5f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(10f, 12f)
                lineTo(16f, 15f)
                lineTo(10f, 18f)
                close()
            }
        }.build()

    val ReelsFilled: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramReelsFilled",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(4f, 3f)
                horizontalLineTo(20f)
                curveTo(21.1f, 3f, 22f, 3.9f, 22f, 5f)
                verticalLineTo(19f)
                curveTo(22f, 20.1f, 21.1f, 21f, 20f, 21f)
                horizontalLineTo(4f)
                curveTo(2.9f, 21f, 2f, 20.1f, 2f, 19f)
                verticalLineTo(5f)
                curveTo(2f, 3.9f, 2.9f, 3f, 4f, 3f)
                close()
            }
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 1.5f
            ) {
                moveTo(2f, 8.5f)
                horizontalLineTo(22f)
                moveTo(8.5f, 3f)
                lineTo(7f, 8.5f)
                moveTo(16.5f, 3f)
                lineTo(15f, 8.5f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(10.5f, 12f)
                lineTo(16f, 15f)
                lineTo(10.5f, 18f)
                close()
            }
        }.build()
}
