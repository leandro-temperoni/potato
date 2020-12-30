package uy.com.temperoni.potato

import android.R
import android.graphics.Bitmap
import android.util.Log
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.ImageView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ImageHandler {

    fun setImage(view: ImageView, url: String) {
        GlobalScope.launch(Dispatchers.Main) {

            var bitmap: Bitmap? = FileHandler().readToInternalStorage(view.context, url)

            if (bitmap == null) {
                withContext(Dispatchers.IO) {
                    bitmap = UrlHandler().fetchImage(url)
                    FileHandler().saveToInternalStorage(view.context, bitmap, url)
                }
            }

            bitmap?.let {
                onSuccess(view, it)
            } ?: onError()
        }
    }

    private fun onError() {
        Log.i(javaClass.simpleName, "Error while downloading image")
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