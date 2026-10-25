package com.example.instagramclone.core.designsystem.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.ui.unit.Dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.RedLike

enum class LikeButtonState {
    Idle,
    Pressed,
    Released
}

/**
 * Reusable animated bouncy like button matching CC-Instagram AnimLikeButton.
 */
@Composable
fun InstagramLikeButton(
    isLiked: Boolean,
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = AppDimensions.iconLarge,
    unlikedColor: Color = MaterialTheme.colorScheme.onBackground,
    likedColor: Color = RedLike
) {
    var transitionState by remember {
        mutableStateOf(MutableTransitionState(LikeButtonState.Idle))
    }

    if (transitionState.currentState == LikeButtonState.Pressed) {
        transitionState.targetState = LikeButtonState.Released
    }

    val transition = androidx.compose.animation.core.rememberTransition(transitionState, label = "likeButtonTransition")

    val animatedColor by transition.animateColor(
        transitionSpec = {
            when {
                LikeButtonState.Idle isTransitioningTo LikeButtonState.Pressed ->
                    spring(dampingRatio = Spring.DampingRatioHighBouncy)
                LikeButtonState.Pressed isTransitioningTo LikeButtonState.Released ->
                    tween(200)
                else -> snap()
            }
        },
        label = "likeColor"
    ) { state ->
        when (state) {
            LikeButtonState.Idle -> if (isLiked) likedColor else unlikedColor
            else -> if (!isLiked) unlikedColor else likedColor
        }
    }

    val animatedSize by transition.animateDp(
        transitionSpec = {
            when {
                LikeButtonState.Idle isTransitioningTo LikeButtonState.Pressed ->
                    spring(dampingRatio = Spring.DampingRatioHighBouncy)
                LikeButtonState.Pressed isTransitioningTo LikeButtonState.Released ->
                    tween(200)
                else -> snap()
            }
        },
        label = "likeSize"
    ) { state ->
        when (state) {
            LikeButtonState.Idle -> size
            LikeButtonState.Pressed -> size * 0.6f
            LikeButtonState.Released -> size
        }
    }

    Box(
        modifier = modifier
            .size(size)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {
                    transitionState = MutableTransitionState(LikeButtonState.Pressed)
                    onLikeClick()
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = if (isLiked) InstagramIcons.HeartFilled else InstagramIcons.Heart,
            contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_like),
            tint = animatedColor,
            modifier = Modifier.size(animatedSize)
        )
    }
}
