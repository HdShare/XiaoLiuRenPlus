package me.hd.xiaoliurenplus.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

object DateUtil {
    @SuppressLint("SimpleDateFormat")
    fun getNowDateStr(): String {
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
    }
}