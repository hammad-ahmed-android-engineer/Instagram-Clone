package com.example.instagramclone.feature.messaging

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.instagramclone.core.designsystem.components.InstagramIcons
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.data.dummy.DummyData
import com.example.instagramclone.data.model.User
import com.example.instagramclone.feature.explore.components.InstagramExploreSearchBar
import com.example.instagramclone.feature.messaging.components.InstagramConversationRow
import com.example.instagramclone.feature.messaging.components.InstagramNotesRow
import com.example.instagramclone.R

data class ChatConversation(
    val id: String,
    val user: User,
    val lastMessage: String,
    val timestamp: String,
    val isUnread: Boolean = false
)

/**
 * Direct messaging inbox replicating Instagram Direct.
 * Features top navigation bar, search bar, active notes bubble row, and conversation list.
 * Scaled dynamically with AppDimensions, and centered in landscape.
 */
@Composable
fun MessagingScreen(
    onBackClick: () -> Unit = {}
) {
    var searchQuery by remember { mutableStateOf("") }

    val sampleConversations = listOf(
        ChatConversation("1", DummyData.users[1], "Shared a post.", "2h", true),
        ChatConversation("2", DummyData.users[2], "See you tomorrow!", "5h", false),
        ChatConversation("3", DummyData.users[3], "Sent a reel by @nature", "1d", false),
        ChatConversation("4", DummyData.users[4], "Liked a message", "2d", false),
        ChatConversation("5", DummyData.users[1], "Can you send the link?", "3d", false)
    )

    Scaffold(
        topBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppDimensions.iconHuge),
                color = MaterialTheme.colorScheme.background
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = AppDimensions.spacingMedium),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_back),
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier
                                .size(AppDimensions.iconLarge)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null,
                                    onClick = onBackClick
                                )
                        )
                        Spacer(modifier = Modifier.width(AppDimensions.spacingDefault))
                        Text(
                            text = DummyData.users[0].username,
                            style = AppTypography.pageTitle,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Spacer(modifier = Modifier.width(AppDimensions.spacingTiny))
                        Icon(
                            imageVector = InstagramIcons.DropdownCaret,
                            contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_account_switcher),
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.size(AppDimensions.badgeSize)
                        )
                    }

                    // Top Right Action: New Message Pen
                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_new_message),
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.size(AppDimensions.iconMedium)
                    )
                }
            }
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
                // Search Bar
                item {
                    InstagramExploreSearchBar(
                        query = searchQuery,
                        onQueryChange = { searchQuery = it },
                        placeholder = stringResource(id = R.string.search_placeholder),
                        showMetaAi = false,
                        showBookmark = false,
                        showFilterChips = false
                    )
                }

                // Notes Bubble Row (segregated in InstagramNotesRow.kt)
                item {
                    InstagramNotesRow()
                }

                // "Messages" section title with "Requests"
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = AppDimensions.spacingMedium, vertical = AppDimensions.spacingSmall),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = com.example.instagramclone.R.string.dm_messages),
                            style = AppTypography.username.copy(fontSize = AppDimensions.textLarge),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            text = stringResource(id = com.example.instagramclone.R.string.dm_requests),
                            style = AppTypography.caption.copy(color = MaterialTheme.colorScheme.outline),
                            modifier = Modifier.clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = {}
                            )
                        )
                    }
                }

                // Conversation Rows (segregated in InstagramConversationRow.kt)
                items(sampleConversations, key = { it.id }) { chat ->
                    InstagramConversationRow(chat = chat)
                }
            }
        }
    }
}
