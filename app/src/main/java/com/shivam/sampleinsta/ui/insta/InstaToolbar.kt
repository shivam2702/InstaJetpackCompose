package com.shivam.sampleinsta.ui.insta

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shivam.sampleinsta.R

@Composable
fun InstaToolbar(leftClickAction: () -> Unit, rightClickAction: () -> Unit) {
    TopAppBar(
        title = {
            Icon(
                painter = painterResource(id = R.drawable.ic_instagram_logo),
                contentDescription = null,
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth()
            )
        },
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onSurface,
        elevation = 0.dp,
        navigationIcon = { NavigationIcons(leftClickAction = leftClickAction) },
        actions = { ActionIcons(action = rightClickAction) }
    )
}

@Composable
fun NavigationIcons(leftClickAction: () -> Unit) {
    IconButton(onClick = { leftClickAction.invoke() }) {
        Icon(Icons.Outlined.Search, contentDescription = null)
    }
}

@Composable
fun ActionIcons(action: () -> Unit) {
    IconButton(onClick = { action.invoke() }) {
        Icon(Icons.Outlined.Star, contentDescription = null)
    }
}

@Preview
@Composable
private fun LayoutInstaToolbar() {
    InstaToolbar(
        leftClickAction = {

        },
        rightClickAction = {

        }
    )
}