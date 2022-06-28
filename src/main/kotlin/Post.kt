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
    var posts = emptyArray<Post>()

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
//                var oldPost = posts[index]
            var updatedPost = oldPost.copy(
                oldPost.id,
                oldPost.authorId,
                oldPost.authorName,
                oldPost.date,
                text = post.text,
                likes = post.likes,
                reposts = post.reposts
            )
            posts.set(index, updatedPost)
            existenceOfPost = true
        }
        println(
            "Updated ${post.authorName}`s post: " +
                    "\nPost: ${post.text}, posted at ${post.date}" +
                    "\nLiked: ${post.likes.count}, reposted: ${post.reposts.count} " +
                    "\n_____"
        )
        return existenceOfPost
    }
}


fun main() {
    var post1 = Post(1,1,"Иван",21042022,"Пост номер один", likes = Like, reposts = Repost)
    WallService.add(post1)
    var updatedPost1 = Post(1,1,"Иван",21042022,"Обновленный пост номер один", likes = Like, reposts = Repost)
    WallService.update(updatedPost1)
}
//    WallService.add(Post(1,1,"Петр",22042022,"Какой то второй пост",Like,Repost))
//    WallService.add(Post(1,1,"Анна",23042022,"Пост номер три",Like,Repost))
//
//    WallService.update()
//    WallService.likeAndRepost(1,"Измененный пост номер один")
//    WallService.likeAndRepost(1,"Еще раз изменили текст первого поста")
//
//    WallService.likeAndRepost(2,"nothing")
//    WallService.likeAndRepost(2,"Измененный пост два")
//    WallService.likeAndRepost(2,"Еще раз изменили текст поста номер два")
