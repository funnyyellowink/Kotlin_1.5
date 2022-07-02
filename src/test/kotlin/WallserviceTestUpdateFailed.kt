import org.junit.Test
import org.junit.Assert.*

class WallserviceTestUpdateFailed {
    @Test
    fun failedUpdate() {
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
            null
        ))
        assertFalse(result)
    }
}