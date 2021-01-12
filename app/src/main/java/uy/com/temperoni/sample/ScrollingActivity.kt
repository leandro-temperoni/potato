package uy.com.temperoni.sample

import android.os.Bundle
import android.widget.Button
import com.google.android.material.appbar.CollapsingToolbarLayout
import androidx.appcompat.app.AppCompatActivity
import uy.com.temperoni.potato.image.ImageHandler
import uy.com.temperoni.potato.PotatoController
import uy.com.temperoni.potato.view.PotatoImageView

class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title

        findViewById<Button>(R.id.clean_cache).setOnClickListener {
            PotatoController.clearCache(this)
        }

        findViewById<PotatoImageView>(R.id.image_view_one).setUrl("https://firebasestorage.googleapis.com/v0/b/recipes-cb2a2.appspot.com/o/Budin%20de%20banana.jpeg?alt=media&token=9a977f9e-1711-4a92-b370-d2480acaf76a")
        findViewById<PotatoImageView>(R.id.image_view_two).setUrl("https://upload.wikimedia.org/wikipedia/commons/a/a1/Miniature_pinscher.jpg")
        findViewById<PotatoImageView>(R.id.image_view_three).setUrl("https://e00-marca.uecdn.es/assets/multimedia/imagenes/2020/12/28/16091889732831.jpg")
        findViewById<PotatoImageView>(R.id.image_view_four).setUrl("https://fotografias.antena3.com/clipping/cmsimages02/2020/06/30/EE3F00B4-6C38-48A1-853A-8BB703144E59/14.jpg")
    }
}