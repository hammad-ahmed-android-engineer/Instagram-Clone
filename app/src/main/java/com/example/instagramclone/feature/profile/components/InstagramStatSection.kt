package com.example.instagramclone.feature.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.instagramclone.R

/**
 * Replicated from CC-Instagram Profile.kt (StatSection)
 * Renamed to InstagramStatSection with scalable AppDimensions sizing.
 */
@Composable
fun InstagramStatSection(
    postsCount: String,
    followersCount: String,
    followingCount: String,
    modifier: Modifier = Modifier,
    onPostsClick: () -> Unit = {},
    onFollowersClick: () -> Unit = {},
    onFollowingClick: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        InstagramProfileStat(
            numberText = postsCount,
            text = stringResource(id = R.string.profile_stat_posts),
            onClick = onPostsClick
        )
        InstagramProfileStat(
            numberText = followersCount,
            text = stringResource(id = R.string.profile_stat_followers),
            onClick = onFollowersClick
        )
        InstagramProfileStat(
            numberText = followingCount,
            text = stringResource(id = R.string.profile_stat_following),
            onClick = onFollowingClick
        )
    }
}
