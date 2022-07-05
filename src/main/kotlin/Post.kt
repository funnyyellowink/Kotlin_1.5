import javax.swing.text.StyledEditorKit.BoldAction

data class Post (
    var id: Int,
    var ownerId: Int,
    var fromId: Int?,
    var createdBy: Int?,
    val date: Int,
    var text: String,
    var replyOwnerId: Int?,
    var replyPostId: Int?,
    var friendsOnly: Boolean?,
    var comments: Comment?,
    var copyright: Copyright?,
    var likes: Like,
    var reposts: Repost,
    var views: View?,
    var postType: String?,
    var postSource: PostSource?,
    var geo: Geo?,
    var signerId: Int?,
    var copyHistory: Array<Repost>?,
    var canPin: Boolean?,
    var canDelete: Boolean?,
    var canEdit: Boolean?,
    var isPinned: Boolean?,
    var markedAsAds: Boolean?,
    var isFavourite: Boolean?,
    var donut: Donut?,
    var postponedId: Int?
)
object Comment {
    //TODO
}
object Copyright {
    //TODO
}
object Like {
    var count: Int = 0
}

object Repost {
    var count: Int = 0
}
object View {
    var count: Int = 0
}
object PostSource {
    //TODO
}
object Geo {
    var type: String? = null
    var coordinates: String? = null
    var place: String? = null
}
object Donut {
    //TODO
}
object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post.copy(id = posts.size + 1)
        println(
            "Added ${post.ownerId}`s post: " +
                    "\nPost: ${post.text}, posted at ${post.date}" +
                    "\nLiked: ${post.likes.count}, reposted: ${post.reposts.count} " +
                    "\n_____"
        )
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var existenceOfPost = false
        for ((index, oldPost) in posts.withIndex()) {
            if (post.id == oldPost.id) {
                existenceOfPost = true
                val updatedPost = oldPost.copy(
                                    id = oldPost.id,
                                    ownerId = oldPost.ownerId,
                                    date = oldPost.date,
                                    text = post.text,
                                    likes = post.likes,
                                    reposts = post.reposts
                )
                posts[index] = updatedPost
            } else {
                existenceOfPost = false
            }

        }
        return existenceOfPost
    }
}

fun main() {
    val post1= Post(1,
        1,
        1,
        1,
        1072022,
        "Post number one",
        null,
        null,
        null,
        null,
        null,
        Like,
        Repost,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
    )
    WallService.add(post1)
    val post2= Post(2,
        1,
        1,
        1,
        1072022,
        "Post number two",
        null,
        null,
        null,
        null,
        null,
        Like,
        Repost,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
    )
    WallService.add(post2)
    val updatedPost1 = Post(1,
        1,
        1,
        1,
        1072022,
        "New post number one",
        null,
        null,
        null,
        null,
        null,
        Like,
        Repost,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
    )
   val updatedPost2 = Post(3,
       1,
       1,
       1,
       1072022,
       "Bad new post number one",
       null,
       null,
       null,
       null,
       null,
       Like,
       Repost,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null
   )
    WallService.update(updatedPost1)
    WallService.update(updatedPost2)
}
