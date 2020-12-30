package uy.com.temperoni.potato

import android.content.Context

class PotatoController {

    companion object {

        fun clearCache(context: Context) {
            FileHandler.deleteCachedFiles(context)
        }
    }
}