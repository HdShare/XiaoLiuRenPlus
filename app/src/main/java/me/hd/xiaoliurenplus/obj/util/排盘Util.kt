package me.hd.xiaoliurenplus.obj.util

import me.hd.xiaoliurenplus.obj.bean.排盘Bean

object 排盘Util {
    fun 初始化宫位(): MutableList<排盘Bean> {
        val 六宫 = listOf("大安", "留恋", "速喜", "赤口", "小吉", "空亡")
        return 六宫.map { 排盘Bean(宫位 = it) }.toMutableList()
    }

    fun 加载地支五行(盘列表: MutableList<排盘Bean>, 时地支: String, 时落宫: String) {
        for (盘对象 in 盘列表) {
            val 地支 = 地支Util.取地支(时地支, 时落宫, 盘对象.宫位)
            val 地支五行 = 五行Util.取时五行(地支)
            盘对象.地支 = 地支
            盘对象.五行 = 地支五行
        }
    }

    fun 取土数量(盘列表: MutableList<排盘Bean>): Int {
        return 盘列表.count { it.五行 == "土" }
    }

    fun 取顺时针最近土索引(盘列表: MutableList<排盘Bean>, 时落宫: String): Int {
        val index = 盘列表.indexOfFirst { it.宫位 == 时落宫 }
        for (i in 1 until 盘列表.size) {
            val nextIndex = (index + i) % 盘列表.size
            if (盘列表[nextIndex].五行 == "土") {
                return (nextIndex + 1) % 盘列表.size
            }
        }
        return -1
    }

    fun 加载六亲(盘列表: MutableList<排盘Bean>, 时地支: String, 时落宫: String) {
        val 自身五行 = 五行Util.取时五行(时地支)
        val 土数量 = 取土数量(盘列表)
        val 最近土索引 = 取顺时针最近土索引(盘列表, 时落宫)
        for (盘对象 in 盘列表) {
            if (盘对象.宫位 == 时落宫) {
                盘对象.六亲 = "自身" + "\n" + 六亲Util.取六亲(自身五行, 五行Util.取宫五行(时落宫))
            } else {
                val 地支索引 = 六宫Util.取索引(盘对象.宫位)
                if ((土数量 == 2) and (地支索引 == 最近土索引)) {
                    盘对象.六亲 = "兄弟"
                } else {
                    盘对象.六亲 = 六亲Util.取六亲(自身五行, 盘对象.五行)
                }
            }
        }
    }

    fun 加载神星(盘列表: MutableList<排盘Bean>, 时地支: String, 日落宫: String) {
        for (盘对象 in 盘列表) {
            val 青龙落宫 = 六神Util.取青龙落宫(时地支)
            val 六神 = 六神Util.取六神(青龙落宫, 盘对象.宫位)
            val 五星 = 五星Util.取五星(日落宫, 盘对象.宫位)
            盘对象.六神 = 六神
            盘对象.五星 = 五星
        }
    }

    fun 取盘列表(日落宫: String, 时地支: String, 时落宫: String): MutableList<排盘Bean> {
        val 盘列表 = 初始化宫位()
        加载地支五行(盘列表, 时地支, 时落宫)
        加载六亲(盘列表, 时地支, 时落宫)
        加载神星(盘列表, 时地支, 日落宫)
        return 盘列表
    }
}