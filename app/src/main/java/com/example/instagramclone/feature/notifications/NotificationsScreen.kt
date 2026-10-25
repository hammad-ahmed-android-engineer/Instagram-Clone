package com.example.instagramclone.feature.notifications

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.instagramclone.core.designsystem.components.InstagramTopBar
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.data.dummy.DummyData
import com.example.instagramclone.data.model.NotificationItem
import com.example.instagramclone.feature.notifications.components.InstagramNotificationRow
import com.example.instagramclone.R

/**
 * Activity Notifications feed (likes, comments, follows)
 * Adapted for portrait and centered landscape max-width.
 */
@Composable
fun NotificationsScreen(
    onBackClick: () -> Unit = {}
) {
    val sampleNotifications = listOf(
        NotificationItem("1", "like", DummyData.users[1], "liked your post.", System.currentTimeMillis() - 3600000, false, DummyData.posts[0].imageUrls.first()),
        NotificationItem("2", "comment", DummyData.users[2], "commented: Stunning shot! 😍", System.currentTimeMillis() - 7200000, false, DummyData.posts[1].imageUrls.first()),
        NotificationItem("3", "follow", DummyData.users[3], "started following you.", System.currentTimeMillis() - 86400000, true),
        NotificationItem("4", "like", DummyData.users[4], "liked your reel.", System.currentTimeMillis() - 172800000, false, DummyData.posts[2].imageUrls.first()),
        NotificationItem("5", "follow", DummyData.users[1], "started following you.", System.currentTimeMillis() - 259200000, true)
    )

    Scaffold(
        topBar = {
            InstagramTopBar(
                title = stringResource(id = R.string.notifications_title),
                onBackClick = onBackClick
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
                    .widthIn(max = AppDimensions.maxGridWidth)
            ) {
                item {
                    Text(
                        text = stringResource(id = R.string.notifications_this_week),
                        style = AppTypography.username.copy(fontSize = AppDimensions.textLarge),
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(horizontal = AppDimensions.spacingMedium, vertical = AppDimensions.spacingMedium)
                    )
                }

                items(sampleNotifications, key = { it.id }) { item ->
                    InstagramNotificationRow(item = item)
                }
            }
        }
    }
}
