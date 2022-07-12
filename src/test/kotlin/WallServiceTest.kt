import org.junit.Test
import org.junit.Assert.*
class WallServiceTest {
    private val testWallService = WallService

    @Test
    fun addTestPost() {
        val result = testWallService.add(
            Post(
                1,
                1,
                1072022,
                "Post number one",
                null,
                null,
                null,
                emptyArray(),
                null,
                Like,
                Repost,
                null,
                null,
                null,
                null,
                null,
                null
            )
        )
        assertTrue(result.id != 0)
        testWallService.clear()
    }

    @Test
    fun successfulUpdate() {
        testWallService.add(
            Post(
                1,
                1,
                1072022,
                "Post number one",
                null,
                null,
                null,
                emptyArray(),
                null,
                Like,
                Repost,
                null,
                null,
                null,
                null,
                null,
                null
            )
        )
        val result = testWallService.update(
            Post(
                1,
                1,
                1072022,
                "New post number one",
                null,
                null,
                null,
                emptyArray(),
                null,
                Like,
                Repost,
                null,
                null,
                null,
                null,
                null,
                null
            )
        )
        assertTrue(result)
        testWallService.clear()
        testWallService.clearComments()
    }

    @Test
    fun failedUpdate() {
        testWallService.add(
            Post(
                1,
                1,
                1072022,
                "Post number one",
                null,
                null,
                null,
                emptyArray(),
                null,
                Like,
                Repost,
                null,
                null,
                null,
                null,
                null,
                null
            )
        )
        val result = testWallService.update(
            Post(
                3,
                1,
                1072022,
                "Post number one",
                null,
                null,
                null,
                emptyArray(),
                null,
                Like,
                Repost,
                null,
                null,
                null,
                null,
                null,
                null
            )
        )
        assertFalse(result)
        testWallService.clear()
        testWallService.clearComments()
    }

    @Test
    fun commentCreated() {
        testWallService.add(
            Post(
                1,
                1,
                1072022,
                "Post number one",
                null,
                null,
                null,
                emptyArray(),
                null,
                Like,
                Repost,
                null,
                null,
                null,
                null,
                null,
                null
            )
        )
        val result = testWallService.createComment(
            1,
            Comment(id = 1, fromId = 1, date = 20220705, text = "first comment", null, null, null)
        )
        assertTrue(result != null)
        testWallService.clear()
        testWallService.clearComments()
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        testWallService.add(
            Post(
                1,
                1,
                1072022,
                "Post number one",
                null,
                null,
                null,
                emptyArray(),
                null,
                Like,
                Repost,
                null,
                null,
                null,
                null,
                null,
                null
            )
        )
        val comment = Comment(id = 1, fromId = 1, date = 20220705, text = "first comment", null, null, null)
        try { testWallService.createComment(4,comment) } catch (e: PostNotFoundException) {throw PostNotFoundException("catched!")}
        testWallService.clear()
        testWallService.clearComments()
    }
}