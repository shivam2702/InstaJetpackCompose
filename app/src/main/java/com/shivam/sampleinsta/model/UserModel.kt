package com.shivam.sampleinsta.model

data class UserModel(
    val id: Int,
    val image: String,
    val name: String,
    val hasStatus: Boolean = false
)

fun getDummyUserModel(): List<UserModel> {
    return listOf(
        UserModel(1, "https://randomuser.me/api/portraits/men/2.jpg", "Shivam Mathur"),
        UserModel(2, "https://randomuser.me/api/portraits/men/3.jpg", "Neha Mathur"),
        UserModel(3, "https://randomuser.me/api/portraits/men/4.jpg", "Random Group"),
        UserModel(4, "https://randomuser.me/api/portraits/men/5.jpg", "Mason Reid"),
        UserModel(5, "https://randomuser.me/api/portraits/men/6.jpg", "Jane Hurlbutt"),
        UserModel(6, "https://randomuser.me/api/portraits/men/7.jpg", "Cynthia Green"),
        UserModel(7, "https://randomuser.me/api/portraits/men/8.jpg", "Gina Hardy"),
        UserModel(8, "https://randomuser.me/api/portraits/men/9.jpg", "Terence Marrow"),
        UserModel(9, "https://randomuser.me/api/portraits/men/10.jpg", "Nigel Ruiz"),
        UserModel(10, "https://randomuser.me/api/portraits/men/11.jpg", "Wilfrid Corbyn")
    )
}