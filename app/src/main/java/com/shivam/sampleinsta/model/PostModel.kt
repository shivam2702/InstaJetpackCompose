package com.shivam.sampleinsta.model

data class PostModel(
    var id: Int,
    val userModel: UserModel,
    val image: String,
    val likeText: String,
    val caption: String,
    var isLiked: Boolean = false,
    var isBookmarked: Boolean = false
)

fun getDummyPosts(): List<PostModel> {
    return listOf(
        PostModel(
            1,
            getDummyUserModel()[1],
            "https://images.unsplash.com/photo-1621358921262-f4c003bc4123?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max",
            "Liked by ${getDummyUserModel().random().name} and ${(0..1000).random()} others",
            "My friends encouraged me to do so, Fighting or running away from war. My friends encouraged me to do so, Fighting or running away from war. My friends encouraged me to do so, Fighting or running away from war"
        ),
        PostModel(
            2,
            getDummyUserModel()[2],
            "https://images.unsplash.com/photo-1620539369497-87f166305d12?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max",
            "2875 Likes",
            "Hi! #marinad"
        ),
        PostModel(
            3,
            getDummyUserModel()[3],
            "https://images.unsplash.com/photo-1619796753108-cba77bacf03d?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max",
            "2875 Likes",
            "Fighting or running away from war"
        ),
        PostModel(
            4,
            getDummyUserModel()[4],
            "https://images.unsplash.com/photo-1620691281018-962209eeba37?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max",
            "2 Likes",
            "I dream that I am flying"
        ),
        PostModel(
            5,
            getDummyUserModel()[5],
            "https://images.unsplash.com/photo-1619583380616-1b646e784332?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max",
            "Liked by ${getDummyUserModel().random().name} and ${(0..1000).random()} others",
            "It looked like fun, My friends encouraged me to do so."
        ),
        PostModel(
            6,
            getDummyUserModel()[6],
            "https://images.unsplash.com/photo-1621245717159-0252e720a4bb?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max",
            "100 Likes",
            "Yes - I am halfway through it already!\n"
        ),
        PostModel(
            7,
            getDummyUserModel()[7],
            "https://images.unsplash.com/photo-1619854231899-33ee7003dd8d?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max",
            "Liked by ${getDummyUserModel().random().name} and <b>${(0..1000).random()} others",
            "I work in an office"
        ),
    )
}