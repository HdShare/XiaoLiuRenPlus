package me.hd.xiaoliurenplus

import android.app.Application
import android.content.Context

class MainApp : Application() {
    companion object {
        var context: Application? = null
        fun getContext(): Context {
            return context!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }

    private fun helloWorld() {
        println("Hello World!")
    }
}