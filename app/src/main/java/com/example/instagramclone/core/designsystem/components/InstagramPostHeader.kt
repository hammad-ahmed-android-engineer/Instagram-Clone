package com.example.instagramclone.core.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.data.model.User

/**
 * Replicated from CC-Instagram PostUi.kt (PostHeader)
 * Renamed to InstagramPostHeader with scalable AppDimensions sizing.
 */
@Composable
fun InstagramPostHeader(
    author: User,
    onOptionsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = AppDimensions.spacingMedium, vertical = AppDimensions.spacingSmall),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            UserAvatar(
                imageUrl = author.profilePicUrl,
                size = AppDimensions.storyAvatarSmall,
                hasStory = true
            )
            Spacer(modifier = Modifier.width(AppDimensions.spacingSmall))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = author.username,
                    style = AppTypography.caption.copy(
                        fontSize = AppDimensions.textSmall,
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )
                if (author.isVerified) {
                    Spacer(modifier = Modifier.width(AppDimensions.spacingTiny))
                    Icon(
                        imageVector = InstagramIcons.VerifiedBadge,
                        contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_verified),
                        tint = Color.Unspecified,
                        modifier = Modifier.size(AppDimensions.badgeSize)
                    )
                }
            }
        }

        // Horizontal 3-Dots Menu with InstagramPostIconButton
        InstagramPostIconButton(onClick = onOptionsClick) {
            Icon(
                imageVector = InstagramIcons.MoreHorizontal,
                contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_options),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
