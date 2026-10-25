package com.example.instagramclone.feature.feed.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.data.dummy.DummyData
import com.example.instagramclone.data.model.SuggestedAccount
import com.example.instagramclone.R

private val ActionBlueColor = Color(0xFF3864F6)
private val SubtitleTextColor = Color(0xFF8E959E)

/**
 * Segregated Instagram "Suggested for you" section:
 * - Header with "Suggested for you", "See all", and three-dots menu icon
 * - Horizontal LazyRow of [InstagramSuggestedAccountCard]
 * - Hairline divider before the next feed post
 */
@Composable
fun InstagramSuggestedForYouSection(
    modifier: Modifier = Modifier,
    initialSuggestions: List<SuggestedAccount> = DummyData.suggestedAccounts,
    onSeeAllClick: () -> Unit = {},
    onMoreOptionsClick: () -> Unit = {}
) {
    var suggestions by remember { mutableStateOf(initialSuggestions) }

    if (suggestions.isEmpty()) return

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = AppDimensions.spacingSmall)
    ) {
        // Section Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = AppDimensions.spacingMedium,
                    vertical = AppDimensions.spacingTiny
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.suggested_for_you),
                style = AppTypography.medium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = AppDimensions.textMedium
                ),
                color = Color.White
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(AppDimensions.spacingSmall)
            ) {
                Text(
                    text = stringResource(id = R.string.see_all),
                    style = AppTypography.caption.copy(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = AppDimensions.textSmall
                    ),
                    color = ActionBlueColor,
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = onSeeAllClick
                    )
                )

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                    tint = SubtitleTextColor,
                    modifier = Modifier
                        .size(AppDimensions.iconSmall)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = onMoreOptionsClick
                        )
                )
            }
        }

        Spacer(modifier = Modifier.height(AppDimensions.spacingSmall))

        // Horizontal Carousel of Suggestion Cards
        LazyRow(
            contentPadding = PaddingValues(horizontal = AppDimensions.spacingMedium),
            horizontalArrangement = Arrangement.spacedBy(AppDimensions.spacingSmall)
        ) {
            items(
                items = suggestions,
                key = { it.id }
            ) { account ->
                InstagramSuggestedAccountCard(
                    account = account,
                    onDismiss = {
                        suggestions = suggestions.filterNot { it.id == account.id }
                    },
                    onToggleFollow = {
                        suggestions = suggestions.map {
                            if (it.id == account.id) it.copy(isFollowing = !it.isFollowing) else it
                        }
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(AppDimensions.spacingMedium))

        // Hairline Divider below the section before next post
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(AppDimensions.dividerThickness)
                .background(MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))
        )
    }
}
