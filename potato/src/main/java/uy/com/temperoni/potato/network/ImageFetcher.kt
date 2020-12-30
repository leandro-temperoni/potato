package uy.com.temperoni.potato.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.net.URL


class ImageFetcher {

    suspend fun fetch(urlString: String): Bitmap? {
        return withContext(Dispatchers.IO) {
            val url = URL(urlString)

            try {
                val input: InputStream = url.openStream()
                BitmapFactory.decodeStream(input)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }
}