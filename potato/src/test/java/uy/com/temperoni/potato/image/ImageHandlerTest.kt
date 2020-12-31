package uy.com.temperoni.potato.image

import BaseTest
import android.graphics.Bitmap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.isA
import org.mockito.Mockito.*
import uy.com.temperoni.potato.view.PotatoImageView

@ExperimentalCoroutinesApi
class ImageHandlerTest : BaseTest() {

    private val imageHandler = ImageHandler()
    private val view: PotatoImageView = mock(PotatoImageView::class.java)

    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testCoroutineDispatcher)
    }

    @Test
    fun addition_isCorrect() = runBlockingTest {
        imageHandler.setImage(view, "url")

        verify(view).setBitmap(isA(Bitmap::class.java))
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testCoroutineDispatcher.cleanupTestCoroutines()
    }
}