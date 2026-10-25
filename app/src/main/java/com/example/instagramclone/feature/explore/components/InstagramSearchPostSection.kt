package com.example.instagramclone.feature.explore.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.data.model.Post

/**
 * Replicated from CC-Instagram Search.kt (PostSection)
 * Renamed to InstagramSearchPostSection with scalable AppDimensions sizing and landscape column adaptability.
 */
@Composable
fun InstagramSearchPostSection(
    posts: List<Post>,
    modifier: Modifier = Modifier,
    columns: Int = 3,
    onPostClick: (Post) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        modifier = modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(AppDimensions.dividerThickness),
        verticalArrangement = Arrangement.spacedBy(AppDimensions.dividerThickness)
    ) {
        items(posts, key = { it.id }) { post ->
            InstagramExploreGridItem(
                post = post,
                onClick = onPostClick
            )
        }
    }
}
