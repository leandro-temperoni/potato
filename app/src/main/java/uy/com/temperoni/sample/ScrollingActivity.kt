package uy.com.temperoni.sample

import android.os.Bundle
import android.widget.Button
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import uy.com.temperoni.potato.ImageHandler
import uy.com.temperoni.potato.PotatoController

class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title

        val imageHandler = ImageHandler()

        findViewById<Button>(R.id.clean_cache).setOnClickListener {
            PotatoController.clearCache(this)
        }

        findViewById<Button>(R.id.clean_cache).setOnClickListener {
            PotatoController.clearCache(this)
        }

        imageHandler.setImage(findViewById(R.id.image_view_one), "https://firebasestorage.googleapis.com/v0/b/recipes-cb2a2.appspot.com/o/Budin%20de%20banana.jpeg?alt=media&token=9a977f9e-1711-4a92-b370-d2480acaf76a")
        imageHandler.setImage(findViewById(R.id.image_view_two), "https://upload.wikimedia.org/wikipedia/commons/a/a1/Miniature_pinscher.jpg")
        imageHandler.setImage(findViewById(R.id.image_view_three), "https://e00-marca.uecdn.es/assets/multimedia/imagenes/2020/12/28/16091889732831.jpg")
        imageHandler.setImage(findViewById(R.id.image_view_four), "https://fotografias.antena3.com/clipping/cmsimages02/2020/06/30/EE3F00B4-6C38-48A1-853A-8BB703144E59/14.jpg")
    }
}