package com.shivam.sampleinsta.ui.insta

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.shivam.sampleinsta.MainActivityViewModel

@Composable
fun Insta() {
    val viewModel = MainActivityViewModel()
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = {
                InstaToolbar(
                    leftClickAction = { },
                    rightClickAction = { viewModel.addPostItem() })
            },
            content = {
                val storyList by viewModel.storyList.observeAsState(ArrayList())
                val postList = viewModel.postList
                Column {
                    InstaStoryBar(storyList, onStoryClick = { viewModel.onStorySeen(it) })
                    InstaPostItem(
                        postList,
                        onPostLike = { isLiked, postModel ->
                            viewModel.onLikePost(
                                isLiked,
                                postModel
                            )
                        },
                        onPostBookmarked = { isBookmarked, postModel ->
                            viewModel.onPostBookmark(
                                isBookmarked,
                                postModel
                            )
                        })
                }
            }
        )
    }
}