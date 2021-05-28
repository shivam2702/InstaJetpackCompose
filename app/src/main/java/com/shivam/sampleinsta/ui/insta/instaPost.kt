package com.shivam.sampleinsta.ui.insta

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.shivam.sampleinsta.R
import com.shivam.sampleinsta.model.PostModel
import com.shivam.sampleinsta.model.UserModel
import com.shivam.sampleinsta.model.getDummyPosts
import com.shivam.sampleinsta.ui.theme.typography

@Composable
fun InstaPostItem(
    stories: List<PostModel>,
    onPostLike: (isLiked: Boolean, PostModel) -> Unit,
    onPostBookmarked: (isLiked: Boolean, PostModel) -> Unit
) {
    val listState = rememberLazyListState()
    LazyColumn(state = listState) {
        items(stories) {
            UserProfile(it.userModel)
            PostImage(it.image)
            Actions(it, onPostLike, onPostBookmarked)
            LikesText(it)
            CaptionMessage(it)
        }
    }
}

@Composable
fun PostImage(image: String) {
    Image(
        painter = rememberCoilPainter(request = image),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .clip(RoundedCornerShape(10.dp))
    )
}

@Composable
fun UserProfile(user: UserModel) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)) {
        Image(
            painter = rememberCoilPainter(request = user.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(end = 12.dp)
                .height(32.dp)
                .width(32.dp)
                .clip(CircleShape)
        )
        Column {
            Text(text = user.name)
        }
    }
}

@Composable
fun Actions(
    postModel: PostModel,
    onPostLike: (isLiked: Boolean, PostModel) -> Unit,
    onPostBookmarked: (isLiked: Boolean, PostModel) -> Unit
) {
    Row {
        val iconModifier = Modifier.size(24.dp, 24.dp)
        IconToggleButton(
            checked = postModel.isLiked,
            onCheckedChange = { onPostLike.invoke(it, postModel) }) {
            val icon =
                if (postModel.isLiked) R.drawable.ic_heart_filled else R.drawable.ic_heart_outline
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = iconModifier
            )
        }
        IconToggleButton(checked = false, onCheckedChange = { }) {
            Image(
                painter = painterResource(id = R.drawable.ic_message),
                contentDescription = null,
                modifier = iconModifier
            )
        }
        IconToggleButton(checked = false, onCheckedChange = { }) {
            Image(
                painter = painterResource(id = R.drawable.ic_send),
                contentDescription = null,
                modifier = iconModifier
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        IconToggleButton(
            checked = postModel.isBookmarked,
            onCheckedChange = { onPostBookmarked.invoke(it, postModel) }) {
            val icon =
                if (postModel.isBookmarked) R.drawable.ic_bookmark_filled else R.drawable.ic_bookmark
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = iconModifier
            )
        }
    }
}

@Composable
fun LikesText(postModel: PostModel) {
    Text(
        text = postModel.likeText,
        style = typography.body2.copy(fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(start = 16.dp)
    )
}

@Composable
fun CaptionMessage(postModel: PostModel) {
    var maxLines = 2
    Text(buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(postModel.userModel.name)
        }
        append("  ")
        append(postModel.caption)
    }, modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
    maxLines = maxLines, overflow = TextOverflow.Ellipsis)
    ClickableText(text = AnnotatedString("Read More"), onClick = {
        maxLines = 5
    })
}

@Preview
@Composable
fun LayoutInstaStoryItem() {
    InstaPostItem(getDummyPosts(), { _, _ -> }, { _, _ -> })
}