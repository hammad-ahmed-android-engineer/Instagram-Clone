package com.example.instagramclone.core.designsystem.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions

enum class LikedState {
    Initial,
    Liked,
    Disappeared
}

/**
 * Reusable double-tap heart explosion animation overlay matching CC-Instagram reference.
 */
@Composable
fun DoubleTapLikeOverlay(
    onDoubleTap: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    var transitionState by remember {
        mutableStateOf(MutableTransitionState(LikedState.Disappeared))
    }

    Box(
        modifier = modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = {
                        transitionState = MutableTransitionState(LikedState.Initial)
                        onDoubleTap()
                    }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        content()

        if (transitionState.currentState == LikedState.Initial) {
            transitionState.targetState = LikedState.Liked
        } else if (transitionState.currentState == LikedState.Liked) {
            transitionState.targetState = LikedState.Disappeared
        }

        val transition = androidx.compose.animation.core.rememberTransition(transitionState, label = "doubleTapHeartTransition")

        val alpha by transition.animateFloat(
            transitionSpec = {
                when {
                    LikedState.Initial isTransitioningTo LikedState.Liked ->
                        keyframes {
                            durationMillis = 500
                            0f at 0
                            0.6f at 100
                            1f at 225
                        }
                    LikedState.Liked isTransitioningTo LikedState.Disappeared ->
                        tween(durationMillis = 200)
                    else -> snap()
                }
            },
            label = "heartAlpha"
        ) { state ->
            if (state == LikedState.Liked) 1f else 0f
        }

        val scale by transition.animateFloat(
            transitionSpec = {
                when {
                    LikedState.Initial isTransitioningTo LikedState.Liked ->
                        spring(dampingRatio = 0.4f)
                    LikedState.Liked isTransitioningTo LikedState.Disappeared ->
                        tween(200)
                    else -> snap()
                }
            },
            label = "heartScale"
        ) { state ->
            when (state) {
                LikedState.Initial -> 0f
                LikedState.Liked -> 2.6f
                LikedState.Disappeared -> 0.8f
            }
        }

        if (alpha > 0.01f) {
            Icon(
                imageVector = InstagramIcons.HeartFilled,
                contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_like_explosion),
                tint = Color.White.copy(alpha = alpha),
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(AppDimensions.likeOverlayHeart)
                    .graphicsLayer(
                        scaleX = scale,
                        scaleY = scale
                    )
            )
        }
    }
}
