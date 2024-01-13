package me.hd.xiaoliurenplus.obj.util

object 颜色Util {

    fun 取宫位颜色(宫位: String): Int {
        return when (宫位) {
            "空亡" -> 0xFF8B4513
            "大安" -> 0xFF228B22
            "留恋" -> 0xFF1E90FF
            "速喜" -> 0xFFFF4500
            "赤口" -> 0xFFFFD700
            "小吉" -> 0xFF228B22
            else -> 0xFF000000
        }.toInt()
    }

    fun 取五行颜色(五行: String): Int {
        return when (五行) {
            "金" -> 0xFFFFD700
            "木" -> 0xFF228B22
            "水" -> 0xFF1E90FF
            "火" -> 0xFFFF4500
            "土" -> 0xFF8B4513
            else -> 0xFF000000
        }.toInt()
    }

    fun 取落宫颜色(): Int {
        return (0xFFFF0000).toInt()
    }

    fun 取六亲颜色(六亲: String): Int {
        return when (六亲) {
            "父母" -> 0xFF9000D0
            "子孙" -> 0xFF9000D0
            "官鬼" -> 0xFF9000D0
            "妻财" -> 0xFF9000D0
            "兄弟" -> 0xFF9000D0
            else -> 0xFFFF0000
        }.toInt()
    }

    fun 取五星颜色(五星: String): Int {
        return when (五星) {
            "天空" -> 0xFF666666
            "木星" -> 0xFF228B22
            "火星" -> 0xFFFF4500
            "土星" -> 0xFF8B4513
            "金星" -> 0xFFFFD700
            "水星" -> 0xFF1E90FF
            else -> 0xFF000000
        }.toInt()
    }

    fun 取六神颜色(六神: String): Int {
        return when (六神) {
            "青龙" -> 0xFF228B22
            "朱雀" -> 0xFFFF0000
            "勾陈" -> 0xFF8B4513
            "白虎" -> 0xFFFFD700
            "玄武" -> 0xFF1E90FF
            "腾蛇" -> 0xFF8B4513
            else -> 0xFF000000
        }.toInt()
    }

}