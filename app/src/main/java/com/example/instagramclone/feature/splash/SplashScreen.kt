package com.example.instagramclone.feature.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import kotlinx.coroutines.delay

/**
 * Centered Instagram camera logo with vibrant multi-color gradient outline.
 * Yellow -> Orange -> Pink -> Purple -> Blue.
 */
@Composable
fun InstagramGradientCameraIcon(
    modifier: Modifier = Modifier,
    size: Dp = AppDimensions.dp(82)
) {
    Canvas(modifier = modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val strokeWidth = w * 0.082f

        val gradientBrush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFFEDB37), // Yellow
                Color(0xFFF3533A), // Orange-Red
                Color(0xFFE31A76), // Pink
                Color(0xFF9025BE), // Purple
                Color(0xFF5C32E2)  // Blue
            ),
            start = Offset(0f, h),
            end = Offset(w, 0f)
        )

        // 1. Outer rounded squircle outline
        val cornerRadius = CornerRadius(w * 0.28f, h * 0.28f)
        drawRoundRect(
            brush = gradientBrush,
            size = Size(w - strokeWidth, h - strokeWidth),
            topLeft = Offset(strokeWidth / 2f, strokeWidth / 2f),
            cornerRadius = cornerRadius,
            style = Stroke(width = strokeWidth)
        )

        // 2. Center lens circle outline
        val lensRadius = w * 0.22f
        drawCircle(
            brush = gradientBrush,
            radius = lensRadius,
            center = center,
            style = Stroke(width = strokeWidth)
        )

        // 3. Top-right flash dot
        val dotCenter = Offset(w * 0.74f, h * 0.26f)
        val dotRadius = w * 0.055f
        drawCircle(
            brush = gradientBrush,
            radius = dotRadius,
            center = dotCenter
        )
    }
}

/**
 * Meta infinity loop symbol with gradient stroke.
 */
@Composable
fun MetaInfinityLogo(
    modifier: Modifier = Modifier,
    brush: Brush
) {
    val strokeWidthDp = AppDimensions.borderMedium
    Canvas(modifier = modifier.size(width = AppDimensions.dp(22), height = AppDimensions.dp(14))) {
        val w = this.size.width
        val h = this.size.height
        val strokeWidth = strokeWidthDp.toPx()

        val path = Path().apply {
            moveTo(w * 0.5f, h * 0.5f)
            cubicTo(w * 0.35f, h * 0.12f, w * 0.08f, h * 0.12f, w * 0.08f, h * 0.5f)
            cubicTo(w * 0.08f, h * 0.88f, w * 0.35f, h * 0.88f, w * 0.5f, h * 0.5f)
            cubicTo(w * 0.65f, h * 0.12f, w * 0.92f, h * 0.12f, w * 0.92f, h * 0.5f)
            cubicTo(w * 0.92f, h * 0.88f, w * 0.65f, h * 0.88f, w * 0.5f, h * 0.5f)
        }

        drawPath(
            path = path,
            brush = brush,
            style = Stroke(width = strokeWidth)
        )
    }
}

/**
 * Splash screen matching the authentic Instagram cold start screenshot:
 * - Solid dark background (no blurry circles or shades)
 * - Centered Instagram gradient camera logo
 * - Bottom "from" + "Meta" gradient branding
 */
@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(1100)
        onSplashFinished()
    }

    val metaGradientBrush = remember {
        Brush.linearGradient(
            colors = listOf(
                Color(0xFFFF5A00), // Orange / Coral
                Color(0xFFE31A76), // Magenta
                Color(0xFF9025BE)  // Purple
            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        // Centered Gradient Instagram Camera Logo
        InstagramGradientCameraIcon(
            modifier = Modifier.align(Alignment.Center),
            size = AppDimensions.dp(84)
        )

        // Bottom "from Meta" Branding
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = AppDimensions.spacingLarge),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "from",
                style = TextStyle(
                    color = Color(0xFF737373),
                    fontSize = AppDimensions.textCaption,
                    fontWeight = FontWeight.Normal
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                MetaInfinityLogo(brush = metaGradientBrush)

                Spacer(modifier = Modifier.width(AppDimensions.spacingTiny))

                Text(
                    text = "Meta",
                    style = TextStyle(
                        brush = metaGradientBrush,
                        fontWeight = FontWeight.Bold,
                        fontSize = AppDimensions.textMedium,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = (-0.3).sp
                    )
                )
            }
        }
    }
}
