package com.example.instagramclone.feature.profile.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.example.instagramclone.core.designsystem.components.HighlightItem
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions

/**
 * Replicated from CC-Instagram Profile.kt (HighlightSection)
 * Renamed to InstagramHighlightSection with scalable AppDimensions sizing.
 */
@Composable
fun InstagramHighlightSection(
    highlights: List<HighlightItem>,
    modifier: Modifier = Modifier,
    onHighlightClick: (HighlightItem) -> Unit = {}
) {
    LazyRow(
        modifier = modifier.padding(vertical = AppDimensions.spacingTiny),
        horizontalArrangement = Arrangement.spacedBy(AppDimensions.spacingDefault)
    ) {
        items(highlights, key = { it.id }) { highlight ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = { onHighlightClick(highlight) }
                )
            ) {
                InstagramRoundImage(
                    image = highlight.imageUrl,
                    modifier = Modifier.size(AppDimensions.storyAvatarMedium),
                    gapPadding = AppDimensions.storyRingBorder
                )
                Spacer(modifier = Modifier.height(AppDimensions.spacingTiny))
                Text(
                    text = highlight.title,
                    fontSize = AppDimensions.textSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}
