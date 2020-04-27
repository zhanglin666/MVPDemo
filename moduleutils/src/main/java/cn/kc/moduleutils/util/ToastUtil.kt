package cn.kc.moduleutils.util

import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

/**
 * 作者： 张承堂  .
 * 日期： 2019/4/8
 * 版本： V1.0
 * 说明：
 */
class ToastUtil {

    companion object {
        private var toast: Toast? = null

        fun showToast(context: Context, msg: String) {
            if (toast != null) {
                toast!!.cancel()
            }
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
//            val linearLayout: LinearLayout = toast.view as LinearLayout
//            val messageTextView = linearLayout.getChildAt(0) as TextView
//            messageTextView.setTextSize(30F)
            toast!!.show()
        }

        fun hideToast() {
            if (toast != null) {
                toast!!.cancel()
            }
        }
    }
}