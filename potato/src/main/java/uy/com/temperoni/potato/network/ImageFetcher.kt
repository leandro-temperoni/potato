package uy.com.temperoni.potato.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.InputStream
import java.net.URL

class ImageFetcher {

    fun fetch(urlString: String): Bitmap? {
        val url = URL(urlString)

        return try {
            val input: InputStream = url.openStream()
            BitmapFactory.decodeStream(input)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}