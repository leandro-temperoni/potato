package uy.com.temperoni.potato

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat.JPEG
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.net.URLEncoder

class FileHandler {

    companion object {

        fun deleteCachedFiles(context: Context) {
            val cacheFolder = getCacheFolder(context)

            val msg = if (cacheFolder?.deleteRecursively() == true) {
                "Cache cleared"
            } else {
                "Error while clearing cache"
            }

            Log.i(FileHandler::class.simpleName, msg)
        }

        private fun getCacheFolder(context: Context): File? {
            val wrapper = ContextWrapper(context)
            return wrapper.getDir("images", Context.MODE_PRIVATE)
        }
    }

    fun saveToInternalStorage(
        context: Context,
        bitmap: Bitmap?,
        url: String
    ) {
        if (bitmap == null) {
            return
        }

        val encodedURL = encodeUrl(url) ?: return

        val file = File(getCacheFolder(context), "${encodedURL}.jpg")

        try {
            val stream: OutputStream = FileOutputStream(file)

            bitmap.compress(JPEG, 100, stream)

            stream.flush()

            stream.close()

            Log.i(javaClass.simpleName, "Image saved to cache: ${Uri.parse(file.absolutePath)}")
        } catch (e: IOException) {
            Log.i(javaClass.simpleName, "Error while saving image to cache: ${e.message}")
        }
    }

    fun readToInternalStorage(
        context: Context,
        url: String
    ): Bitmap? {
        val encodedURL = encodeUrl(url) ?: return null

        val file = File(getCacheFolder(context), "${encodedURL}.jpg")

        Log.i(javaClass.simpleName, "Image fetched from cache: ${Uri.parse(file.absolutePath)}")

        return BitmapFactory.decodeFile(file.path, null)
    }

    private fun encodeUrl(url: String): String? {
        return URLEncoder.encode(url, "UTF-8")
    }
}