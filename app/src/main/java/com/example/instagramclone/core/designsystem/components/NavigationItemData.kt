package com.example.instagramclone.core.designsystem.components

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Data model representing a navigation destination in the Instagram bottom bar or landscape rail.
 */
data class NavigationItemData<T : Any>(
    val route: T,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val labelResId: Int,
    val isProfileTab: Boolean = false,
    val profileAvatarUrl: String? = null
)
