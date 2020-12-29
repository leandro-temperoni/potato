package uy.com.temperoni.potato

import android.graphics.Bitmap
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

    }

    private fun onSuccess(
        view: ImageView,
        bitmap: Bitmap
    ) {
        view.setImageBitmap(bitmap)
    }
}