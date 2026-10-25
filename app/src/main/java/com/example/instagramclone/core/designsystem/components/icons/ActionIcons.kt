package com.example.instagramclone.core.designsystem.components.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions

/**
 * Instagram Action / Interaction Icons (Heart, Comment, Share, Bookmark, Repost).
 */
object ActionIcons {

    val Heart: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramHeart",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 1.8f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(12f, 21f)
                curveTo(11.75f, 21f, 11.5f, 20.9f, 11.3f, 20.7f)
                curveTo(6.4f, 16.3f, 2.5f, 12.8f, 2.5f, 8.8f)
                curveTo(2.5f, 5.6f, 4.9f, 3.2f, 8.1f, 3.2f)
                curveTo(9.9f, 3.2f, 11.6f, 4.1f, 12f, 5.2f)
                curveTo(12.4f, 4.1f, 14.1f, 3.2f, 15.9f, 3.2f)
                curveTo(19.1f, 3.2f, 21.5f, 5.6f, 21.5f, 8.8f)
                curveTo(21.5f, 12.8f, 17.6f, 16.3f, 12.7f, 20.7f)
                curveTo(12.5f, 20.9f, 12.25f, 21f, 12f, 21f)
                close()
            }
        }.build()

    val HeartFilled: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramHeartFilled",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFFED4956))) {
                moveTo(12f, 21f)
                curveTo(11.75f, 21f, 11.5f, 20.9f, 11.3f, 20.7f)
                curveTo(6.4f, 16.3f, 2.5f, 12.8f, 2.5f, 8.8f)
                curveTo(2.5f, 5.6f, 4.9f, 3.2f, 8.1f, 3.2f)
                curveTo(9.9f, 3.2f, 11.6f, 4.1f, 12f, 5.2f)
                curveTo(12.4f, 4.1f, 14.1f, 3.2f, 15.9f, 3.2f)
                curveTo(19.1f, 3.2f, 21.5f, 5.6f, 21.5f, 8.8f)
                curveTo(21.5f, 12.8f, 17.6f, 16.3f, 12.7f, 20.7f)
                curveTo(12.5f, 20.9f, 12.25f, 21f, 12f, 21f)
                close()
            }
        }.build()

    val Comment: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramComment",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 1.8f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(12f, 2.8f)
                curveTo(6.9f, 2.8f, 2.8f, 6.9f, 2.8f, 12f)
                curveTo(2.8f, 13.9f, 3.4f, 15.6f, 4.3f, 17.1f)
                lineTo(3.2f, 20.6f)
                curveTo(3.1f, 20.9f, 3.4f, 21.2f, 3.7f, 21.1f)
                lineTo(7.2f, 20f)
                curveTo(8.6f, 20.8f, 10.3f, 21.2f, 12f, 21.2f)
                curveTo(17.1f, 21.2f, 21.2f, 17.1f, 21.2f, 12f)
                curveTo(21.2f, 6.9f, 17.1f, 2.8f, 12f, 2.8f)
                close()
            }
        }.build()

    val Repost: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramRepost",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 1.8f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                // Top loop arrow
                moveTo(5f, 11f)
                verticalLineTo(9f)
                curveTo(5f, 6.8f, 6.8f, 5f, 9f, 5f)
                horizontalLineTo(19f)
                moveTo(16f, 2f)
                lineTo(19f, 5f)
                lineTo(16f, 8f)

                // Bottom loop arrow
                moveTo(19f, 13f)
                verticalLineTo(15f)
                curveTo(19f, 17.2f, 17.2f, 19f, 15f, 19f)
                horizontalLineTo(5f)
                moveTo(8f, 22f)
                lineTo(5f, 19f)
                lineTo(8f, 16f)
            }
        }.build()

    val Share: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramShare",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 1.8f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(22f, 2.5f)
                lineTo(11.5f, 13f)
                moveTo(22f, 2.5f)
                lineTo(15.5f, 21.5f)
                curveTo(15.35f, 21.9f, 14.8f, 21.95f, 14.55f, 21.6f)
                lineTo(10.8f, 14f)
                lineTo(2.7f, 10.25f)
                curveTo(2.35f, 10f, 2.4f, 9.45f, 2.8f, 9.3f)
                lineTo(22f, 2.5f)
                close()
            }
        }.build()

    val Bookmark: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramBookmark",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 1.8f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(5.5f, 3f)
                horizontalLineTo(18.5f)
                curveTo(19.3f, 3f, 20f, 3.7f, 20f, 4.5f)
                verticalLineTo(21.5f)
                lineTo(12f, 16.5f)
                lineTo(4f, 21.5f)
                verticalLineTo(4.5f)
                curveTo(4f, 3.7f, 4.7f, 3f, 5.5f, 3f)
                close()
            }
        }.build()

    val BookmarkFilled: ImageVector
        get() = ImageVector.Builder(
            name = "InstagramBookmarkFilled",
            defaultWidth = AppDimensions.dp(24),
            defaultHeight = AppDimensions.dp(24),
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(5.5f, 3f)
                horizontalLineTo(18.5f)
                curveTo(19.3f, 3f, 20f, 3.7f, 20f, 4.5f)
                verticalLineTo(21.5f)
                lineTo(12f, 16.5f)
                lineTo(4f, 21.5f)
                verticalLineTo(4.5f)
                curveTo(4f, 3.7f, 4.7f, 3f, 5.5f, 3f)
                close()
            }
        }.build()
}
