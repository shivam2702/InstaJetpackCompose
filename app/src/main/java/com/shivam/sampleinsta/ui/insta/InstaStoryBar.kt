package com.shivam.sampleinsta.ui.insta

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.shivam.sampleinsta.model.StoryModel
import com.shivam.sampleinsta.ui.theme.instagramGradient
import com.shivam.sampleinsta.ui.theme.typography

@Composable
fun InstaStoryBar(stories: ArrayList<StoryModel>, onStoryClick: (StoryModel) -> Unit) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = "Stories", style = typography.body2, modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
            Text(
                text = "Watch all", style = typography.body2, modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.End)
            )
        }
        LazyRow(modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)) {
            items(stories) {
                StoryItem(story = it, onStoryClick)
            }
        }
    }
}

@Composable
fun StoryItem(story: StoryModel, onStoryClick: (StoryModel) -> Unit) {
    val imageModifier: Modifier
    val textModifier: Modifier
    if (story.isRead) {
        imageModifier = Modifier
            .padding(end = 12.dp, start = 12.dp)
            .height(60.dp)
            .width(60.dp)
            .clip(CircleShape)

        textModifier = Modifier
            .alpha(0.4f)
            .padding(top = 4.dp)
    } else {
        imageModifier = Modifier
            .padding(end = 12.dp, start = 12.dp)
            .height(60.dp)
            .width(60.dp)
            .clip(CircleShape)
            .border(
                shape = CircleShape,
                border = BorderStroke(
                    width = 2.dp,
                    brush = Brush.linearGradient(
                        colors = instagramGradient,
                        start = Offset(0f, 0f),
                        end = Offset(100f, 100f)
                    )
                ),
            )
        textModifier = Modifier
            .alpha(1f)
            .padding(top = 4.dp)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { if (!story.isRead) onStoryClick.invoke(story) }) {
        Image(
            painter = rememberCoilPainter(request = story.imageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = imageModifier
        )
        Text(text = story.name, style = typography.caption, modifier = textModifier)
    }
}