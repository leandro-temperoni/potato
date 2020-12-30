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

class ImageHandler {

    fun setImage(view: ImageView, url: String) {
        GlobalScope.launch(Dispatchers.Main) {

            var bitmap: Bitmap? = FileHandler()
                .readToInternalStorage(view.context, url)

            if (bitmap == null) {
                withContext(Dispatchers.IO) {
                    bitmap = ImageFetcher().fetch(url)
                    FileHandler()
                        .saveToInternalStorage(view.context, bitmap, url)
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
        view: ImageView,
        bitmap: Bitmap
    ) {
        with(view) {
            setImageBitmap(bitmap)
            startAnimation(AlphaAnimation(0f, 1f).apply {
                interpolator = LinearInterpolator()
                duration = 500
            })
        }
    }
}