package cn.kc.moduleutils.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity

/**
 * 作者： Abel .
 * 日期：2019/8/6
 * 说明：拨打电话和发送短信
 */
object PhoneUtils {
    fun callPhone(context: Context, phoneNum: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        val data = Uri.parse("tel:" + phoneNum)
        intent.setData(data)
        context.startActivity(intent)
    }

    fun sendSMS(context: Context, phoneNum: String) {
        val data = Uri.parse("smsto:" + phoneNum)
        val intent = Intent(Intent.ACTION_SENDTO, data)
        intent.setData(data)
        context.startActivity(intent)
    }
}