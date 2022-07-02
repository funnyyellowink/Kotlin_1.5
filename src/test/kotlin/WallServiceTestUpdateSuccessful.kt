import org.junit.Test
import org.junit.Assert.*

class WallServiceTestUpdateSuccessfulUpdateSuccess {
    @Test
    fun successfulUpdate() {
        val testWallService = WallService
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
            null
        ))
        assertTrue(result)
    }
}