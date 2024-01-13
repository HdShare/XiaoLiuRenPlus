package me.hd.xiaoliurenplus.utils

import me.hd.xiaoliurenplus.obj.bean.排盘Bean
import me.hd.xiaoliurenplus.obj.util.*

object Test {

    @JvmStatic
    fun 取日落宫(日: Int): String {
        return 六宫Util.取日落宫(日)
    }

    @JvmStatic
    fun 取时地支位置(时地支: String): Int {
        return 地支Util.取时地支位置(时地支)
    }

    @JvmStatic
    fun 取时落宫(日: Int, 时地支位置: Int): String {
        return 六宫Util.取时落宫(日, 时地支位置)
    }

    @JvmStatic
    fun 取盘列表(日落宫: String, 时地支: String, 时落宫: String): MutableList<排盘Bean> {
        return 排盘Util.取盘列表(日落宫, 时地支, 时落宫)
    }

}