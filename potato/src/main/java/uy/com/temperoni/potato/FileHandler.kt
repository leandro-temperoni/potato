package uy.com.temperoni.potato

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat.JPEG
import android.graphics.BitmapFactory
import android.net.Uri
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class FileHandler {

    fun saveToInternalStorage(
        context: Context,
        bitmap: Bitmap?,
        url: String
    ): Uri? {

        if (bitmap == null) {
            return null
        }

        val wrapper = ContextWrapper(context)

        var file = wrapper.getDir("images", Context.MODE_PRIVATE)

        file = File(file, "${url}.jpg")

        return try {
            val stream: OutputStream = FileOutputStream(file)

            bitmap.compress(JPEG, 100, stream)

            stream.flush()

            stream.close()

            Uri.parse(file.absolutePath)
        } catch (e: IOException) { // catch the exception
            e.printStackTrace()
            null
        }
    }

    fun readToInternalStorage(
        context: Context,
        url: String
    ): Bitmap? {
        val wrapper = ContextWrapper(context)

        var file = wrapper.getDir("images", Context.MODE_PRIVATE)

        file = File(file, "${url}.jpg")

        return BitmapFactory.decodeFile(file.path, null)
    }
}