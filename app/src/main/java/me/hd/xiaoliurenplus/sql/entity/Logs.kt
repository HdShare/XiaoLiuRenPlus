package me.hd.xiaoliurenplus.sql.entity

import me.hd.xiaoliurenplus.utils.DateUtil

data class Logs(
    val id: Int = -1,
    val 何时: String = DateUtil.getNowDateStr(),
    val 类型: Int = -1,
    val 何事: String = "",
    val 排盘: String = "",
    val 日落宫: String = "",
    val 时落宫: String = "",
    var 判断: String = "",
    var 断语: String = "",
    var 反馈: String = ""
)