package com.shivam.sampleinsta

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shivam.sampleinsta.model.PostModel
import com.shivam.sampleinsta.model.StoryModel
import com.shivam.sampleinsta.model.getDummyPosts
import com.shivam.sampleinsta.model.getDummyStories

class MainActivityViewModel : ViewModel() {
    // Story Section
    private val _storyList: MutableLiveData<ArrayList<StoryModel>> =
        MutableLiveData(getDummyStories())
    val storyList: LiveData<ArrayList<StoryModel>> = _storyList

    fun onStorySeen(storyModel: StoryModel) {
        val newList = ArrayList(_storyList.value)
        newList.remove(storyModel)
        storyModel.isRead = true
        newList.add(storyModel)
        _storyList.value = newList
    }

    // Post Section
    var postList: List<PostModel> by mutableStateOf(getDummyPosts())
        private set

    fun addPostItem() {
        val dummy = getDummyPosts().random()
        postList = listOf(dummy) + postList
    }

    fun onLikePost(isLiked: Boolean, postModel: PostModel) {
        val copyObject = postModel.copy()
        copyObject.isLiked = isLiked
        postList = postList.toMutableList().also {
            it[postList.indexOf(postModel)] = copyObject
        }
    }

    fun onPostBookmark(isBookmarked: Boolean, postModel: PostModel) {
        val copyObject = postModel.copy()
        copyObject.isBookmarked = isBookmarked
        postList = postList.toMutableList().also {
            it[postList.indexOf(postModel)] = copyObject
        }
    }
}