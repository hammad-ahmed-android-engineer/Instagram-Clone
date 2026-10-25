package com.example.instagramclone.feature.profile

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.instagramclone.core.designsystem.components.InstagramIcons
import com.example.instagramclone.core.designsystem.components.InstagramTopBar
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.feature.profile.components.InstagramPostTabView
import com.example.instagramclone.feature.profile.components.InstagramProfileHeader
import com.example.instagramclone.feature.profile.components.InstagramProfilePostGridItem

/**
 * Profile Screen replicating Instagram profile view with stats, highlights,
 * tab switcher, post grid, and adaptive landscape support.
 * Scaled dynamically with AppDimensions.
 */
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val currentUser = viewModel.currentUser
    val userPosts by viewModel.userPosts.collectAsStateWithLifecycle()
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    val gridColumns = if (isLandscape) 4 else 3

    Scaffold(
        contentWindowInsets = androidx.compose.foundation.layout.WindowInsets(0, 0, 0, 0),
        topBar = {
            InstagramTopBar(
                title = "",
                navigationIcon = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = {}
                        )
                    ) {
                        // Left + Create icon
                        Icon(
                            imageVector = InstagramIcons.Create,
                            contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_create),
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier
                                .size(AppDimensions.iconLarge)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null,
                                    onClick = {}
                                )
                        )
                        Spacer(modifier = Modifier.width(AppDimensions.spacingDefault))
                        // Username + Dropdown caret
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = {}
                            )
                        ) {
                            Text(
                                text = currentUser.username,
                                style = AppTypography.pageTitle,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Spacer(modifier = Modifier.width(AppDimensions.spacingTiny))
                            Icon(
                                imageVector = InstagramIcons.DropdownCaret,
                                contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_account_switcher),
                                tint = MaterialTheme.colorScheme.onBackground,
                                modifier = Modifier.size(AppDimensions.spacingMedium)
                            )
                        }
                    }
                },
                actions = {
                    // Threads logo icon
                    Icon(
                        imageVector = InstagramIcons.Threads,
                        contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_threads),
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .size(AppDimensions.iconLarge)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = {}
                            )
                    )
                    // Menu (hamburger)
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_menu),
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .size(AppDimensions.iconLarge)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = {}
                            )
                    )
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.TopCenter
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(gridColumns),
                modifier = Modifier
                    .fillMaxSize()
                    .widthIn(max = AppDimensions.maxGridWidth),
                horizontalArrangement = Arrangement.spacedBy(AppDimensions.borderThin),
                verticalArrangement = Arrangement.spacedBy(AppDimensions.borderThin)
            ) {
                item(span = { GridItemSpan(gridColumns) }) {
                    Column {
                        InstagramProfileHeader(
                            user = currentUser,
                            postsCount = userPosts.size
                        )

                        // Instagram 3-Icon Profile Tabs (Grid, Reels, Tagged)
                        InstagramPostTabView(
                            selectedTabIndex = selectedTabIndex,
                            onTabSelected = { selectedTabIndex = it }
                        )
                    }
                }

                if (selectedTabIndex == 0) {
                    items(userPosts, key = { it.id }) { post ->
                        InstagramProfilePostGridItem(post = post, onPostClick = { /* View post */ })
                    }
                } else if (selectedTabIndex == 1) {
                    // Reels tab placeholder with 9:16 posts
                    items(userPosts.take(6), key = { "reel_${it.id}" }) { post ->
                        InstagramProfilePostGridItem(post = post, onPostClick = {})
                    }
                } else {
                    // Tagged tab placeholder
                    items(userPosts.take(3), key = { "tagged_${it.id}" }) { post ->
                        InstagramProfilePostGridItem(post = post, onPostClick = {})
                    }
                }
            }
        }
    }
}
