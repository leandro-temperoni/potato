package uy.com.temperoni.sample

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import uy.com.temperoni.potato.ImageHandler

class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            ImageHandler().setImage(findViewById(R.id.image_view), "https://firebasestorage.googleapis.com/v0/b/recipes-cb2a2.appspot.com/o/Budin%20de%20banana.jpeg?alt=media&token=9a977f9e-1711-4a92-b370-d2480acaf76a")
        }
    }
}