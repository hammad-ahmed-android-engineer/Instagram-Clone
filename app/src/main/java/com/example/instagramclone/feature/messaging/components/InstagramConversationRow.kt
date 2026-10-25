package com.example.instagramclone.feature.messaging.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.instagramclone.core.designsystem.components.UserAvatar
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.core.designsystem.theme.BluePrimary
import com.example.instagramclone.feature.messaging.ChatConversation

/**
 * Segregated Instagram direct message conversation row displaying avatar,
 * username, snippet preview, timestamp, unread indicator, and camera shortcut.
 * Scaled dynamically with AppDimensions.
 */
@Composable
fun InstagramConversationRow(
    chat: ChatConversation,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = AppDimensions.spacingMedium, vertical = AppDimensions.spacingSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        UserAvatar(
            imageUrl = chat.user.profilePicUrl,
            size = AppDimensions.profileAvatarMedium,
            hasStory = true
        )
        Spacer(modifier = Modifier.width(AppDimensions.spacingMedium))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = chat.user.username,
                style = AppTypography.username.copy(
                    fontSize = AppDimensions.textMedium
                ),
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(AppDimensions.spacingMicro))
            Text(
                text = "${chat.lastMessage} • ${chat.timestamp}",
                style = AppTypography.caption.copy(
                    color = if (chat.isUnread) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.outline
                ),
                maxLines = 1
            )
        }

        // Unread blue dot or Camera shortcut
        if (chat.isUnread) {
            Box(
                modifier = Modifier
                    .size(AppDimensions.spacingSmall)
                    .clip(CircleShape)
                    .background(BluePrimary)
            )
            Spacer(modifier = Modifier.width(AppDimensions.spacingDefault))
        }

        Icon(
            imageVector = Icons.Outlined.PhotoCamera,
            contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_camera),
            tint = MaterialTheme.colorScheme.outline,
            modifier = Modifier.size(AppDimensions.iconLarge)
        )
    }
}
