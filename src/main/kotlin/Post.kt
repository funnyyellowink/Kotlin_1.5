data class Post (
    var id: Int,
    val authorId: Int,
    val authorName: String,
    val date: Int,
    var text: String,
    val likes: Like,
    val reposts: Repost,
)

object Like {
    var count: Int = 0
}

object Repost {
    var count: Int = 0
}

object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post.copy(id = posts.size + 1)
        println(
            "Added ${post.authorName}`s post: " +
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
                                    authorId = oldPost.authorId,
                                    authorName = oldPost.authorName,
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
    val post1 = Post(1,1,"Иван",21042022,"Пост номер один", likes = Like, reposts = Repost)
    WallService.add(post1)
    val post2= Post(2,1,"Иван",22042022,"Пост номер два", likes = Like, reposts = Repost)
    WallService.add(post2)
    val updatedPost1 = Post(2,1,"Иван",21042022,"Обновленный пост номер один", likes = Like, reposts = Repost)
    val updatedPost2 = Post(3,1,"Иван",21042022,"Кривой пост номер один", likes = Like, reposts = Repost)
    WallService.update(updatedPost1)
    WallService.update(updatedPost2)
}
