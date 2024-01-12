package me.hd.xiaoliurenplus.obj.util

import me.hd.xiaoliurenplus.obj.data.五星Data

object 五星Util {
    fun 取五星(日落宫: String, 宫: String): String {
        val 日落宫索引 = 六宫Util.取索引(日落宫)
        val 宫索引 = 六宫Util.取索引(宫)
        return 五星Data.数据[日落宫索引][宫索引]
    }
}