package uy.com.temperoni.potato.view

import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import android.view.animation.AlphaAnimation
import android.view.animation.LinearInterpolator
import androidx.appcompat.widget.AppCompatImageView
import uy.com.temperoni.potato.image.ImageHandler

class PotatoImageView(context: Context, attrs: AttributeSet) : AppCompatImageView(context, attrs) {

    private val imageHandler = ImageHandler()

    fun setBitmap(bitmap: Bitmap) {
        setImageBitmap(bitmap)
        startAnimation(AlphaAnimation(0f, 1f).apply {
            interpolator = LinearInterpolator()
            duration = 500
        })
    }

    fun setUrl(url: String) {
        imageHandler.setImage(this, url)
    }
}