package com.shivam.sampleinsta.model

data class StoryModel(
    var id: Int = -1,
    var imageUrl: String,
    var name: String,
    var isRead: Boolean = false
)

fun getDummyStories(): ArrayList<StoryModel> {
    return arrayListOf(
        StoryModel(-1, "https://randomuser.me/api/portraits/men/1.jpg", "Your Story", true),
        StoryModel(1, "https://randomuser.me/api/portraits/men/2.jpg", "Shivam Mathur"),
        StoryModel(2, "https://randomuser.me/api/portraits/men/3.jpg", "Neha Mathur"),
        StoryModel(3, "https://randomuser.me/api/portraits/men/4.jpg", "Random Group"),
        StoryModel(4, "https://randomuser.me/api/portraits/men/5.jpg", "Mason Reid"),
        StoryModel(5, "https://randomuser.me/api/portraits/men/6.jpg", "Jane Hurlbutt"),
        StoryModel(6, "https://randomuser.me/api/portraits/men/7.jpg", "Cynthia Green"),
        StoryModel(7, "https://randomuser.me/api/portraits/men/8.jpg", "Gina Hardy"),
        StoryModel(8, "https://randomuser.me/api/portraits/men/9.jpg", "Terence Marrow"),
        StoryModel(9, "https://randomuser.me/api/portraits/men/10.jpg", "Nigel Ruiz"),
        StoryModel(10, "https://randomuser.me/api/portraits/men/11.jpg", "Wilfrid Corbyn")
    )
}

fun getDummyStoriesNew(): ArrayList<StoryModel> {
    return arrayListOf(
        StoryModel(-1, "https://randomuser.me/api/portraits/men/1.jpg", "Your Story", true)
    )
}