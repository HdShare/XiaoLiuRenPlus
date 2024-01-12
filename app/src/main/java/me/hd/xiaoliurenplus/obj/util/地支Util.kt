package me.hd.xiaoliurenplus.obj.util

import me.hd.xiaoliurenplus.obj.data.地支Data

object 地支Util {
    fun 取时地支(时: Int): String {
        return when (时) {
            23, 0 -> 地支Data.默认[0]
            1, 2 -> 地支Data.默认[1]
            3, 4 -> 地支Data.默认[2]
            5, 6 -> 地支Data.默认[3]
            7, 8 -> 地支Data.默认[4]
            9, 10 -> 地支Data.默认[5]
            11, 12 -> 地支Data.默认[6]
            13, 14 -> 地支Data.默认[7]
            15, 16 -> 地支Data.默认[8]
            17, 18 -> 地支Data.默认[9]
            19, 20 -> 地支Data.默认[10]
            21, 22 -> 地支Data.默认[11]
            else -> "error"
        }
    }

    fun 取刻地支(时: Int, 分: Int): String {
        return if (时 % 2 == 1) {
            when (分) {
                in 0..10 -> 地支Data.默认[0]
                in 11..20 -> 地支Data.默认[1]
                in 21..30 -> 地支Data.默认[2]
                in 31..40 -> 地支Data.默认[3]
                in 41..50 -> 地支Data.默认[4]
                in 51..59 -> 地支Data.默认[5]
                else -> "error"
            }
        } else {
            when (分) {
                in 0..10 -> 地支Data.默认[6]
                in 11..20 -> 地支Data.默认[7]
                in 21..30 -> 地支Data.默认[8]
                in 31..40 -> 地支Data.默认[9]
                in 41..50 -> 地支Data.默认[10]
                in 51..59 -> 地支Data.默认[11]
                else -> "error"
            }
        }
    }

    fun 取时地支位置(时地支: String): Int {
        return 地支Data.默认.indexOf(时地支) + 1
    }

    fun 取地支(时地支: String, 时落宫: String, 宫: String): String {
        val 时地支索引 = 取索引(时地支)
        val 时落宫索引 = 六宫Util.取索引(时落宫)
        val 宫索引 = 六宫Util.取索引(宫)
        return 地支Data.数据[时地支索引][时落宫索引][宫索引]
    }

    fun 取索引(地支: String): Int {
        return 地支Data.默认.indexOf(地支)
    }
}