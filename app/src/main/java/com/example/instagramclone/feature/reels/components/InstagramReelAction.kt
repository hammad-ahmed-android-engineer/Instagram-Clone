package com.example.instagramclone.feature.reels.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.Modifier
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions

/**
 * Replicated from CC-Instagram Reels.kt (UserAction & UserActionWithText)
 * Renamed to InstagramReelAction with scalable AppDimensions sizing.
 */
@Composable
fun InstagramReelAction(
    imageVector: ImageVector,
    contentDescription: String? = null,
    tint: Color = Color.White,
    onClick: () -> Unit = {}
) {
    Icon(
        imageVector = imageVector,
        tint = tint,
        modifier = Modifier
            .size(AppDimensions.iconMedium)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        contentDescription = contentDescription
    )
}

@Composable
fun InstagramReelActionMetric(
    imageVector: ImageVector,
    text: String,
    contentDescription: String? = null,
    tint: Color = Color.White,
    onClick: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = onClick
        )
    ) {
        Icon(
            imageVector = imageVector,
            tint = tint,
            modifier = Modifier.size(AppDimensions.iconSmall),
            contentDescription = contentDescription
        )
        Spacer(modifier = Modifier.width(AppDimensions.spacingTiny))
        Text(
            text = text,
            color = Color.White,
            style = MaterialTheme.typography.bodySmall.copy(fontSize = AppDimensions.textSmall)
        )
    }
}
