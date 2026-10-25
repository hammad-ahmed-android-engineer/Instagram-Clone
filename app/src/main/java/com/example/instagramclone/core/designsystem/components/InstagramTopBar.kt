package com.example.instagramclone.core.designsystem.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.R

/**
 * Authentic Instagram cursive script wordmark.
 */
@Composable
fun InstagramWordmark(
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = R.string.title_instagram),
        style = TextStyle(
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            fontSize = AppDimensions.textHeadline,
            color = MaterialTheme.colorScheme.onBackground,
            letterSpacing = 0.5.sp
        ),
        modifier = modifier
    )
}

/**
 * Standard top application bar matching official Instagram design specs.
 * Supports:
 * - Centered branded Instagram wordmark (as seen on modern Instagram Feed)
 * - Leading icon slot (such as "+" create on modern feed)
 * - Trailing actions slot (such as Heart notifications with red dot, DMs, etc.)
 * Scaled dynamically with AppDimensions across portrait and landscape orientations.
 */
@Composable
fun InstagramTopBar(
    title: String,
    modifier: Modifier = Modifier,
    isBrandedTitle: Boolean = false,
    isCenteredTitle: Boolean = false,
    onBackClick: (() -> Unit)? = null,
    navigationIcon: (@Composable () -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(AppDimensions.tabHeight),
        color = MaterialTheme.colorScheme.background
    ) {
        if (isCenteredTitle && isBrandedTitle) {
            // Instagram Modern Feed Top Bar: Left Action (+), Centered Wordmark, Right Action (Heart)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AppDimensions.spacingMedium),
                contentAlignment = Alignment.Center
            ) {
                // Centered Instagram Wordmark
                InstagramWordmark()

                // Left & Right Row overlay
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Left slot
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        if (navigationIcon != null) {
                            navigationIcon()
                        } else if (onBackClick != null) {
                            IconButton(
                                onClick = onBackClick,
                                modifier = Modifier.size(AppDimensions.storyAvatarSmall)
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = stringResource(id = R.string.cd_back),
                                    tint = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier.size(AppDimensions.iconLarge)
                                )
                            }
                        }
                    }

                    // Right slot
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(AppDimensions.spacingDefault)
                    ) {
                        actions()
                    }
                }
            }
        } else {
            // Standard Left-aligned TopBar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AppDimensions.spacingMedium),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Left content (Back button or Title)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f, fill = false)
                ) {
                    if (navigationIcon != null) {
                        navigationIcon()
                        Spacer(modifier = Modifier.width(AppDimensions.spacingSmall))
                    } else if (onBackClick != null) {
                        IconButton(
                            onClick = onBackClick,
                            modifier = Modifier.size(AppDimensions.storyAvatarSmall)
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = stringResource(id = R.string.cd_back),
                                tint = MaterialTheme.colorScheme.onBackground,
                                modifier = Modifier.size(AppDimensions.iconLarge)
                            )
                        }
                        Spacer(modifier = Modifier.width(AppDimensions.spacingSmall))
                    }

                    if (isBrandedTitle) {
                        // Instagram Wordmark with Dropdown Chevron
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = {}
                            )
                        ) {
                            InstagramWordmark()
                            Spacer(modifier = Modifier.width(AppDimensions.spacingTiny))
                            Icon(
                                imageVector = InstagramIcons.DropdownCaret,
                                contentDescription = stringResource(id = R.string.cd_feed_switcher),
                                tint = MaterialTheme.colorScheme.onBackground,
                                modifier = Modifier.size(AppDimensions.badgeSize)
                            )
                        }
                    } else {
                        Text(
                            text = title,
                            style = AppTypography.pageTitle,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }

                // Right Actions
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(AppDimensions.spacingDefault)
                ) {
                    actions()
                }
            }
        }
    }
}
