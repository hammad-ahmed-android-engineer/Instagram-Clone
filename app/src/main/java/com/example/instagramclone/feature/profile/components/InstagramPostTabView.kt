package com.example.instagramclone.feature.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.instagramclone.core.designsystem.components.InstagramIcons
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions

/**
 * Replicated from CC-Instagram Profile.kt (PostTabView)
 * Renamed to InstagramPostTabView with scalable AppDimensions sizing.
 */
@Composable
fun InstagramPostTabView(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        // Top hairline divider
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(AppDimensions.dividerThickness)
                .background(MaterialTheme.colorScheme.outline)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(AppDimensions.tabHeight)
        ) {
            InstagramPostTabItem(
                isSelected = selectedTabIndex == 0,
                icon = InstagramIcons.GridTab,
                contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_grid_posts),
                onClick = { onTabSelected(0) },
                modifier = Modifier.weight(1f)
            )
            InstagramPostTabItem(
                isSelected = selectedTabIndex == 1,
                icon = InstagramIcons.Reels,
                contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_reels),
                onClick = { onTabSelected(1) },
                modifier = Modifier.weight(1f)
            )
            InstagramPostTabItem(
                isSelected = selectedTabIndex == 2,
                icon = InstagramIcons.TaggedTab,
                contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_tagged),
                onClick = { onTabSelected(2) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun InstagramPostTabItem(
    isSelected: Boolean,
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val tint = if (isSelected) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.outline

    Column(
        modifier = modifier
            .fillMaxSize()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(AppDimensions.spacingMicro))
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = tint,
            modifier = Modifier.size(AppDimensions.iconLarge)
        )
        // 1.5dp bottom underline indicator for selected tab
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(AppDimensions.borderMedium)
                .background(if (isSelected) MaterialTheme.colorScheme.onBackground else Color.Transparent)
        )
    }
}
