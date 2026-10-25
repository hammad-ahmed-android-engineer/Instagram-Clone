package com.example.instagramclone.feature.profile.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions

/**
 * Replicated from CC-Instagram Profile.kt (ProfileStat)
 * Renamed to InstagramProfileStat with scalable AppDimensions sizing.
 */
@Composable
fun InstagramProfileStat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = onClick
        )
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = AppDimensions.textLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(AppDimensions.spacingMicro))
        Text(
            text = text,
            fontSize = AppDimensions.textCaption,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
