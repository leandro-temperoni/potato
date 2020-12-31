package uy.com.temperoni.potato.image

import android.graphics.Bitmap
import android.view.animation.AlphaAnimation
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uy.com.temperoni.potato.cache.FileHandler
import uy.com.temperoni.potato.log.Logger
import uy.com.temperoni.potato.network.ImageFetcher
import uy.com.temperoni.potato.view.PotatoImageView

class ImageHandler {

    private val fileHandler = FileHandler()
    private val imageFetcher = ImageFetcher()

    fun setImage(view: PotatoImageView, url: String) {
        GlobalScope.launch(Dispatchers.Main) {
            var bitmap: Bitmap?

            withContext(Dispatchers.IO) {
                bitmap = fileHandler.readToInternalStorage(view.context, url)

                if (bitmap == null) {
                    bitmap = imageFetcher.fetch(url)
                    fileHandler.saveToInternalStorage(view.context, bitmap, url)
                }
            }

            bitmap?.let {
                onSuccess(view, it)
            } ?: onError()
        }
    }

    private fun onError() {
        Logger.logInfo("Error while downloading image")
    }

    private fun onSuccess(
        view: PotatoImageView,
        bitmap: Bitmap
    ) {
        view.setBitmap(bitmap)
    }
}