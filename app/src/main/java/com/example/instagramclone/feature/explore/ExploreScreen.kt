package com.example.instagramclone.feature.explore

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.feature.explore.components.InstagramExploreSearchBar
import com.example.instagramclone.feature.explore.components.InstagramSearchPostSection

/**
 * Explore Screen replicating Instagram search and discover grid.
 * Dynamically switches between 3 columns in portrait and 5 columns in landscape
 * with AppDimensions scaled sizing and smooth centering.
 */
@Composable
fun ExploreScreen(
    viewModel: ExploreViewModel = hiltViewModel()
) {
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
    val posts by viewModel.posts.collectAsStateWithLifecycle()
    var selectedCategory by remember { mutableStateOf("For you") }
    var isSavedActive by remember { mutableStateOf(false) }
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = if (isLandscape) AppDimensions.dp(900) else AppDimensions.dp(500))
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                InstagramExploreSearchBar(
                    query = searchQuery,
                    onQueryChange = viewModel::updateSearchQuery,
                    isSaved = isSavedActive,
                    onBookmarkClick = { isSavedActive = !isSavedActive },
                    selectedChip = selectedCategory,
                    onChipClick = { selectedCategory = it }
                )

                InstagramSearchPostSection(
                    posts = posts,
                    columns = if (isLandscape) 5 else 3,
                    onPostClick = {}
                )
            }
        }
    }
}
