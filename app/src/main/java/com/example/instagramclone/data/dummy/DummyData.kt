package com.example.instagramclone.data.dummy

import com.example.instagramclone.data.model.Comment
import com.example.instagramclone.data.model.NotificationItem
import com.example.instagramclone.data.model.Post
import com.example.instagramclone.data.model.Story
import com.example.instagramclone.data.model.StoryGroup
import com.example.instagramclone.data.model.SuggestedAccount
import com.example.instagramclone.data.model.User

object DummyData {
    val users = listOf(
        User("1", "hammad", "Hammad Ahmed", "https://picsum.photos/id/1015/200/200", true),
        User("2", "janedoe", "Jane Doe", "https://picsum.photos/id/1025/200/200", false),
        User("3", "traveler", "Travel Explorer", "https://picsum.photos/id/1035/200/200", true),
        User("4", "foodie", "Food Lover", "https://picsum.photos/id/1045/200/200", false),
        User("5", "photographer", "Pro Photographer", "https://picsum.photos/id/1055/200/200", true)
    )

    val posts = listOf(
        Post("p1", users[2], listOf("https://picsum.photos/id/10/600/800", "https://picsum.photos/id/11/600/800"), "Beautiful scenery from my latest trip! \uD83C\uDFDE\uFE0F", 124, 2, System.currentTimeMillis() - 3600000, true, false),
        Post("p2", users[3], listOf("https://picsum.photos/id/20/600/800"), "Best burger in town \uD83C\uDF54", 89, 1, System.currentTimeMillis() - 7200000, false, true),
        Post("p3", users[4], listOf("https://picsum.photos/id/30/600/800"), "Camera gear ready for the weekend shoot \uD83D\uDCF8", 342, 45, System.currentTimeMillis() - 14400000, true, true),
        Post("p4", users[1], listOf("https://picsum.photos/id/40/600/800"), "Chilling with my cat \uD83D\uDC31", 56, 2, System.currentTimeMillis() - 86400000, false, false),
        Post("p5", users[2], listOf("https://picsum.photos/id/50/600/800"), "Lost in the woods \uD83C\uDF32", 210, 20, System.currentTimeMillis() - 172800000, false, false),
        Post("p6", users[3], listOf("https://picsum.photos/id/60/600/800"), "Sushi night! \uD83C\uDF63", 150, 10, System.currentTimeMillis() - 259200000, true, false),
        Post("p7", users[4], listOf("https://picsum.photos/id/70/600/800"), "Portrait of a stranger", 500, 60, System.currentTimeMillis() - 345600000, false, true),
        Post("p8", users[0], listOf("https://picsum.photos/id/80/600/800"), "My new setup \uD83D\uDCBB", 100, 8, System.currentTimeMillis() - 432000000, true, false),
        Post("p9", users[1], listOf("https://picsum.photos/id/90/600/800"), "Morning coffee \uD83C\uDF15", 75, 4, System.currentTimeMillis() - 518400000, false, false),
        Post("p10", users[2], listOf("https://picsum.photos/id/100/600/800"), "Beach vibes \uD83C\uDFD6\uFE0F", 300, 30, System.currentTimeMillis() - 604800000, true, true)
    )

    val stories = listOf(
        Story("s1", users[1], "https://picsum.photos/id/110/600/1000", System.currentTimeMillis() - 3600000, false),
        Story("s2", users[1], "https://picsum.photos/id/120/600/1000", System.currentTimeMillis() - 1800000, false),
        Story("s3", users[2], "https://picsum.photos/id/130/600/1000", System.currentTimeMillis() - 7200000, true),
        Story("s4", users[3], "https://picsum.photos/id/140/600/1000", System.currentTimeMillis() - 86400000, false),
        Story("s5", users[4], "https://picsum.photos/id/150/600/1000", System.currentTimeMillis() - 43200000, true)
    )

    val storyGroups = stories.groupBy { it.author }.map { (author, userStories) ->
        StoryGroup(author, userStories, userStories.any { !it.isViewed })
    }.sortedBy { !it.hasUnviewed } // Unviewed first

    val comments = listOf(
        Comment("c1", "p1", users[0], "Wow, amazing view!", System.currentTimeMillis() - 1800000, 2, false),
        Comment("c2", "p1", users[1], "Wish I was there!", System.currentTimeMillis() - 900000, 0, false),
        Comment("c3", "p2", users[4], "Looks delicious!", System.currentTimeMillis() - 3600000, 1, true)
    )

    val notifications = listOf(
        NotificationItem("n1", "LIKE", users[1], "liked your post.", System.currentTimeMillis() - 3600000, false, "https://picsum.photos/id/80/200/200"),
        NotificationItem("n2", "COMMENT", users[2], "commented: Wow, amazing view!", System.currentTimeMillis() - 7200000, false, "https://picsum.photos/id/80/200/200"),
        NotificationItem("n3", "FOLLOW", users[3], "started following you.", System.currentTimeMillis() - 86400000, true)
    )

    val suggestedAccounts = listOf(
        SuggestedAccount(
            id = "sug_1",
            username = "hamza_razique",
            fullName = "Hamza Razique",
            avatarUrl = "https://picsum.photos/id/1062/200/200",
            subtitle = "Suggested for you",
            isVerified = false
        ),
        SuggestedAccount(
            id = "sug_2",
            username = "bisma_nadeem",
            fullName = "Bisma Nadeem",
            avatarUrl = "https://picsum.photos/id/1025/200/200",
            subtitle = "Suggested for you",
            isVerified = false
        ),
        SuggestedAccount(
            id = "sug_3",
            username = "ahmad_khan",
            fullName = "Ahmad Khan",
            avatarUrl = "https://picsum.photos/id/1005/200/200",
            subtitle = "Suggested for you",
            isVerified = false
        ),
        SuggestedAccount(
            id = "sug_4",
            username = "sara_ali",
            fullName = "Sara Ali",
            avatarUrl = "https://picsum.photos/id/1035/200/200",
            subtitle = "Followed by foodie + 2 more",
            isVerified = true
        ),
        SuggestedAccount(
            id = "sug_5",
            username = "zayn_malik",
            fullName = "Zayn Malik",
            avatarUrl = "https://picsum.photos/id/1055/200/200",
            subtitle = "Popular",
            isVerified = true
        )
    )
}
