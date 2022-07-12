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
    var comments: Array<Comment>?,
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
    var postponedId: Int?,
    var attachments: Array<Attachment>?
)
class Comment (
    var id: Int,
    var fromId: Int?,
    var date: Int,
    var text: String,
    var donut: Donut?,
    var replyToUser : Int?,
    var replyToComment: Int?,
    var attachments: Array<Attachment>?
) {
    override fun toString() : String {
        return "$id + $text"
    }
}
class PostNotFoundException(message: String): RuntimeException(message)
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
    private var comments = emptyArray<Comment>()
    fun add(post: Post): Post {
        posts += post.copy(id = posts.size + 1)
        println(
            "Added ${post.ownerId}`s post: " + "${post.id}" +
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
                println("found such post")
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
                println("couldnt find such post")
                existenceOfPost = false
            }
        }
        return existenceOfPost
    }
    fun clear() {
        WallService.posts = emptyArray()
    }
    fun findById (id: Int) : Post{
        for (post in posts) {
            if (post.id == id) {
                return post
            }
        }
        throw PostNotFoundException("post $id")
    }
    fun createComment(postId: Int,comment: Comment)  {
        try {
            println("comment is ${comment.text}")
            val postToComment = findById(postId).copy(id = postId, comments = findById(postId).comments?.plus(comment))
            posts[postId].comments?.plusElement(comment)
            println("${postToComment.comments?.last()?.text}")
            println("${posts[postId].comments?.last()?.text}")
        } catch (e: PostNotFoundException) { println("post not found") }
    }
}

fun main() {
    val photo = Photo(1,1,1,1)
    val photoAttachment = PhotoAttachment(photo)

    val post1 = Post(
        1,
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
        null,
        attachments = arrayOf(photoAttachment)
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
       null,
       null
   )
    //WallService.update(updatedPost1)
    //WallService.update(updatedPost2)
    val comment = Comment(1,1,20220705,"first comment",null,null,null,null)
    //println(comment.text)
    WallService.createComment(1,comment)
    //WallService.createComment(3,comment)
}
