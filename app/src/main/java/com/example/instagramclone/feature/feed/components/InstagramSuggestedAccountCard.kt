package com.example.instagramclone.feature.feed.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.example.instagramclone.core.designsystem.components.UserAvatar
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.data.model.SuggestedAccount
import com.example.instagramclone.R

private val CardBackgroundColor = Color(0xFF1B2026)
private val CardBorderColor = Color(0xFF282F38)
private val ActionBlueColor = Color(0xFF3864F6)
private val FollowingButtonColor = Color(0xFF323943)
private val SubtitleTextColor = Color(0xFF8E959E)
private val DismissIconColor = Color(0xFFCFD3D9)

/**
 * Segregated Instagram Suggested Account Card component matching authentic Instagram design:
 * - Dark elevated card background (#1B2026) with 16dp rounded corners
 * - Large 88dp circular avatar
 * - Floating dismiss 'X' button
 * - Full name and suggestion subtitle
 * - Vibrant blue "Follow" / dark "Following" action button
 */
@Composable
fun InstagramSuggestedAccountCard(
    account: SuggestedAccount,
    onDismiss: () -> Unit,
    onToggleFollow: () -> Unit,
    modifier: Modifier = Modifier
) {
    val cardCornerRadius = AppDimensions.dp(16)
    val cardBorder = BorderStroke(
        width = AppDimensions.borderThin,
        color = CardBorderColor
    )

    Box(
        modifier = modifier
            .width(AppDimensions.dp(160))
            .height(AppDimensions.dp(222))
            .border(cardBorder, RoundedCornerShape(cardCornerRadius))
            .clip(RoundedCornerShape(cardCornerRadius))
            .background(CardBackgroundColor)
            .padding(AppDimensions.spacingSmall)
    ) {
        // Floating Dismiss "X" Button
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = stringResource(id = R.string.cd_dismiss_suggestion),
            tint = DismissIconColor,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = AppDimensions.spacingMicro, end = AppDimensions.spacingMicro)
                .size(AppDimensions.dp(14))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onDismiss
                )
        )

        // Card Content
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(AppDimensions.dp(6)))

            // Circular Profile Avatar (88dp)
            UserAvatar(
                imageUrl = account.avatarUrl,
                size = AppDimensions.dp(88),
                hasStory = false
            )

            Spacer(modifier = Modifier.height(AppDimensions.spacingSmall))

            // Full Name (e.g., "Hamza Razique", "Bisma Nadeem")
            Text(
                text = account.fullName,
                style = AppTypography.medium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = AppDimensions.textSmall
                ),
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = AppDimensions.spacingMicro)
            )

            Spacer(modifier = Modifier.height(AppDimensions.spacingMicro))

            // Subtitle ("Suggested for you")
            Text(
                text = account.subtitle,
                style = AppTypography.caption.copy(
                    fontSize = AppDimensions.textCaption
                ),
                color = SubtitleTextColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = AppDimensions.spacingMicro)
            )

            Spacer(modifier = Modifier.weight(1f))

            // Follow / Following Action Button
            val isFollowing = account.isFollowing
            val buttonBg = if (isFollowing) FollowingButtonColor else ActionBlueColor
            val buttonText = stringResource(id = if (isFollowing) R.string.following else R.string.follow)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppDimensions.dp(34))
                    .clip(RoundedCornerShape(AppDimensions.dp(10)))
                    .background(buttonBg)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = onToggleFollow
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = buttonText,
                    style = AppTypography.buttonText.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = AppDimensions.textSmall
                    ),
                    color = Color.White
                )
            }
        }
    }
}
