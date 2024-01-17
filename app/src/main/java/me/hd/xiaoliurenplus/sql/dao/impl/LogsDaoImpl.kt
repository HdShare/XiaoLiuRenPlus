package me.hd.xiaoliurenplus.sql.dao.impl

import android.annotation.SuppressLint
import android.content.ContentValues
import me.hd.xiaoliurenplus.MainApp
import me.hd.xiaoliurenplus.sql.dao.LogsDao
import me.hd.xiaoliurenplus.sql.entity.Logs

class LogsDaoImpl : LogsDao {

    private val database = MainApp.database

    @SuppressLint("Range")
    override fun queryAll(): MutableList<Logs> {
        val cursor = database.query("logs", null, null, null, null, null, null)
        val logsList = mutableListOf<Logs>()
        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndex("id"))
            val 何时 = cursor.getString(cursor.getColumnIndex("何时"))
            val 类型 = cursor.getInt(cursor.getColumnIndex("类型"))
            val 何事 = cursor.getString(cursor.getColumnIndex("何事"))
            val 排盘 = cursor.getString(cursor.getColumnIndex("排盘"))
            val 日落宫 = cursor.getString(cursor.getColumnIndex("日落宫"))
            val 时落宫 = cursor.getString(cursor.getColumnIndex("时落宫"))
            val 判断 = cursor.getString(cursor.getColumnIndex("判断"))
            val 断语 = cursor.getString(cursor.getColumnIndex("断语"))
            val 反馈 = cursor.getString(cursor.getColumnIndex("反馈"))
            logsList.add(Logs(id, 何时, 类型, 何事, 排盘, 日落宫, 时落宫, 判断, 断语, 反馈))
        }
        cursor.close()
        return logsList
    }

    @SuppressLint("Range")
    override fun queryById(id: Int): Logs {
        val cursor = database.query("logs", null, "id=?", arrayOf(id.toString()), null, null, null)
        var logs = Logs()
        while (cursor.moveToNext()) {
            val 何时 = cursor.getString(cursor.getColumnIndex("何时"))
            val 类型 = cursor.getInt(cursor.getColumnIndex("类型"))
            val 何事 = cursor.getString(cursor.getColumnIndex("何事"))
            val 排盘 = cursor.getString(cursor.getColumnIndex("排盘"))
            val 日落宫 = cursor.getString(cursor.getColumnIndex("日落宫"))
            val 时落宫 = cursor.getString(cursor.getColumnIndex("时落宫"))
            val 判断 = cursor.getString(cursor.getColumnIndex("判断"))
            val 断语 = cursor.getString(cursor.getColumnIndex("断语"))
            val 反馈 = cursor.getString(cursor.getColumnIndex("反馈"))
            logs = Logs(id, 何时, 类型, 何事, 排盘, 日落宫, 时落宫, 判断, 断语, 反馈)
        }
        cursor.close()
        return logs
    }

    override fun insert(logs: Logs): Long {
        val values = ContentValues().apply {
            put("何时", logs.何时)
            put("类型", logs.类型)
            put("何事", logs.何事)
            put("排盘", logs.排盘)
            put("日落宫", logs.日落宫)
            put("时落宫", logs.时落宫)
            put("判断", logs.判断)
            put("断语", logs.断语)
            put("反馈", logs.反馈)
        }
        return database.insert("logs", null, values)
    }

    override fun update(logs: Logs): Int {
        val values = ContentValues().apply {
            put("何时", logs.何时)
            put("类型", logs.类型)
            put("何事", logs.何事)
            put("排盘", logs.排盘)
            put("日落宫", logs.日落宫)
            put("时落宫", logs.时落宫)
            put("判断", logs.判断)
            put("断语", logs.断语)
            put("反馈", logs.反馈)
        }
        return database.update("logs", values, "id=?", arrayOf(logs.id.toString()))
    }

    override fun delete(id: Long): Int {
        return database.delete("logs", "id=?", arrayOf(id.toString()))
    }

    override fun deleteAll(): Int {
        return database.delete("logs", null, null)
    }
}