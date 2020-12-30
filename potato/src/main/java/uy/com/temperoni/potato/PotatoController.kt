package uy.com.temperoni.potato

import android.content.Context
import uy.com.temperoni.potato.cache.FileHandler

class PotatoController {

    companion object {

        fun clearCache(context: Context) {
            FileHandler.deleteCachedFiles(context)
        }
    }
}