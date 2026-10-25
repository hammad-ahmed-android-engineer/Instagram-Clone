package com.example.instagramclone.core.designsystem.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions

/**
 * Adaptive navigation scaffold that dynamically switches between an Instagram
 * bottom bar (in portrait) and a compact side rail (in landscape) with full AppDimensions scaling.
 */
@Composable
fun <T : Any> InstagramAdaptiveNavigationScaffold(
    navigationItems: List<NavigationItemData<T>>,
    currentRouteMatcher: (T) -> Boolean,
    onNavigate: (T) -> Unit,
    showBottomBar: Boolean = true,
    modifier: Modifier = Modifier,
    content: @Composable (Modifier) -> Unit
) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {
        // Landscape Instagram Web / Tablet Sidebar
        Row(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .statusBarsPadding()
                .displayCutoutPadding()
                .navigationBarsPadding()
        ) {
            if (showBottomBar) {
                Surface(
                    modifier = Modifier
                        .width(AppDimensions.dp(64))
                        .fillMaxHeight(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Row(modifier = Modifier.fillMaxSize()) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .padding(vertical = AppDimensions.spacingSmall),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            // Top Instagram camera icon (colorful gradient)
                            com.example.instagramclone.feature.splash.InstagramGradientCameraIcon(
                                size = AppDimensions.dp(28),
                                modifier = Modifier.padding(bottom = AppDimensions.spacingSmall)
                            )

                            // Middle navigation items - arranged evenly so all 5 items always fit and never get cut off
                            Column(
                                modifier = Modifier.weight(1f),
                                verticalArrangement = Arrangement.SpaceEvenly,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                navigationItems.forEach { item ->
                                    val isSelected = currentRouteMatcher(item.route)
                                    InstagramNavItem(
                                        item = item,
                                        isSelected = isSelected,
                                        onClick = { onNavigate(item.route) }
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(AppDimensions.spacingSmall))
                        }

                        // Hairline right border
                        Box(
                            modifier = Modifier
                                .width(AppDimensions.dividerThickness)
                                .fillMaxHeight()
                                .background(MaterialTheme.colorScheme.outline)
                        )
                    }
                }
            }

            // Main Content Area centered in landscape
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.TopCenter
            ) {
                content(Modifier.fillMaxSize())
            }
        }
    } else {
        // Portrait Instagram Bottom Bar (49sdp exact height, hairline top border, no pills)
        Scaffold(
            modifier = modifier,
            bottomBar = {
                if (showBottomBar) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        // Hairline top border
                        Box(
                            modifier = Modifier
                                 .fillMaxWidth()
                                 .height(AppDimensions.dividerThickness)
                                 .background(MaterialTheme.colorScheme.outline)
                        )

                        // 49sdp navigation row
                        Surface(
                            modifier = Modifier
                                 .fillMaxWidth()
                                 .height(AppDimensions.bottomNavHeight),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                navigationItems.forEach { item ->
                                    val isSelected = currentRouteMatcher(item.route)
                                    InstagramNavItem(
                                        item = item,
                                        isSelected = isSelected,
                                        onClick = { onNavigate(item.route) }
                                    )
                                }
                            }
                        }

                        // Navigation bar insets spacer
                        Spacer(modifier = Modifier.windowInsetsBottomHeight(WindowInsets.navigationBars))
                    }
                }
            }
        ) { innerPadding ->
            content(Modifier.padding(innerPadding))
        }
    }
}
