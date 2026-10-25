package com.example.instagramclone.feature.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.instagramclone.core.designsystem.components.InstagramCommentBottomSheet
import com.example.instagramclone.core.designsystem.components.InstagramIcons
import com.example.instagramclone.core.designsystem.components.InstagramPostCard
import com.example.instagramclone.core.designsystem.components.InstagramTopBar
import com.example.instagramclone.core.designsystem.components.PostCardSkeleton
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.data.dummy.DummyData
import com.example.instagramclone.data.model.Post
import android.content.res.Configuration
import androidx.compose.ui.platform.LocalConfiguration
import com.example.instagramclone.feature.feed.components.InstagramStoryRow
import com.example.instagramclone.feature.feed.components.InstagramSuggestedForYouSection
import com.example.instagramclone.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen(
    viewModel: FeedViewModel = hiltViewModel(),
    onNotificationsClick: () -> Unit = {},
    onMessagesClick: () -> Unit = {}
) {
    val posts by viewModel.posts.collectAsState()
    val stories by viewModel.stories.collectAsState()
    var selectedPostForComments by remember { mutableStateOf<Post?>(null) }
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    Scaffold(
        contentWindowInsets = androidx.compose.foundation.layout.WindowInsets(0, 0, 0, 0),
        topBar = {
            InstagramTopBar(
                title = stringResource(id = R.string.title_instagram),
                isBrandedTitle = true,
                isCenteredTitle = true,
                navigationIcon = if (isLandscape) null else {
                    {
                        // Left "+" Add/Create Story/Post Icon (portrait only)
                        Icon(
                            imageVector = InstagramIcons.Create,
                            contentDescription = stringResource(id = R.string.cd_create),
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
                },
                actions = {
                    // Notifications Heart with Red Unread Dot Badge
                    Box(
                        modifier = Modifier
                            .size(AppDimensions.radiusPill)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = onNotificationsClick
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = InstagramIcons.Heart,
                            contentDescription = stringResource(id = R.string.cd_notifications),
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.size(AppDimensions.iconLarge)
                        )
                        // Red unread notification dot in upper right corner of heart
                        Box(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(top = AppDimensions.borderThin, end = AppDimensions.borderThin)
                                .size(AppDimensions.spacingMicro)
                                .clip(CircleShape)
                                .background(Color(0xFFE91E63))
                        )
                    }
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .widthIn(max = AppDimensions.dp(500))
            ) {
                // Stories Tray
                item {
                    InstagramStoryRow(stories = stories)
                }

                if (posts.isEmpty()) {
                    items(3) {
                        PostCardSkeleton()
                    }
                } else {
                    itemsIndexed(
                        items = posts,
                        key = { _, post -> post.id }
                    ) { index, post ->
                        InstagramPostCard(
                            post = post,
                            onLikeClick = { viewModel.toggleLike(post.id) },
                            onSaveClick = { viewModel.toggleSave(post.id) },
                            onCommentClick = { selectedPostForComments = post },
                            onShareClick = { /* Share dialog */ }
                        )

                        // Instagram "Suggested for you" accounts carousel inserted after the 2nd post
                        if (index == 1) {
                            InstagramSuggestedForYouSection()
                        }
                    }
                }
            }
        }

        selectedPostForComments?.let { activePost ->
            InstagramCommentBottomSheet(
                comments = DummyData.comments,
                onDismissRequest = { selectedPostForComments = null },
                onAddComment = { /* Add comment */ }
            )
        }
    }
}
