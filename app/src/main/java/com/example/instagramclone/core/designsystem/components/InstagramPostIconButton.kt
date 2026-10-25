package com.example.instagramclone.core.designsystem.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions

/**
 * Replicated from CC-Instagram PostIconButton.kt
 * Instagram action button with ripple and scalable dimensions (sdp).
 */
@Composable
fun InstagramPostIconButton(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = modifier
            .clickable(
                interactionSource = interactionSource,
                indication = ripple(bounded = false, radius = AppDimensions.iconLarge),
                onClick = onClick
            )
            .padding(vertical = AppDimensions.spacingSmall, horizontal = AppDimensions.spacingMicro)
            .size(AppDimensions.iconLarge),
        contentAlignment = Alignment.Center
    ) {
        icon()
    }
}
