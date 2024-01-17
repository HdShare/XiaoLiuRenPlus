package me.hd.xiaoliurenplus.sql.dao

import me.hd.xiaoliurenplus.sql.entity.Logs

interface LogsDao {
    fun queryAll(): MutableList<Logs>

    fun queryById(id: Int): Logs

    fun insert(logs: Logs): Long

    fun update(logs: Logs): Int

    fun delete(id: Long): Int

    fun deleteAll(): Int
}