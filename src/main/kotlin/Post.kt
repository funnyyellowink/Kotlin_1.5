data class Post (
    var id: Int,
    var ownerId: Int,
    val date: Int,
    var text: String,
) {
    var replyOwnerId: Int = 0
    var replyPostId: Int = 0
    var friendsOnly: Boolean = false
    var comments: Array<Comment> = emptyArray()
    var copyright: Copyright? = null
    var likes : Like = Like
    var reposts: Repost = Repost
    var views: View = View
    var postType: String = "default"
    var postSource: PostSource? = null
    var geo: Geo? = null
    var signerId: Int = 0
    var fromId: Int = ownerId
    var createdBy: Int = ownerId
    var copyHistory: Array<Repost> = emptyArray()
    var canPin: Boolean = false
    var canDelete: Boolean = false
    var canEdit: Boolean = false
    var isPinned: Boolean = false
    var markedAsAds: Boolean = false
    var isFavourite: Boolean = false
    var donut : Donut? = null
    var postponedId: Int = 0
    var attachments: Array<Attachment> = emptyArray()
}
class Comment (
    var id: Int,
    var fromId: Int?,
    var date: Int,
    var text: String,
) {
    var donut: Donut? = null
    var replyToUser : Int = 0
    var replyToComment: Int = 0
    private var attachments = emptyArray<Attachment>()
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
        for ((index, oldPost) in posts.withIndex()) {
            println("old $oldPost with $index")
            if (post.id == oldPost.id) {
                println("found such post")
                val updatedPost = oldPost.copy(
                                    id = oldPost.id,
                                    ownerId = oldPost.ownerId,
                                    date = oldPost.date,
                                    text = post.text
                )
                println("new $updatedPost")
                posts[index] = updatedPost
                println("${posts[index].text}")
                return true
            } else {
                println("couldn't find such post")
            }
        }
        return false
    }
    fun clear() {
        posts = emptyArray()
    }
    fun clearComments() {
        comments = emptyArray()
    }
    private fun findById (id: Int) : Post{
        for (post in posts) { if (post.id == id) { return post }}
        throw PostNotFoundException("post $id")
    }
    fun createComment(postId: Int,comment: Comment) : Comment {
            val result = findById(postId).comments.plusElement(comment)
            println(result.last().text)
            return result.last()
    }
}

fun main() {
    val photo = Photo(1,1,1,1)
    val photoAttachment = PhotoAttachment(photo)
    val post1 = Post(1, 1, 1072022, "Post number one")
    WallService.add(post1)
    val post2= Post(2, 1, 1072022, "Post number two")
    WallService.add(post2)
    val updatedPost1 = Post(1, 1, 1072022, "New post number one")
    val updatedPost2 = Post(3, 1, 1072022, "Bad new post number one")
    post1.attachments.plusElement(photoAttachment)
    WallService.update(updatedPost1)
    WallService.update(updatedPost2)
    val comment = Comment(1,1,20220705,"first comment")
    try { WallService.createComment(1,comment) } catch (e: PostNotFoundException) { println("post not found")}
    try { WallService.createComment(3,comment) } catch (e: PostNotFoundException) { println("post not found")}
}
