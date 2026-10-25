package com.example.instagramclone.feature.profile.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions

/**
 * Replicated from CC-Instagram Profile.kt (ActionButton)
 * Renamed to InstagramActionButton with scalable AppDimensions sizing.
 */
@Composable
fun InstagramActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null,
    onClick: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = AppDimensions.borderThin,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(AppDimensions.radiusSmall)
            )
            .clickable(onClick = onClick)
            .padding(vertical = AppDimensions.spacingSmall, horizontal = AppDimensions.spacingMedium)
    ) {
        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = AppDimensions.textMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.size(AppDimensions.iconSmall)
            )
        }
    }
}
