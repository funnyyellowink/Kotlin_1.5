import org.junit.Test
import org.junit.Assert.*
class WallServiceTest {
    private val testWallService = WallService

    @Test
    fun addTestPost() {
        val result = testWallService.add(Post(1,
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
            null
        ))
        assertTrue(result.id!=0)
        testWallService.clear()
    }

    @Test
    fun successfulUpdate() {
        testWallService.add(Post(1,
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
            null
        ))
        val result = testWallService.update(Post(1,
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
        ))
        assertTrue(result)
        testWallService.clear()
    }
    @Test
    fun failedUpdate() {
        testWallService.add(Post(1,
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
            null
        ))
        val result = testWallService.update(Post(3,
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
            null
        ))
        assertFalse(result)
        testWallService.clear()
    }
}