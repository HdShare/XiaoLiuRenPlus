package me.hd.xiaoliurenplus

import android.app.Application
import android.database.sqlite.SQLiteDatabase
import com.google.gson.Gson
import me.hd.xiaoliurenplus.sql.dao.impl.LogsDaoImpl
import me.hd.xiaoliurenplus.sql.db.LogsDb

class MainApp : Application() {
    companion object {
        lateinit var context: Application
        lateinit var gson: Gson
        lateinit var database: SQLiteDatabase
        lateinit var logsDao: LogsDaoImpl
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        gson = Gson()
        database = LogsDb(this).writableDatabase
        logsDao = LogsDaoImpl()
    }
}