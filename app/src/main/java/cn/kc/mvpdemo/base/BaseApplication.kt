package cn.kc.moduleutils.base

import android.app.Application
import android.content.Context

/**
 * 作者：   .
 * 日期： 2019/4/8
 * 版本： V1.0
 * 说明：
 */
open class BaseApplication : Application() {
    var isDebug: Boolean = true

    companion object {
        var mContext: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        mContext = applicationContext
    }

}