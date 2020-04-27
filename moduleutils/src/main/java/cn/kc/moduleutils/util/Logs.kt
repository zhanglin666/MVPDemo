package cn.kc.moduleutils.util

import android.util.Log

/**
 * 作者： 张承堂  .
 * 日期： 2019/4/8
 * 版本： V1.0
 * 说明：
 */
object Logs {
    private val msg = "log_info"
    fun e(value: String) {
        Log.e(msg, value)
    }
}