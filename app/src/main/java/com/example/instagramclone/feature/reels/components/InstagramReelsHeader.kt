package com.example.instagramclone.feature.reels.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.instagramclone.core.designsystem.components.InstagramIcons
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.R

/**
 * Matching official Instagram Reels top section from screenshot 2:
 * - Left "+" create icon
 * - Center "Reels ∨" title with dropdown chevron
 * - Right tune / mixer controls icon
 * - Top soft gradient vignette
 */
@Composable
fun InstagramReelsHeader(
    modifier: Modifier = Modifier,
    onCreateClick: () -> Unit = {},
    onTuneClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Black.copy(alpha = 0.65f),
                        Color.Transparent
                    )
                )
            )
            .padding(horizontal = AppDimensions.spacingMedium, vertical = AppDimensions.spacingSmall)
    ) {
        // Left "+" create icon
        Icon(
            imageVector = InstagramIcons.Create,
            contentDescription = stringResource(id = R.string.cd_create),
            tint = Color.White,
            modifier = Modifier
                .size(AppDimensions.iconLarge)
                .align(Alignment.CenterStart)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onCreateClick
                )
        )

        // Center "Reels ∨"
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = {}
                )
        ) {
            Text(
                text = stringResource(id = R.string.reels_title),
                style = AppTypography.pageTitle.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = AppDimensions.textHeadline
                )
            )
            Spacer(modifier = Modifier.width(AppDimensions.spacingTiny))
            Icon(
                imageVector = InstagramIcons.DropdownCaret,
                contentDescription = stringResource(id = R.string.cd_reels_menu),
                tint = Color.White,
                modifier = Modifier.size(AppDimensions.iconTiny)
            )
        }

        // Right tune / settings icon
        Icon(
            imageVector = InstagramIcons.TuneSliders,
            contentDescription = stringResource(id = R.string.cd_tune),
            tint = Color.White,
            modifier = Modifier
                .size(AppDimensions.iconLarge)
                .align(Alignment.CenterEnd)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onTuneClick
                )
        )
    }
}
