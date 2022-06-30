import org.junit.Test
import org.junit.Assert.*

class WallServiceTestUpdateSuccessful {
    @Test
    fun successfulUpdate() {
        val testWallService = WallService
        testWallService.add(Post(1,1,"Иван",21042022,"Первый пост",Like,Repost))
        val result = testWallService.update(Post(1,1,"Иван",21042022,"Измененный первый пост",Like,Repost))
        assertTrue(result)
    }
}