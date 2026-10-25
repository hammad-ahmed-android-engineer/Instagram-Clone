package com.example.instagramclone.feature.post

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PhotoCamera
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.instagramclone.core.designsystem.components.InstagramIcons
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.core.designsystem.theme.BluePrimary
import com.example.instagramclone.data.dummy.DummyData

/**
 * Screen for creating a new post. Fully responsive in portrait and landscape
 * (side-by-side preview and gallery grid in landscape) with AppDimensions scaling.
 */
@Composable
fun CreatePostScreen() {
    val sampleGalleryImages = DummyData.posts.flatMap { it.imageUrls }
    var selectedImage by remember { mutableStateOf(sampleGalleryImages.firstOrNull() ?: "") }
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    Scaffold(
        topBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppDimensions.tabHeight),
                color = MaterialTheme.colorScheme.background
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = AppDimensions.spacingMedium),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_cancel),
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .size(AppDimensions.iconLarge)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = {}
                            )
                    )

                    Text(
                        text = stringResource(id = com.example.instagramclone.R.string.create_post_title),
                        style = AppTypography.pageTitle,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Text(
                        text = stringResource(id = com.example.instagramclone.R.string.create_post_next),
                        style = AppTypography.buttonText.copy(
                            color = BluePrimary,
                            fontSize = AppDimensions.textLarge
                        ),
                        modifier = Modifier.clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = {}
                        )
                    )
                }
            }
        }
    ) { paddingValues ->
        if (isLandscape) {
            // Landscape: Side-by-side layout
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Left: Selected Image Preview
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = selectedImage,
                        contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_selected_media),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                // Right: Gallery Controls and Grid
                Column(
                    modifier = Modifier
                        .weight(1.2f)
                        .fillMaxHeight()
                ) {
                    GalleryControlsRow()

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.spacedBy(AppDimensions.dividerThickness),
                        verticalArrangement = Arrangement.spacedBy(AppDimensions.dividerThickness)
                    ) {
                        items(sampleGalleryImages) { imageUrl ->
                            GalleryGridItem(
                                imageUrl = imageUrl,
                                isSelected = imageUrl == selectedImage,
                                onClick = { selectedImage = imageUrl }
                            )
                        }
                    }
                }
            }
        } else {
            // Portrait: Stacked layout
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Selected Image Preview (1:1 Square)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = selectedImage,
                        contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_selected_media),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                GalleryControlsRow()

                // Gallery Grid (4 columns)
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(AppDimensions.dividerThickness),
                    verticalArrangement = Arrangement.spacedBy(AppDimensions.dividerThickness)
                ) {
                    items(sampleGalleryImages) { imageUrl ->
                        GalleryGridItem(
                            imageUrl = imageUrl,
                            isSelected = imageUrl == selectedImage,
                            onClick = { selectedImage = imageUrl }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun GalleryControlsRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = AppDimensions.spacingMedium, vertical = AppDimensions.spacingSmall),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {}
            )
        ) {
            Text(
                text = stringResource(id = com.example.instagramclone.R.string.create_post_recents),
                style = AppTypography.username.copy(fontSize = AppDimensions.textLarge),
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.width(AppDimensions.spacingTiny))
            Icon(
                imageVector = InstagramIcons.DropdownCaret,
                contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_select_album),
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.size(AppDimensions.badgeSize)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(AppDimensions.spacingMedium)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(AppDimensions.badgeSize))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(horizontal = AppDimensions.spacingSmall, vertical = AppDimensions.spacingMicro)
            ) {
                Text(
                    text = stringResource(id = com.example.instagramclone.R.string.create_post_select_multiple),
                    style = AppTypography.caption.copy(fontSize = AppDimensions.textCaption),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Box(
                modifier = Modifier
                    .size(AppDimensions.radiusPill)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.PhotoCamera,
                    contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_camera),
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.size(AppDimensions.iconSmall)
                )
            }
        }
    }
}

@Composable
private fun GalleryGridItem(
    imageUrl: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .clickable(onClick = onClick)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        if (isSelected) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White.copy(alpha = 0.3f))
            )
        }
    }
}
