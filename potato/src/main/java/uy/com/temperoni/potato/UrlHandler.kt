package uy.com.temperoni.potato

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.net.URL


class UrlHandler {

    suspend fun fetchImage(urlString: String): Bitmap? {
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