package me.hd.xiaoliurenplus.obj.util

import me.hd.xiaoliurenplus.obj.data.五行Data

object 五行Util {
    fun 取时五行(时地支: String): String {
        return when (时地支) {
            "子" -> "水"
            "丑" -> "土"
            "寅" -> "木"
            "卯" -> "木"
            "辰" -> "土"
            "巳" -> "火"
            "午" -> "火"
            "未" -> "土"
            "申" -> "金"
            "酉" -> "金"
            "戌" -> "土"
            "亥" -> "水"
            else -> "error"
        }
    }

    fun 取宫五行(宫位: String): String {
        return when (宫位) {
            "大安" -> "木"
            "留恋" -> "水"
            "速喜" -> "火"
            "赤口" -> "金"
            "小吉" -> "木"
            "空亡" -> "土"
            else -> "error"
        }
    }

    fun 取索引(行: String): Int {
        return 五行Data.数据.indexOf(行)
    }
}