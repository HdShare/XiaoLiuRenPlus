package me.hd.xiaoliurenplus.obj.bean

data class 农历Bean(
    val lYear: Int,         // 农历年
    val lMonth: Int,        // 农历月
    val lDay: Int,          // 农历日
    val Animal: String,     // 生肖
    val IMonthCn: String,   // 中文农历月
    val IDayCn: String,     // 中文农历日
    val cYear: Int,         // 公历年
    val cMonth: Int,        // 公历月
    val cDay: Int,          // 公历日
    val gzYear: String,     // 干支年
    val gzMonth: String,    // 干支月
    val gzDay: String,      // 干支日
    val isToday: Boolean,   // 是否是今天
    val isLeap: Boolean,    // 是否是闰月
    val nWeek: Int,         // 当前日是一周中的第几天
    val ncWeek: String,     // 中文星期
    val isTerm: Boolean,    // 是否是节气
    val Term: String? = null// 节气
)