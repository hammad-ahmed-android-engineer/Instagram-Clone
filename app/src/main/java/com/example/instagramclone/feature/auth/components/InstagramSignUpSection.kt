package com.example.instagramclone.feature.auth.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AccentColor
import com.example.instagramclone.core.designsystem.theme.LineColor
import com.example.instagramclone.R

/**
 * Replicated from CC-Instagram LoginScreen.kt (SignUpSection)
 * Renamed to InstagramSignUpSection with scalable AppDimensions sizing.
 */
@Composable
fun InstagramSignUpSection(
    onSignUpClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // "OR" Divider
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = AppDimensions.spacingLarge)
        ) {
            Box(
                modifier = Modifier
                    .height(AppDimensions.dividerThickness)
                    .weight(1f)
                    .background(LineColor)
            )

            Text(
                text = stringResource(id = R.string.login_or_divider),
                style = MaterialTheme.typography.bodySmall,
                fontSize = AppDimensions.textSmall,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.outline,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(0.4f)
            )

            Box(
                modifier = Modifier
                    .height(AppDimensions.dividerThickness)
                    .weight(1f)
                    .background(LineColor)
            )
        }

        Spacer(modifier = Modifier.height(AppDimensions.spacingExtraLarge))

        // "Don't have an account? Sign up"
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = AppDimensions.spacingLarge)
        ) {
            Text(
                text = stringResource(id = R.string.login_no_account),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.outline
            )
            Spacer(modifier = Modifier.width(AppDimensions.spacingTiny))
            Text(
                text = stringResource(id = R.string.login_sign_up),
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                color = AccentColor,
                modifier = Modifier.clickable { onSignUpClicked() }
            )
        }
    }
}
