package com.example.instagramclone.feature.feed.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.example.instagramclone.core.designsystem.components.UserAvatar
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.data.model.StoryGroup

/**
 * Segregated InstagramStoryItem component displaying friend's story ring with username.
 * Scaled dynamically with AppDimensions.
 */
@Composable
fun InstagramStoryItem(
    storyGroup: StoryGroup,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(AppDimensions.storyAvatarLarge)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
    ) {
        UserAvatar(
            imageUrl = storyGroup.author.profilePicUrl,
            size = AppDimensions.storyAvatarLarge,
            hasStory = true,
            isStoryViewed = !storyGroup.hasUnviewed
        )

        Spacer(modifier = Modifier.height(AppDimensions.spacingTiny))

        Text(
            text = storyGroup.author.username,
            style = AppTypography.caption.copy(fontSize = AppDimensions.textSmall),
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}
