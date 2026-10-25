package com.example.instagramclone.core.designsystem.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions

/**
 * Segregated InstagramNavItem component representing a single item in the bottom navigation bar or landscape rail.
 * Supports vector icons with filled/outlined states or circular user avatar with selection border.
 * Scaled dynamically with AppDimensions.
 */
@Composable
fun <T : Any> InstagramNavItem(
    item: NavigationItemData<T>,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val label = stringResource(id = item.labelResId)

    Box(
        modifier = modifier
            .size(AppDimensions.iconHuge)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        if (item.isProfileTab && item.profileAvatarUrl != null) {
            // Instagram Profile Tab: User avatar with selection outline
            Box(
                modifier = Modifier
                    .size(AppDimensions.iconLarge)
                    .clip(CircleShape)
                    .then(
                        if (isSelected) {
                            Modifier
                                .border(AppDimensions.borderMedium, MaterialTheme.colorScheme.onBackground, CircleShape)
                                .padding(AppDimensions.spacingMicro)
                        } else {
                            Modifier
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = item.profileAvatarUrl,
                    contentDescription = label,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
            }
        } else {
            // Instagram Vector Icon
            Icon(
                imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                contentDescription = label,
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.size(AppDimensions.iconLarge)
            )
        }
    }
}
