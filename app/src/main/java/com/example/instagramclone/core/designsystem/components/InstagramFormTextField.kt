package com.example.instagramclone.core.designsystem.components

import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AccentColor
import com.example.instagramclone.core.designsystem.theme.FormFieldBgDark
import com.example.instagramclone.core.designsystem.theme.FormFieldBgLight
import com.example.instagramclone.core.designsystem.theme.FormFieldBorderDark
import com.example.instagramclone.core.designsystem.theme.FormFieldBorderLight

/**
 * Replicated from CC-Instagram CustomFormTextField.kt
 * Renamed to InstagramFormTextField with scalable AppDimensions sizing.
 */
@Composable
fun InstagramFormTextField(
    modifier: Modifier = Modifier,
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    val darkTheme: Boolean = isSystemInDarkTheme()
    val keyboardController = LocalSoftwareKeyboardController.current
    var passwordVisible by remember { mutableStateOf(false) }

    val isPassword = visualTransformation is PasswordVisualTransformation
    val keyboardTrans = if (isPassword) KeyboardType.Password else keyboardType
    val transformation = if (isPassword) {
        if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    } else {
        visualTransformation
    }

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = AppDimensions.borderThin,
                color = if (darkTheme) FormFieldBorderDark else FormFieldBorderLight,
                shape = RoundedCornerShape(AppDimensions.radiusSmall)
            ),
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = hint, fontSize = AppDimensions.textMedium)
        },
        shape = RoundedCornerShape(AppDimensions.radiusSmall),
        singleLine = true,
        visualTransformation = transformation,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardTrans,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        ),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = AccentColor,
            focusedContainerColor = if (darkTheme) FormFieldBgDark else FormFieldBgLight,
            unfocusedContainerColor = if (darkTheme) FormFieldBgDark else FormFieldBgLight
        ),
        trailingIcon = {
            if (isPassword) {
                val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = image,
                        contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_toggle_password_visibility)
                    )
                }
            }
        }
    )
}
