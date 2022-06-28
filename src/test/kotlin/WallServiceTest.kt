import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addTestPost() {
        val testWallService = WallService
        val result = testWallService.add(Post(1, 1, "Иван", 21042022, "Первый пост", Like, Repost))
        assertTrue(result.id!=0)
    }

    @Test
    fun successfulUpdate() {
        val testWallService = WallService
        testWallService.add(Post(1,1,"Иван",21042022,"Первый пост",Like,Repost))
        val result = testWallService.update(Post(1,1,"Иван",21042022,"Измененный первый пост",Like,Repost))
        assertTrue(result)
    }

    @Test
    fun failedUpdate() {
        val testWallService = WallService
        testWallService.add(Post(1,1,"Иван",21042022,"Первый пост",Like,Repost))
        val result = testWallService.update(Post(2,1,"Иван",21042022,"Измененный первый пост",Like,Repost))
        assertFalse(result)
    }
}