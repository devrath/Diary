package com.istudio.diary.presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.istudio.diary.R

@Composable
fun GoogleButton(
    modifier: Modifier = Modifier,
    loadingState: Boolean = false,
    primaryText: String = "Sign in with Google",
    secondaryText: String = "Please wait",
    icon: Int = R.drawable.google_logo,
    shape: Shape = Shapes().extraSmall,
    borderColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    borderStrokeWidth: Dp = 1.dp,
    progressIndicatorColor: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit
) {
    // The below text is dynamically changeable so store it in a mutable state
    var buttonText by remember { mutableStateOf(primaryText) }

    LaunchedEffect(key1 = loadingState) {
        // This block is executed only once during the composition
        buttonText = if (loadingState) secondaryText else primaryText
    }

    Surface(
        modifier = modifier
            // its enabled and clickable if state is not loading state
            .clickable(enabled = !loadingState) { onClick() },
        shape = shape,
        border = BorderStroke(color = borderColor, width = borderStrokeWidth),
        color = backgroundColor
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(12.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Google Logo",
                tint = Color.Unspecified
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = buttonText,
                style = TextStyle(fontSize = MaterialTheme.typography.bodyMedium.fontSize)
            )

            if (loadingState) {
                // Display the loader if the loading state is true
                Spacer(modifier = modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier.size(16.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicatorColor
                )
            }

        }
    }
}

@Composable
@Preview
fun GoogleButtonPreview() {
    GoogleButton {}
}

@Composable
@Preview
fun GoogleButtonPreview2() {
    GoogleButton(loadingState = true) {}
}