package me.hd.xiaoliurenplus.obj.util

import me.hd.xiaoliurenplus.obj.data.六亲Data

object 六亲Util {
    fun 取六亲(自身五行: String, 地支五行: String): String {
        val 自身索引 = 五行Util.取索引(自身五行)
        val 地支索引 = 五行Util.取索引(地支五行)
        return 六亲Data.数据[自身索引][地支索引]
    }
}