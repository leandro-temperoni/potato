package uy.com.temperoni.potato.view

import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import android.view.animation.AlphaAnimation
import android.view.animation.LinearInterpolator
import androidx.appcompat.widget.AppCompatImageView

class PotatoImageView(context: Context, attrs: AttributeSet) : AppCompatImageView(context, attrs) {

    fun setBitmap(bitmap: Bitmap) {
        setImageBitmap(bitmap)
        startAnimation(AlphaAnimation(0f, 1f).apply {
            interpolator = LinearInterpolator()
            duration = 500
        })
    }
}