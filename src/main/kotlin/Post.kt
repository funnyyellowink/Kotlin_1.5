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

    fun add(post: Post): Boolean {
        posts+=post.copy(id = posts.size + 1)
        println("Added ${post.authorName}`s post: " +
                "\nPost: ${post.text}, posted at ${post.date}" +
                "\nLiked: ${post.likes.count}, reposted: ${post.reposts.count} " +
                "\n_____")
        return posts.last().id != 0
    }

    fun likeAndRepost(id: Int, text: String): Boolean {
        for (post in posts) {
            if (post.id == id) {
                posts[id].likes.count += 1
                posts[id].reposts.count += 1
                when {
                    text != ("nothing") -> { posts[id-1].text = text }
                }
                println("Liked and reposted ${post.authorName}`s post: " +
                        "\nPost: ${post.text}, posted at ${post.date}" +
                        "\nLiked: ${post.likes.count}, reposted: ${post.reposts.count} " +
                        "\n_____")
            }
        }
        return text != "nothing"
    }
}

fun main() {
//    WallService.add(Post(1,1,"Иван",21042022,"Первый пост",Like,Repost))
//    WallService.add(Post(1,1,"Петр",22042022,"Какой то второй пост",Like,Repost))
//    WallService.add(Post(1,1,"Анна",23042022,"Пост номер три",Like,Repost))
//
//    WallService.likeAndRepost(1,"nothing")
//    WallService.likeAndRepost(1,"Измененный пост номер один")
//    WallService.likeAndRepost(1,"Еще раз изменили текст первого поста")
//
//    WallService.likeAndRepost(2,"nothing")
//    WallService.likeAndRepost(2,"Измененный пост два")
//    WallService.likeAndRepost(2,"Еще раз изменили текст поста номер два")
}