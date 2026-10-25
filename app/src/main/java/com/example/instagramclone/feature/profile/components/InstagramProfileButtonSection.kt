package com.example.instagramclone.feature.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.R

/**
 * Replicated from CC-Instagram Profile.kt (ButtonSection)
 * Renamed to InstagramProfileButtonSection with scalable AppDimensions sizing.
 */
@Composable
fun InstagramProfileButtonSection(
    modifier: Modifier = Modifier,
    onEditProfileClick: () -> Unit = {},
    onShareProfileClick: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(AppDimensions.spacingSmall),
        modifier = modifier.fillMaxWidth()
    ) {
        InstagramActionButton(
            text = stringResource(id = R.string.profile_btn_edit),
            modifier = Modifier.weight(1f),
            onClick = onEditProfileClick
        )
        InstagramActionButton(
            text = stringResource(id = R.string.profile_btn_share),
            modifier = Modifier.weight(1f),
            onClick = onShareProfileClick
        )
    }
}
