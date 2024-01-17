package me.hd.xiaoliurenplus.sql.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class LogsDb(context: Context) :
    SQLiteOpenHelper(context, "logs.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "create table logs" +
                    "(" +
                    "id integer primary key autoincrement not null," +
                    "何时 varchar(50)," +
                    "何事 varchar(50)," +
                    "类型 integer," +
                    "排盘 text," +
                    "日落宫 varchar(50)," +
                    "时落宫 varchar(50)," +
                    "判断 varchar(50)," +
                    "断语 text," +
                    "反馈 text" +
                    ")"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }
}