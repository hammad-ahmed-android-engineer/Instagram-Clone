package com.example.instagramclone.feature.explore.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.instagramclone.core.designsystem.components.InstagramIcons
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.R

/**
 * Iridescent Meta AI circular gradient ring icon matching modern Instagram search.
 */
@Composable
fun MetaAiRingIcon(
    modifier: Modifier = Modifier
) {
    val strokeWidthDp = AppDimensions.borderMedium
    Canvas(modifier = modifier) {
        val strokeWidth = strokeWidthDp.toPx()
        val brush = Brush.sweepGradient(
            colors = listOf(
                Color(0xFF0064E0), // Meta Blue
                Color(0xFF7000FF), // Meta Purple
                Color(0xFFF8007A), // Meta Pink
                Color(0xFF00C6FF), // Cyan
                Color(0xFF0064E0)  // Meta Blue
            )
        )
        drawCircle(
            brush = brush,
            radius = (size.minDimension - strokeWidth) / 2f,
            style = Stroke(width = strokeWidth)
        )
    }
}

/**
 * Modern Instagram Explore search bar replicating the authentic UI:
 * - Rounded pill container with Meta AI iridescent ring and "Search with Meta AI" placeholder
 * - Save / Bookmark icon to the right of the search pill
 * - Horizontal scrolling category chips (Tune sliders, "For you", "Wedding planning", "Relationship humor", etc.)
 */
@Composable
fun InstagramExploreSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = stringResource(id = R.string.search_with_meta_ai),
    showMetaAi: Boolean = true,
    showBookmark: Boolean = true,
    isSaved: Boolean = false,
    onBookmarkClick: () -> Unit = {},
    showFilterChips: Boolean = true,
    filterChips: List<String> = listOf(
        "For you",
        "Wedding planning",
        "Relationship humor",
        "Architecture",
        "Travel",
        "Food & Drink",
        "Style",
        "Art"
    ),
    selectedChip: String = "For you",
    onChipClick: (String) -> Unit = {},
    onFilterClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = AppDimensions.spacingSmall)
    ) {
        // Top Search Bar Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = AppDimensions.spacingMedium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Pill Search Bar
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(AppDimensions.searchBarHeight)
                    .clip(RoundedCornerShape(AppDimensions.radiusPill))
                    .background(Color(0xFF262626))
                    .padding(horizontal = AppDimensions.spacingMedium),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (showMetaAi) {
                        MetaAiRingIcon(
                            modifier = Modifier.size(AppDimensions.iconSmall)
                        )
                    } else {
                        Icon(
                            imageVector = InstagramIcons.Search,
                            contentDescription = stringResource(id = R.string.cd_search_icon),
                            tint = MaterialTheme.colorScheme.outline,
                            modifier = Modifier.size(AppDimensions.iconSmall)
                        )
                    }

                    Spacer(modifier = Modifier.width(AppDimensions.spacingSmall))

                    Box(modifier = Modifier.weight(1f)) {
                        if (query.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = AppTypography.caption.copy(
                                    color = Color(0xFF9E9E9E),
                                    fontSize = AppDimensions.textSmall
                                )
                            )
                        }

                        BasicTextField(
                            value = query,
                            onValueChange = onQueryChange,
                            singleLine = true,
                            textStyle = AppTypography.caption.copy(
                                color = MaterialTheme.colorScheme.onBackground,
                                fontSize = AppDimensions.textSmall
                            ),
                            cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    if (query.isNotEmpty()) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = stringResource(id = R.string.cd_clear_search),
                            tint = MaterialTheme.colorScheme.outline,
                            modifier = Modifier
                                .size(AppDimensions.iconSmall)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null,
                                    onClick = { onQueryChange("") }
                                )
                        )
                    }
                }
            }

            // Bookmark icon on the right
            if (showBookmark) {
                Spacer(modifier = Modifier.width(AppDimensions.spacingMedium))
                Icon(
                    imageVector = if (isSaved) InstagramIcons.BookmarkFilled else InstagramIcons.Bookmark,
                    contentDescription = stringResource(id = R.string.cd_save),
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .size(AppDimensions.iconLarge)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = onBookmarkClick
                        )
                )
            }
        }

        // Bottom Filter Chips Row
        if (showFilterChips) {
            Spacer(modifier = Modifier.height(AppDimensions.spacingSmall))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = AppDimensions.spacingMedium),
                horizontalArrangement = Arrangement.spacedBy(AppDimensions.spacingSmall),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 1. Filter / Sliders Button
                item {
                    Box(
                        modifier = Modifier
                            .height(AppDimensions.buttonSmallHeight)
                            .clip(RoundedCornerShape(AppDimensions.radiusPill))
                            .background(Color(0xFF1E1E1E))
                            .border(
                                width = AppDimensions.borderThin,
                                color = Color(0xFF333333),
                                shape = RoundedCornerShape(AppDimensions.radiusPill)
                            )
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = onFilterClick
                            )
                            .padding(horizontal = AppDimensions.spacingMedium),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = InstagramIcons.TuneSliders,
                            contentDescription = stringResource(id = R.string.cd_filter_tune),
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.size(AppDimensions.iconSmall)
                        )
                    }
                }

                // 2. Filter Category Pills
                items(filterChips) { chip ->
                    val isSelected = chip == selectedChip
                    val chipBackground = if (isSelected) Color(0xFF383838) else Color(0xFF1E1E1E)
                    val chipBorderColor = if (isSelected) Color(0xFF4F4F4F) else Color(0xFF333333)

                    Box(
                        modifier = Modifier
                            .height(AppDimensions.buttonSmallHeight)
                            .clip(RoundedCornerShape(AppDimensions.radiusPill))
                            .background(chipBackground)
                            .border(
                                width = AppDimensions.borderThin,
                                color = chipBorderColor,
                                shape = RoundedCornerShape(AppDimensions.radiusPill)
                            )
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = { onChipClick(chip) }
                            )
                            .padding(horizontal = AppDimensions.spacingMedium),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = chip,
                            style = AppTypography.caption.copy(
                                fontSize = AppDimensions.textSmall,
                                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Medium
                            ),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            }
        }
    }
}
