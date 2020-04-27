package cn.kc.mvpdemo.utils

import android.content.Context
import android.widget.Toast

/**
 * 作者： Abel .
 * 日期：2020/4/13
 * 说明：Toast提示信息
 */
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
