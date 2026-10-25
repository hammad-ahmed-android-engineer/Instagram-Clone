package com.example.instagramclone.feature.messaging.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.instagramclone.core.designsystem.components.UserAvatar
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.data.dummy.DummyData

/**
 * Segregated Instagram notes bubble tray in DM screen.
 * Displays "Share a thought..." along with friends' active status notes.
 * Scaled dynamically with AppDimensions.
 */
@Composable
fun InstagramNotesRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = AppDimensions.spacingMedium),
        horizontalArrangement = Arrangement.spacedBy(AppDimensions.spacingDefault),
        modifier = modifier.padding(vertical = AppDimensions.spacingSmall)
    ) {
        // "Leave a note" user bubble
        item {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(AppDimensions.radiusMedium))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(horizontal = AppDimensions.spacingSmall, vertical = AppDimensions.spacingTiny)
                ) {
                    Text(
                        text = stringResource(id = com.example.instagramclone.R.string.dm_share_thought),
                        style = AppTypography.caption.copy(fontSize = AppDimensions.textCaption),
                        color = MaterialTheme.colorScheme.outline
                    )
                }
                Spacer(modifier = Modifier.height(AppDimensions.spacingTiny))
                UserAvatar(
                    imageUrl = DummyData.users[0].profilePicUrl,
                    size = AppDimensions.profileAvatarMedium,
                    hasStory = false
                )
                Spacer(modifier = Modifier.height(AppDimensions.spacingTiny))
                Text(
                    text = stringResource(id = com.example.instagramclone.R.string.dm_your_note),
                    style = AppTypography.caption.copy(fontSize = AppDimensions.textSmall),
                    color = MaterialTheme.colorScheme.outline
                )
            }
        }

        // Friends with notes
        items(DummyData.users.drop(1)) { user ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(AppDimensions.radiusMedium))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(horizontal = AppDimensions.spacingSmall, vertical = AppDimensions.spacingTiny)
                ) {
                    Text(
                        text = "Listening to music 🎵",
                        style = AppTypography.caption.copy(fontSize = AppDimensions.textCaption),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                Spacer(modifier = Modifier.height(AppDimensions.spacingTiny))
                UserAvatar(
                    imageUrl = user.profilePicUrl,
                    size = AppDimensions.profileAvatarMedium,
                    hasStory = true
                )
                Spacer(modifier = Modifier.height(AppDimensions.spacingTiny))
                Text(
                    text = user.username,
                    style = AppTypography.caption.copy(fontSize = AppDimensions.textSmall),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}
