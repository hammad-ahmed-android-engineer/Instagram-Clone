package com.example.instagramclone.core.designsystem.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AccentColor
import com.example.instagramclone.core.designsystem.theme.IconDark

/**
 * Replicated from CC-Instagram CustomRaisedButton.kt
 * Renamed to InstagramPrimaryButton with scalable AppDimensions sizing.
 */
@Composable
fun InstagramPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = AccentColor,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(size = AppDimensions.radiusMicro),
        onClick = onClick
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = IconDark,
                modifier = Modifier.size(AppDimensions.iconMedium),
                strokeWidth = AppDimensions.borderMedium
            )
        } else {
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge.copy(fontSize = AppDimensions.textMedium),
                color = Color.White,
                modifier = Modifier.padding(vertical = AppDimensions.spacingTiny)
            )
        }
    }
}
