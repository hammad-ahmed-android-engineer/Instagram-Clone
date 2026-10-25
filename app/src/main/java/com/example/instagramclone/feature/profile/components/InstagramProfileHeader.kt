package com.example.instagramclone.feature.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.example.instagramclone.core.designsystem.components.HighlightItem
import com.example.instagramclone.core.designsystem.components.UserAvatar
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.data.model.User

/**
 * Segregated InstagramProfileHeader component composed of:
 * - Avatar + InstagramStatSection
 * - InstagramProfileBioSection
 * - Highlights tray with story rings and "+ New" addition button
 * Scaled dynamically with AppDimensions.
 */
@Composable
fun InstagramProfileHeader(
    user: User,
    postsCount: Int,
    followersCount: Int = 1250,
    followingCount: Int = 420,
    modifier: Modifier = Modifier
) {
    val sampleHighlights = listOf(
        HighlightItem("1", "Travel", "https://picsum.photos/id/1015/200/200"),
        HighlightItem("2", "Food", "https://picsum.photos/id/1080/200/200"),
        HighlightItem("3", "Fitness", "https://picsum.photos/id/1025/200/200"),
        HighlightItem("4", "Tech", "https://picsum.photos/id/1060/200/200")
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = AppDimensions.spacingMedium,
                end = AppDimensions.spacingMedium,
                top = AppDimensions.spacingLarge,
                bottom = AppDimensions.spacingSmall
            )
    ) {
        // Avatar + Stats Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(contentAlignment = Alignment.TopCenter) {
                UserAvatar(
                    imageUrl = user.profilePicUrl,
                    size = AppDimensions.storyAvatarLarge,
                    hasStory = true
                )

                // "Ask friends anything..." Note bubble with adequate headroom and contrast
                Box(
                    modifier = Modifier
                        .offset(y = -AppDimensions.spacingMedium)
                        .clip(RoundedCornerShape(AppDimensions.radiusMedium))
                        .background(Color(0xFF262626))
                        .border(AppDimensions.borderThin, Color(0xFF383838), RoundedCornerShape(AppDimensions.radiusMedium))
                        .padding(horizontal = AppDimensions.spacingSmall, vertical = AppDimensions.spacingMicro)
                ) {
                    Text(
                        text = "Ask friends anything...",
                        style = AppTypography.caption.copy(
                            fontSize = AppDimensions.textCaption,
                            color = Color.White.copy(alpha = 0.9f)
                        ),
                        maxLines = 1
                    )
                }
            }

            InstagramStatSection(
                postsCount = postsCount.toString(),
                followersCount = "$followersCount",
                followingCount = "$followingCount",
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(AppDimensions.spacingSmall))

        // Bio section & Action buttons
        InstagramProfileBioSection(
            fullName = user.fullName,
            bioText = "",
            onEditProfileClick = { /* Edit profile */ }
        )

        Spacer(modifier = Modifier.height(AppDimensions.spacingDefault))

        // Highlights Row with "+ New" Add Circle
        LazyRow(
            contentPadding = PaddingValues(horizontal = AppDimensions.spacingZero),
            horizontalArrangement = Arrangement.spacedBy(AppDimensions.spacingDefault)
        ) {
            items(sampleHighlights, key = { it.id }) { highlight ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.width(AppDimensions.storyAvatarMedium)
                ) {
                    InstagramRoundImage(
                        image = highlight.imageUrl,
                        modifier = Modifier.size(AppDimensions.storyAvatarMedium),
                        gapPadding = AppDimensions.spacingMicro
                    )
                    Spacer(modifier = Modifier.height(AppDimensions.spacingTiny))
                    Text(
                        text = highlight.title,
                        style = AppTypography.caption.copy(fontSize = AppDimensions.textSmall),
                        color = MaterialTheme.colorScheme.onBackground,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )
                }
            }

            // "+ New" Highlight Item
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(AppDimensions.storyAvatarMedium)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = {}
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .size(AppDimensions.storyAvatarMedium)
                            .clip(CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        InstagramRoundImage(
                            image = "",
                            modifier = Modifier.size(AppDimensions.storyAvatarMedium),
                            gapPadding = AppDimensions.spacingMicro
                        )
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_new_highlight),
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.size(AppDimensions.iconLarge)
                        )
                    }
                    Spacer(modifier = Modifier.height(AppDimensions.spacingTiny))
                    Text(
                        text = stringResource(id = com.example.instagramclone.R.string.profile_highlight_new),
                        style = AppTypography.caption.copy(fontSize = AppDimensions.textSmall),
                        color = MaterialTheme.colorScheme.onBackground,
                        maxLines = 1,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
