package com.example.instagramclone.core.designsystem.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// CC-Instagram exact color tokens
val AccentColor = Color(0xFF3797EF) // Instagram primary action blue
val FormFieldBgDark = Color(0xFF121212)
val FormFieldBgLight = Color(0xFFFAFAFA)
val FormFieldBorderLight = Color(0x1A000000)
val FormFieldBorderDark = Color(0x33FFFFFF)
val IconDark = Color(0xFFF9F9F9)
val IconLight = Color(0xFF262626)
val LightGray = Color.Gray.copy(alpha = 0.7f)
val LineColor = Color.Gray.copy(alpha = 0.2f)

// Light Theme Colors (Instagram exact)
val md_theme_light_primary = Color(0xFF000000)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_secondary = Color(0xFF262626)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_error = Color(0xFFED4956)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_background = Color(0xFFFFFFFF)
val md_theme_light_onBackground = Color(0xFF000000)
val md_theme_light_surface = Color(0xFFFFFFFF)
val md_theme_light_onSurface = Color(0xFF000000)
val md_theme_light_outline = Color(0xFFDBDBDB) // Instagram hairline border
val md_theme_light_surfaceVariant = Color(0xFFEFEFEF) // Button & search bar fill
val md_theme_light_onSurfaceVariant = Color(0xFF262626)

// Dark Theme Colors (Instagram AMOLED pitch black)
val md_theme_dark_primary = Color(0xFFFFFFFF)
val md_theme_dark_onPrimary = Color(0xFF000000)
val md_theme_dark_secondary = Color(0xFFF5F5F5)
val md_theme_dark_onSecondary = Color(0xFF000000)
val md_theme_dark_error = Color(0xFFED4956)
val md_theme_dark_onError = Color(0xFFFFFFFF)
val md_theme_dark_background = Color(0xFF000000)
val md_theme_dark_onBackground = Color(0xFFF5F5F5)
val md_theme_dark_surface = Color(0xFF000000)
val md_theme_dark_onSurface = Color(0xFFF5F5F5)
val md_theme_dark_outline = Color(0xFF262626) // Dark mode hairline divider
val md_theme_dark_surfaceVariant = Color(0xFF1E1E1E) // Dark mode button & input fill
val md_theme_dark_onSurfaceVariant = Color(0xFFF5F5F5)

// App specific colors
val BluePrimary = AccentColor
val RedLike = Color(0xFFED4956) // Instagram heart red
val TextSecondaryLight = Color(0xFF737373)
val TextSecondaryDark = Color(0xFFA8A8A8)
val StoryViewedGrayLight = Color(0xFFDBDBDB)
val StoryViewedGrayDark = Color(0xFF363636)

val InstagramSunsetColors = listOf(
    Color(0xFFD71069),
    Color(0xFFE25D6A),
    Color(0xFFE9AD55)
)

val InstagramStoryBrush = Brush.linearGradient(colors = InstagramSunsetColors)
