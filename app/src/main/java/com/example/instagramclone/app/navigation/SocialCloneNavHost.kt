package com.example.instagramclone.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.example.instagramclone.feature.explore.ExploreScreen
import com.example.instagramclone.feature.feed.FeedScreen
import com.example.instagramclone.feature.messaging.MessagingScreen
import com.example.instagramclone.feature.notifications.NotificationsScreen
import com.example.instagramclone.feature.post.CreatePostScreen
import com.example.instagramclone.feature.profile.ProfileScreen
import com.example.instagramclone.feature.reels.ReelsScreen
import com.example.instagramclone.feature.splash.SplashScreen
import kotlinx.serialization.Serializable

@Serializable
data object SplashRoute

@Serializable
data object FeedRoute

@Serializable
data object ExploreRoute

@Serializable
data object CreatePostRoute

@Serializable
data object ReelsRoute

@Serializable
data object ProfileRoute

@Serializable
data object NotificationsRoute

@Serializable
data object MessagesRoute

@Serializable
data object LoginRoute

@Composable
fun SocialCloneNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = SplashRoute,
        modifier = modifier
    ) {
        composable<SplashRoute> {
            SplashScreen(
                onSplashFinished = {
                    navController.navigate(FeedRoute) {
                        popUpTo(SplashRoute) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<LoginRoute> {
            com.example.instagramclone.feature.auth.LoginScreen(
                onLoginSuccess = { navController.navigate(FeedRoute) }
            )
        }
        composable<FeedRoute> {
            FeedScreen(
                onNotificationsClick = { navController.navigate(NotificationsRoute) },
                onMessagesClick = { navController.navigate(MessagesRoute) }
            )
        }
        composable<ExploreRoute> {
            ExploreScreen()
        }
        composable<CreatePostRoute> {
            CreatePostScreen()
        }
        composable<ReelsRoute> {
            ReelsScreen()
        }
        composable<ProfileRoute> {
            ProfileScreen()
        }
        composable<NotificationsRoute> {
            NotificationsScreen(onBackClick = { navController.popBackStack() })
        }
        composable<MessagesRoute> {
            MessagingScreen(onBackClick = { navController.popBackStack() })
        }
    }
}
