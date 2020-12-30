package uy.com.temperoni.potato.log

import android.util.Log

class Logger {

    companion object {

        fun logInfo(msg: String) {
            Log.i(Logger::class.simpleName, msg)
        }
    }
}