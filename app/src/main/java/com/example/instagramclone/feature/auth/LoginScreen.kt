package com.example.instagramclone.feature.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.LineColor
import com.example.instagramclone.feature.auth.components.InstagramLoginFormSection
import com.example.instagramclone.feature.auth.components.InstagramSignUpSection
import com.example.instagramclone.R

/**
 * Replicated from CC-Instagram LoginScreen.kt
 * Segregated login screen utilizing InstagramLoginFormSection, InstagramSignUpSection, and Meta footer.
 * Fully responsive in portrait and landscape with AppDimensions scalability.
 */
@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit = {},
    onNavigateToSignUp: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var isLoading by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(vertical = AppDimensions.spacingLarge),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .widthIn(max = AppDimensions.maxContentWidth)
                ) {

                    // Instagram Script Logo Wordmark
                    Text(
                        text = stringResource(id = R.string.title_instagram),
                        style = TextStyle(
                            fontFamily = FontFamily.Cursive,
                            fontWeight = FontWeight.Bold,
                            fontSize = AppDimensions.textDisplay,
                            color = MaterialTheme.colorScheme.onBackground,
                            letterSpacing = 0.5.sp
                        )
                    )

                    Spacer(modifier = Modifier.height(AppDimensions.storyAvatarSmall))

                    // Segregated Form Section
                    InstagramLoginFormSection(
                        onLoginClick = { email, password ->
                            onLoginSuccess()
                        },
                        isLoading = isLoading
                    )

                    Spacer(modifier = Modifier.height(AppDimensions.spacingExtraLarge))

                    // Segregated Sign Up Section
                    InstagramSignUpSection(
                        onSignUpClicked = onNavigateToSignUp
                    )

                    Spacer(modifier = Modifier.height(AppDimensions.profileAvatarMedium))

                    // Meta Footer
                    Box(
                        modifier = Modifier
                            .height(AppDimensions.dividerThickness)
                            .fillMaxWidth()
                            .background(LineColor)
                    )

                    Spacer(modifier = Modifier.height(AppDimensions.spacingMedium))

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = AppDimensions.spacingDefault)
                    ) {
                        Text(
                            text = stringResource(id = R.string.login_meta_footer),
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontWeight = FontWeight.Medium,
                                fontSize = AppDimensions.textSmall
                            ),
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                }
            }
        }
    }
}
