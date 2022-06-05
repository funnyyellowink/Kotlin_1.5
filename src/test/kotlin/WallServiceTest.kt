import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addTestPost() {
        val testWallService = WallService
        val result = testWallService.add(Post(1, 1, "Иван", 21042022, "Первый пост", Like, Repost))
        assertTrue(result)
    }

    @Test
    fun likeAndRepost() {
        val testWallService = WallService
        testWallService.add(Post(1,1,"Иван",21042022,"Первый пост",Like,Repost))
        val result = testWallService.likeAndRepost(1,"Измененный текст")
        assertTrue(result)
    }
}