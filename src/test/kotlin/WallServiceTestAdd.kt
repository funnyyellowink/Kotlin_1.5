import org.junit.Test
import org.junit.Assert.*
class WallServiceTestAdd {
    @Test
    fun addTestPost() {
        val testWallService = WallService
        val result = testWallService.add(Post(1, 1, "Иван", 21042022, "Первый пост", Like, Repost))
        assertTrue(result.id!=0)
    }
}