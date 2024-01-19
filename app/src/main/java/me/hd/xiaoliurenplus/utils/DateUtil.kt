package me.hd.xiaoliurenplus.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

object DateUtil {
    @SuppressLint("SimpleDateFormat")
    fun getNowDateStr(): String {
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
    }

    fun getYear(): Int {
        val cd = Calendar.getInstance()
        return cd[Calendar.YEAR]
    }

    fun getMonth(): Int {
        val cd = Calendar.getInstance()
        return cd[Calendar.MONTH] + 1
    }

    fun getDay(): Int {
        val cd = Calendar.getInstance()
        return cd[Calendar.DATE]
    }

    fun getHour(): Int {
        val cd = Calendar.getInstance()
        return cd[Calendar.HOUR_OF_DAY]
    }

    fun getMinute(): Int {
        val cd = Calendar.getInstance()
        return cd[Calendar.MINUTE]
    }
}