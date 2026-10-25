package com.example.instagramclone.core.designsystem.dimensions

import androidx.annotation.DimenRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.intuit.sdp.R.dimen as sdp
import com.intuit.ssp.R.dimen as ssp

/*
 * ─────────────────────────────────────────────────────────────────────────────
 * Planora design tokens (sizes)
 * ─────────────────────────────────────────────────────────────────────────────
 *
 * Single source of truth for every size used in the UI: spacing, corner radii,
 * icon sizes, component sizes, borders, elevation and text sizes.
 */

// region Token groups

/** Gaps between elements: padding, margins and arrangement spacing. */
@Immutable
data class Spacing(
    val zero: Dp,
    val micro: Dp,
    val tiny: Dp,
    val small: Dp,
    val medium: Dp,
    val default: Dp,
    val large: Dp,
    val extraLarge: Dp,
)

/** Corner radii for shapes (cards, buttons, sheets, chips). */
@Immutable
data class Corners(
    val micro: Dp,
    val small: Dp,
    val medium: Dp,
    val large: Dp,
    val extraLarge: Dp,
    /** Fully rounded ends, e.g. pill-shaped buttons and search bars. */
    val pill: Dp,
)

/** Icon sizes, from small inline glyphs up to large illustrative icons. */
@Immutable
data class IconSizes(
    val micro: Dp,
    val tiny: Dp,
    val small: Dp,
    val medium: Dp,
    val large: Dp,
    val extraLarge: Dp,
    val huge: Dp,
)

/** Fixed sizes of specific reusable components. */
@Immutable
data class ComponentSizes(
    val buttonHeight: Dp,
    val buttonSmallHeight: Dp,
    val searchBarHeight: Dp,
    val dialogPadding: Dp,
    val fab: Dp,
    val avatar: Dp,
    val emptyStateIconContainer: Dp,
    val colorPickerCircle: Dp,
)

/** Stroke widths for outlines and dividers. */
@Immutable
data class Borders(
    val thin: Dp,
    val medium: Dp,
    val thick: Dp,
)

/** Shadow elevation levels. */
@Immutable
data class Elevations(
    val none: Dp,
    val low: Dp,
    val medium: Dp,
    val high: Dp,
)

/**
 * General-purpose text sizes for ad-hoc use.
 * For standard text, prefer the Material roles in [TypeScale] (via AppTypography).
 */
@Immutable
data class TextSizes(
    val caption: TextUnit,
    val small: TextUnit,
    val medium: TextUnit,
    val large: TextUnit,
    val title: TextUnit,
    val headline: TextUnit,
    val display: TextUnit,
)

/** Font size and line height for a single typography role. Both scale with SSP. */
@Immutable
data class TypeMetric(
    val fontSize: TextUnit,
    val lineHeight: TextUnit,
)

/**
 * Sizes for every Material 3 type role (display, headline, title, body, label).
 * AppTypography combines these with weights and letter spacing to build the
 * theme's `Typography`, so text sizes are defined only here.
 */
@Immutable
data class TypeScale(
    val displayLarge: TypeMetric,
    val displayMedium: TypeMetric,
    val displaySmall: TypeMetric,
    val headlineLarge: TypeMetric,
    val headlineMedium: TypeMetric,
    val headlineSmall: TypeMetric,
    val titleLarge: TypeMetric,
    val titleMedium: TypeMetric,
    val titleSmall: TypeMetric,
    val bodyLarge: TypeMetric,
    val bodyMedium: TypeMetric,
    val bodySmall: TypeMetric,
    val labelLarge: TypeMetric,
    val labelMedium: TypeMetric,
    val labelSmall: TypeMetric,
)

/**
 * Root container holding every token group.
 * It is immutable, so Compose can skip recomposition when it hasn't changed.
 */
@Immutable
data class Dimensions(
    val spacing: Spacing,
    val corners: Corners,
    val icons: IconSizes,
    val components: ComponentSizes,
    val borders: Borders,
    val elevations: Elevations,
    val textSizes: TextSizes,
    val typeScale: TypeScale,
)

// endregion

// region Resolution

@Composable
@ReadOnlyComposable
private fun sspResource(@DimenRes id: Int): TextUnit =
    with(LocalDensity.current) { dimensionResource(id).toSp() }

@Composable
@ReadOnlyComposable
private fun typeMetric(@DimenRes fontSize: Int, @DimenRes lineHeight: Int) =
    TypeMetric(sspResource(fontSize), sspResource(lineHeight))

@Composable
@ReadOnlyComposable
fun resolveDimensions(): Dimensions = Dimensions(
    spacing = Spacing(
        zero = 0.dp,
        micro = dimensionResource(sdp._1sdp),
        tiny = dimensionResource(sdp._3sdp),
        small = dimensionResource(sdp._6sdp),
        medium = dimensionResource(sdp._10sdp),
        default = dimensionResource(sdp._14sdp),
        large = dimensionResource(sdp._20sdp),
        extraLarge = dimensionResource(sdp._28sdp),
    ),
    corners = Corners(
        micro = dimensionResource(sdp._3sdp),
        small = dimensionResource(sdp._6sdp),
        medium = dimensionResource(sdp._10sdp),
        large = dimensionResource(sdp._14sdp),
        extraLarge = dimensionResource(sdp._18sdp),
        pill = dimensionResource(sdp._24sdp),
    ),
    icons = IconSizes(
        micro = dimensionResource(sdp._8sdp),
        tiny = dimensionResource(sdp._10sdp),
        small = dimensionResource(sdp._14sdp),
        medium = dimensionResource(sdp._18sdp),
        large = dimensionResource(sdp._22sdp),
        extraLarge = dimensionResource(sdp._30sdp),
        huge = dimensionResource(sdp._42sdp),
    ),
    components = ComponentSizes(
        buttonHeight = dimensionResource(sdp._40sdp),
        buttonSmallHeight = dimensionResource(sdp._30sdp),
        searchBarHeight = dimensionResource(sdp._38sdp),
        dialogPadding = dimensionResource(sdp._20sdp),
        fab = dimensionResource(sdp._50sdp),
        avatar = dimensionResource(sdp._36sdp),
        emptyStateIconContainer = dimensionResource(sdp._62sdp),
        colorPickerCircle = dimensionResource(sdp._36sdp),
    ),
    borders = Borders(
        thin = dimensionResource(sdp._1sdp),
        medium = dimensionResource(sdp._2sdp),
        thick = dimensionResource(sdp._3sdp),
    ),
    elevations = Elevations(
        none = 0.dp,
        low = dimensionResource(sdp._1sdp),
        medium = dimensionResource(sdp._3sdp),
        high = dimensionResource(sdp._6sdp),
    ),
    textSizes = TextSizes(
        caption = sspResource(ssp._9ssp),
        small = sspResource(ssp._11ssp),
        medium = sspResource(ssp._13ssp),
        large = sspResource(ssp._15ssp),
        title = sspResource(ssp._17ssp),
        headline = sspResource(ssp._20ssp),
        display = sspResource(ssp._26ssp),
    ),
    typeScale = TypeScale(
        displayLarge = typeMetric(ssp._28ssp, ssp._36ssp),
        displayMedium = typeMetric(ssp._24ssp, ssp._32ssp),
        displaySmall = typeMetric(ssp._22ssp, ssp._28ssp),
        headlineLarge = typeMetric(ssp._20ssp, ssp._26ssp),
        headlineMedium = typeMetric(ssp._18ssp, ssp._24ssp),
        headlineSmall = typeMetric(ssp._16ssp, ssp._22ssp),
        titleLarge = typeMetric(ssp._16ssp, ssp._22ssp),
        titleMedium = typeMetric(ssp._14ssp, ssp._20ssp),
        titleSmall = typeMetric(ssp._12ssp, ssp._16ssp),
        bodyLarge = typeMetric(ssp._14ssp, ssp._20ssp),
        bodyMedium = typeMetric(ssp._12ssp, ssp._16ssp),
        bodySmall = typeMetric(ssp._11ssp, ssp._15ssp),
        labelLarge = typeMetric(ssp._12ssp, ssp._16ssp),
        labelMedium = typeMetric(ssp._11ssp, ssp._15ssp),
        labelSmall = typeMetric(ssp._9ssp, ssp._13ssp),
    ),
)

// endregion

// region Theme access

val LocalDimensions = staticCompositionLocalOf<Dimensions> {
    error("Dimensions not provided. Wrap your content in PlanoraTheme.")
}

val MaterialTheme.dimensions: Dimensions
    @Composable
    @ReadOnlyComposable
    get() = LocalDimensions.current

// endregion

/**
 * Global AppDimensions object accessor for static/composable dimension convenience.
 */
object AppDimensions {
    // Spacing
    val spacingZero: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.spacing.zero
    val spacingMicro: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.spacing.micro
    val spacingTiny: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.spacing.tiny
    val spacingSmall: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.spacing.small
    val spacingMedium: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.spacing.medium
    val spacingDefault: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.spacing.default
    val spacingLarge: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.spacing.large
    val spacingExtraLarge: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.spacing.extraLarge

    // Corners & Radii
    val radiusMicro: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.corners.micro
    val radiusSmall: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.corners.small
    val radiusMedium: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.corners.medium
    val radiusLarge: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.corners.large
    val radiusExtraLarge: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.corners.extraLarge
    val radiusPill: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.corners.pill

    // Icon Sizes
    val iconMicro: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.icons.micro
    val iconTiny: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.icons.tiny
    val iconSmall: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.icons.small
    val iconMedium: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.icons.medium
    val iconLarge: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.icons.large
    val iconExtraLarge: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.icons.extraLarge
    val iconHuge: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.icons.huge

    // Component Sizes
    val profileAvatarSmall: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.components.avatar
    val profileAvatarMedium: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.components.avatar
    val profileAvatarLarge: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.components.emptyStateIconContainer
    val buttonHeight: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.components.buttonHeight
    val buttonSmallHeight: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.components.buttonSmallHeight
    val searchBarHeight: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.components.searchBarHeight
    val dialogPadding: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.components.dialogPadding

    // Borders & Elevations
    val borderThin: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.borders.thin
    val borderMedium: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.borders.medium
    val borderThick: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.borders.thick

    val elevationNone: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.elevations.none
    val elevationLow: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.elevations.low
    val elevationMedium: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.elevations.medium
    val elevationHigh: Dp @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.elevations.high

    // Text Sizes
    val textCaption: TextUnit @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.textSizes.caption
    val textSmall: TextUnit @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.textSizes.small
    val textMedium: TextUnit @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.textSizes.medium
    val textLarge: TextUnit @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.textSizes.large
    val textTitle: TextUnit @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.textSizes.title
    val textHeadline: TextUnit @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.textSizes.headline
    val textDisplay: TextUnit @Composable @ReadOnlyComposable get() = MaterialTheme.dimensions.textSizes.display

    // Story & Avatar Tokens
    val storyAvatarLarge: Dp @Composable @ReadOnlyComposable get() = dimensionResource(sdp._64sdp)
    val storyAvatarMedium: Dp @Composable @ReadOnlyComposable get() = dimensionResource(sdp._56sdp)
    val storyAvatarSmall: Dp @Composable @ReadOnlyComposable get() = dimensionResource(sdp._32sdp)
    val storyRingBorder: Dp @Composable @ReadOnlyComposable get() = dimensionResource(sdp._2sdp)
    val storyRingGap: Dp @Composable @ReadOnlyComposable get() = dimensionResource(sdp._2sdp)

    // Layout & Navigation Tokens
    val maxContentWidth: Dp = 400.dp
    val maxGridWidth: Dp = 640.dp
    val bottomNavHeight: Dp @Composable @ReadOnlyComposable get() = dimensionResource(sdp._46sdp)
    val topBarHeight: Dp @Composable @ReadOnlyComposable get() = dimensionResource(sdp._44sdp)
    val tabHeight: Dp @Composable @ReadOnlyComposable get() = dimensionResource(sdp._40sdp)
    val badgeSize: Dp @Composable @ReadOnlyComposable get() = dimensionResource(sdp._12sdp)
    val dividerThickness: Dp = 1.dp
    val likeOverlayHeart: Dp @Composable @ReadOnlyComposable get() = dimensionResource(sdp._88sdp)

    // Direct token helpers to replace raw 10.sdp, 14.sdp, 11.5.ssp, etc. cleanly
    fun dp(value: Int): Dp = value.dp
}

// Convenient extension properties mapping common raw .sdp / .ssp to AppDimensions tokens
val MaterialTheme.dimens: Dimensions
    @Composable
    @ReadOnlyComposable
    get() = LocalDimensions.current
