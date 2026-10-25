package com.example.instagramclone.feature.auth.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import com.example.instagramclone.core.designsystem.components.InstagramFormTextField
import com.example.instagramclone.core.designsystem.components.InstagramPrimaryButton
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AccentColor
import com.example.instagramclone.R

/**
 * Replicated and enhanced from CC-Instagram LoginScreen.kt (FormSection)
 * Form fields for username/email, password, forgot password link, login button, and Facebook SSO.
 * Completely segregated and dimension-scaled via AppDimensions.
 */
@Composable
fun InstagramLoginFormSection(
    onLoginClick: (String, String) -> Unit,
    onForgotPasswordClick: () -> Unit = {},
    onFacebookLoginClick: () -> Unit = {},
    isLoading: Boolean = false,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxWidth()) {
        // Email/Username Form Field
        InstagramFormTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = AppDimensions.spacingLarge),
            hint = stringResource(id = R.string.login_hint_username),
            value = email,
            keyboardType = KeyboardType.Email,
            onValueChange = { email = it }
        )

        Spacer(modifier = Modifier.height(AppDimensions.spacingMedium))

        // Password Form Field
        InstagramFormTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = AppDimensions.spacingLarge),
            visualTransformation = PasswordVisualTransformation(),
            hint = stringResource(id = R.string.login_hint_password),
            value = password,
            onValueChange = { password = it }
        )

        Spacer(modifier = Modifier.height(AppDimensions.spacingMedium))

        // Forgot password?
        Text(
            text = stringResource(id = R.string.login_forgot_password),
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium),
            fontSize = AppDimensions.textSmall,
            color = AccentColor,
            textAlign = TextAlign.End,
            modifier = Modifier
                .padding(end = AppDimensions.spacingLarge)
                .align(Alignment.End)
                .clickable { onForgotPasswordClick() }
        )

        Spacer(modifier = Modifier.height(AppDimensions.radiusPill))

        // Log in Button
        InstagramPrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = AppDimensions.spacingLarge),
            text = stringResource(id = R.string.login_btn_login),
            isLoading = isLoading,
            onClick = { onLoginClick(email, password) }
        )

        Spacer(modifier = Modifier.height(AppDimensions.spacingExtraLarge))

        // Log in with Facebook
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onFacebookLoginClick() }
        ) {
            Text(
                text = stringResource(id = R.string.login_facebook),
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                fontSize = AppDimensions.textMedium,
                color = AccentColor
            )
        }
    }
}
