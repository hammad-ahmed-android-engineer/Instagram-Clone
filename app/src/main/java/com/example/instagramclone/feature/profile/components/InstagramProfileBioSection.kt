package com.example.instagramclone.feature.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.core.designsystem.theme.BluePrimary
import com.example.instagramclone.R

/**
 * Replicated directly from screenshot 4:
 * - Full name with pronoun (Hammad Ahmed he/him)
 * - Headline (Sr. Android Developer)
 * - Link (🔗 linkedin.com/in/hammad-ahmed-android-engineer)
 * - Channel badge (@ Hammad Ahmed + Add)
 * - Professional dashboard box ("Your dashboard \n 11 views in the last 30 days.")
 * - Action buttons ([Edit profile] [Share profile])
 */
@Composable
fun InstagramProfileBioSection(
    fullName: String,
    bioText: String,
    onEditProfileClick: () -> Unit,
    onShareProfileClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        // Name with pronoun
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = fullName,
                style = AppTypography.username.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.width(AppDimensions.spacingMicro))
            Text(
                text = "he/him",
                style = AppTypography.caption.copy(
                    fontSize = AppDimensions.textSmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            )
        }

        // Title / Role
        Text(
            text = "Sr. Android Developer",
            style = AppTypography.caption.copy(
                fontSize = AppDimensions.textSmall,
                fontWeight = FontWeight.Normal
            ),
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(top = AppDimensions.spacingMicro)
        )

        // Custom Link as seen in screenshot 4
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = AppDimensions.spacingMicro)
        ) {
            Text(
                text = "🔗 linkedin.com/in/hammad-ahmed-android-engineer",
                style = AppTypography.caption.copy(
                    color = BluePrimary,
                    fontSize = AppDimensions.textSmall,
                    fontWeight = FontWeight.Medium
                )
            )
        }

        // Channel Tag / Badge (@ Hammad Ahmed + Add)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = AppDimensions.spacingMicro)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(RoundedCornerShape(AppDimensions.radiusMedium))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(horizontal = AppDimensions.spacingSmall, vertical = AppDimensions.spacingTiny)
            ) {
                Text(
                    text = "@ $fullName",
                    style = AppTypography.caption.copy(
                        fontSize = AppDimensions.textSmall,
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Spacer(modifier = Modifier.width(AppDimensions.spacingSmall))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(RoundedCornerShape(AppDimensions.radiusMedium))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(horizontal = AppDimensions.spacingSmall, vertical = AppDimensions.spacingTiny)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.size(AppDimensions.iconTiny)
                )
                Spacer(modifier = Modifier.width(AppDimensions.spacingMicro))
                Text(
                    text = "Add",
                    style = AppTypography.caption.copy(
                        fontSize = AppDimensions.textSmall,
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }

        Spacer(modifier = Modifier.height(AppDimensions.spacingSmall))

        // Professional Dashboard Box as seen in screenshot 4
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(AppDimensions.radiusSmall))
                .background(Color(0xFF262626))
                .border(AppDimensions.borderThin, Color(0xFF383838), RoundedCornerShape(AppDimensions.radiusSmall))
                .padding(horizontal = AppDimensions.spacingMedium, vertical = AppDimensions.spacingSmall)
        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.profile_your_dashboard),
                    style = AppTypography.caption.copy(
                        fontSize = AppDimensions.textSmall,
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(AppDimensions.spacingMicro))
                Text(
                    text = stringResource(id = R.string.profile_dashboard_views),
                    style = AppTypography.caption.copy(fontSize = AppDimensions.textSmall),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.75f)
                )
            }
        }

        Spacer(modifier = Modifier.height(AppDimensions.spacingSmall))

        // Action Buttons [Edit profile] [Share profile]
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(AppDimensions.spacingMicro),
            verticalAlignment = Alignment.CenterVertically
        ) {
            InstagramActionButton(
                text = stringResource(id = R.string.profile_btn_edit),
                onClick = onEditProfileClick,
                modifier = Modifier.weight(1f)
            )

            InstagramActionButton(
                text = stringResource(id = R.string.profile_btn_share),
                onClick = onShareProfileClick,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
