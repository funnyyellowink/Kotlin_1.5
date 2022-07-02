import org.junit.Test
import org.junit.Assert.*
class WallServiceTestAdd {
    @Test
    fun addTestPost() {
        val testWallService = WallService
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
            null
        ))
        assertTrue(result.id!=0)
    }
}