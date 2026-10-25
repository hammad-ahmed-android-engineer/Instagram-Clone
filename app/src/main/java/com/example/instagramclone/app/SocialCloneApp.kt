package com.example.instagramclone.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.instagramclone.app.navigation.CreatePostRoute
import com.example.instagramclone.app.navigation.ExploreRoute
import com.example.instagramclone.app.navigation.FeedRoute
import com.example.instagramclone.app.navigation.MessagesRoute
import com.example.instagramclone.app.navigation.NotificationsRoute
import com.example.instagramclone.app.navigation.ProfileRoute
import com.example.instagramclone.app.navigation.ReelsRoute
import com.example.instagramclone.app.navigation.SocialCloneNavHost
import com.example.instagramclone.core.designsystem.components.InstagramAdaptiveNavigationScaffold
import com.example.instagramclone.core.designsystem.components.InstagramIcons
import com.example.instagramclone.core.designsystem.components.NavigationItemData
import com.example.instagramclone.core.designsystem.theme.SocialCloneTheme
import com.example.instagramclone.data.dummy.DummyData
import com.example.instagramclone.R

val adaptiveNavigationItems: List<NavigationItemData<Any>> = listOf(
    NavigationItemData(
        route = FeedRoute,
        selectedIcon = InstagramIcons.HomeFilled,
        unselectedIcon = InstagramIcons.Home,
        labelResId = R.string.nav_home
    ),
    NavigationItemData(
        route = ExploreRoute,
        selectedIcon = InstagramIcons.SearchFilled,
        unselectedIcon = InstagramIcons.Search,
        labelResId = R.string.nav_search
    ),
    NavigationItemData(
        route = CreatePostRoute,
        selectedIcon = InstagramIcons.CreateFilled,
        unselectedIcon = InstagramIcons.Create,
        labelResId = R.string.nav_create
    ),
    NavigationItemData(
        route = ReelsRoute,
        selectedIcon = InstagramIcons.ReelsFilled,
        unselectedIcon = InstagramIcons.Reels,
        labelResId = R.string.nav_reels
    ),
    NavigationItemData(
        route = ProfileRoute,
        selectedIcon = InstagramIcons.GridTab,
        unselectedIcon = InstagramIcons.GridTab,
        labelResId = R.string.nav_profile,
        isProfileTab = true,
        profileAvatarUrl = DummyData.users[0].profilePicUrl
    )
)

@Composable
fun SocialCloneApp() {
    SocialCloneTheme {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        val isMainTab = currentDestination?.let { destination ->
            listOf(FeedRoute, ExploreRoute, CreatePostRoute, ReelsRoute, ProfileRoute).any { route ->
                destination.hierarchy.any { it.hasRoute(route::class) }
            }
        } ?: false

        InstagramAdaptiveNavigationScaffold(
            navigationItems = adaptiveNavigationItems,
            showBottomBar = isMainTab,
            currentRouteMatcher = { route ->
                currentDestination?.hierarchy?.any {
                    it.hasRoute(route::class)
                } == true
            },
            onNavigate = { route ->
                navController.navigate(route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        ) { contentModifier ->
            SocialCloneNavHost(
                navController = navController,
                modifier = contentModifier
            )
        }
    }
}
