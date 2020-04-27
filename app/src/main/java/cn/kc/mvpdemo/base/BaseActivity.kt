package cn.kc.moduleutils.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * 作者： 张承堂  .
 * 日期： 2019/4/8
 * 版本： V1.0
 * 说明：
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init(savedInstanceState)
    }

    abstract fun getLayout(): Int

    /**
     * 初始化布局
     */
    private fun init(savedInstanceState: Bundle?) {
        setContentView(getLayout())
        initView(savedInstanceState)
        initData()
    }

    /**
     * 初始化view
     */
    open fun initView(savedInstanceState: Bundle?) {

    }

    /**
     * 初始化数据
     */
    open fun initData() {

    }

    //activity跳转
    fun goActivity(activity: Activity, intentClass: Class<Activity>) {
        val intent = Intent()
        intent.setClass(activity, intentClass)
        startActivity(intent)
    }

}