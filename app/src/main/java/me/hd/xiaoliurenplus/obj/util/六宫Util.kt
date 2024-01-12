package me.hd.xiaoliurenplus.obj.util

import me.hd.xiaoliurenplus.obj.data.六宫Data

object 六宫Util {
    fun 取日落宫(日: Int): String {
        return 六宫Data.数据[日 % 6]
    }

    fun 取时落宫(日: Int, 时地支位置: Int): String {
        return 六宫Data.数据[(日 % 6 + (时地支位置 % 6 + 5)) % 6]
    }

    fun 取索引(宫: String): Int {
        return 六宫Data.数据.indexOf(宫)
    }
}