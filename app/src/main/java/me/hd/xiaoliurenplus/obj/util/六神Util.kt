package me.hd.xiaoliurenplus.obj.util

import me.hd.xiaoliurenplus.obj.data.六宫Data
import me.hd.xiaoliurenplus.obj.data.六神Data

object 六神Util {
    fun 取青龙落宫(时地支: String): String {
        return when (时地支) {
            "子", "午" -> 六宫Data.数据[1]
            "丑", "未" -> 六宫Data.数据[2]
            "寅", "申" -> 六宫Data.数据[3]
            "卯", "酉" -> 六宫Data.数据[4]
            "辰", "戌" -> 六宫Data.数据[5]
            "巳", "亥" -> 六宫Data.数据[0]
            else -> "error"
        }
    }

    fun 取六神(青龙落宫: String, 宫: String): String {
        val 青龙索引 = 六宫Util.取索引(青龙落宫)
        val 宫索引 = 六宫Util.取索引(宫)
        return 六神Data.数据[青龙索引][宫索引]
    }
}