package com.example.instagramclone.core.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.core.designsystem.theme.BluePrimary
import com.example.instagramclone.data.dummy.DummyData
import com.example.instagramclone.data.model.Comment
import com.example.instagramclone.R

/**
 * Segregated InstagramCommentBottomSheet modal with quick emojis,
 * comment list, and bottom text field with AppDimensions sizing.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramCommentBottomSheet(
    comments: List<Comment>,
    onDismissRequest: () -> Unit,
    onAddComment: (String) -> Unit,
    modifier: Modifier = Modifier,
    sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
) {
    var commentText by remember { mutableStateOf("") }
    val quickEmojis = listOf("❤️", "🙌", "🔥", "👏", "😢", "😍", "😮", "😂")

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.background,
        dragHandle = {
            Box(
                modifier = Modifier
                    .padding(vertical = AppDimensions.spacingSmall)
                    .width(AppDimensions.storyAvatarSmall)
                    .height(AppDimensions.spacingTiny)
                    .clip(RoundedCornerShape(AppDimensions.radiusMicro))
                    .background(MaterialTheme.colorScheme.outline.copy(alpha = 0.4f))
            )
        },
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
        ) {
            // Header
            Text(
                text = stringResource(id = R.string.comments_title),
                style = AppTypography.pageTitle.copy(fontSize = AppDimensions.textLarge, fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = AppDimensions.spacingMedium)
            )

            // Hairline Divider
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppDimensions.dividerThickness)
                    .background(MaterialTheme.colorScheme.outline)
            )

            // Comments List
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = AppDimensions.spacingMedium)
            ) {
                items(comments, key = { it.id }) { comment ->
                    InstagramCommentItem(comment = comment)
                }
            }

            // Quick Emoji Reaction Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AppDimensions.spacingMedium, vertical = AppDimensions.spacingMicro),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                quickEmojis.forEach { emoji ->
                    Text(
                        text = emoji,
                        fontSize = AppDimensions.textHeadline,
                        modifier = Modifier.clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = { commentText += emoji }
                        )
                    )
                }
            }

            // Input Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AppDimensions.spacingMedium, vertical = AppDimensions.spacingMicro),
                verticalAlignment = Alignment.CenterVertically
            ) {
                UserAvatar(
                    imageUrl = DummyData.users[0].profilePicUrl,
                    size = AppDimensions.storyAvatarSmall
                )

                Spacer(modifier = Modifier.width(AppDimensions.spacingSmall))

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(AppDimensions.radiusExtraLarge))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(horizontal = AppDimensions.spacingMedium, vertical = AppDimensions.spacingSmall),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (commentText.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.comments_hint_add),
                            style = AppTypography.caption.copy(color = MaterialTheme.colorScheme.outline)
                        )
                    }

                    BasicTextField(
                        value = commentText,
                        onValueChange = { commentText = it },
                        textStyle = AppTypography.caption.copy(color = MaterialTheme.colorScheme.onBackground),
                        cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                if (commentText.isNotBlank()) {
                    Spacer(modifier = Modifier.width(AppDimensions.spacingSmall))
                    Text(
                        text = stringResource(id = R.string.comments_btn_post),
                        style = AppTypography.buttonText.copy(color = BluePrimary, fontWeight = FontWeight.Bold),
                        modifier = Modifier.clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = {
                                onAddComment(commentText)
                                commentText = ""
                            }
                        )
                    )
                }
            }
        }
    }
}
