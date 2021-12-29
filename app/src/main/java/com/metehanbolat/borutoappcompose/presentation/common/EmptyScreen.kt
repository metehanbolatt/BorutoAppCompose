package com.metehanbolat.borutoappcompose.presentation.common

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import com.metehanbolat.borutoappcompose.R
import com.metehanbolat.borutoappcompose.ui.theme.DarkGray
import com.metehanbolat.borutoappcompose.ui.theme.LightGray
import com.metehanbolat.borutoappcompose.ui.theme.NETWORK_ERROR_ICON_HEIGHT
import com.metehanbolat.borutoappcompose.ui.theme.SMALL_PADDING
import java.net.SocketTimeoutException

@Composable
fun EmptyScreen(error: LoadState.Error) {
    val message by remember { mutableStateOf(parseErrorMessage(message = error.toString())) }
    val icon by remember { mutableStateOf(R.drawable.ic_network_error) }
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim by animateFloatAsState(
        targetValue = if (startAnimation) ContentAlpha.disabled else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )
    
    LaunchedEffect(key1 = true) {
        startAnimation = true
    }
    
    EmptyContent(
        alphaAnim = alphaAnim,
        icon = icon,
        message = message
    )
}

@Composable
fun EmptyContent(
    alphaAnim: Float,
    icon: Int,
    message: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .size(NETWORK_ERROR_ICON_HEIGHT)
                .alpha(alpha = alphaAnim),
            painter = painterResource(id = icon),
            contentDescription = stringResource(R.string.network_error_icon),
            tint = if (isSystemInDarkTheme()) LightGray else DarkGray
        )
        Text(
            modifier = Modifier
                .padding(top = SMALL_PADDING)
                .alpha(alpha = alphaAnim),
            text = message,
            color = if (isSystemInDarkTheme()) LightGray else DarkGray,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontSize = MaterialTheme.typography.subtitle1.fontSize
        )
    }
}

fun parseErrorMessage(message: String): String {
    return when {
        message.contains("SocketTimeoutException") -> "Server Unavailable."
        message.contains("ConnectException") -> "Internet Unavailable."
        else -> "Unknown Error."
    }
}

@Preview(showBackground = true)
@Composable
fun EmptyScreenPreview() {
    EmptyContent(
        alphaAnim = 1f,
        icon = R.drawable.ic_network_error,
        message = "Internet Unavailable"
    )
}