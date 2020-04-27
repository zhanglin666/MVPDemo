package cn.kc.moduleutils.util

import android.app.Activity
import android.app.ProgressDialog

import java.lang.ref.WeakReference

/**
 * 作者： Abel .
 * 日期：2019/6/6
 * 说明：
 */
object LoadingDialogUtils {
    /**
     * 数据访问等待框
     */
    private var loadingDialog: ProgressDialog? = null
    private var reference: WeakReference<Activity>? = null

    fun init(act: Activity) {
        if (loadingDialog == null || reference == null || reference!!.get() == null || reference!!.get()!!.isFinishing()) {
            reference = WeakReference(act)

            loadingDialog = ProgressDialog(reference!!.get())
            loadingDialog!!.setMessage("加载中...")
            loadingDialog!!.setCancelable(false)
        }
    }

    fun setCancelable(b: Boolean) {
        if (loadingDialog == null) return
        loadingDialog!!.setCancelable(b)
    }

    /**
     * 显示等待框
     */
    fun show(act: Activity) {
        init(act)
        loadingDialog!!.show()
    }

    /**
     * 隐藏等待框
     */
    fun dismiss() {
        if (loadingDialog != null && loadingDialog!!.isShowing) {
            loadingDialog!!.dismiss()
        }
    }


    /**
     * 注销加载框，避免发生内存泄露
     */
    fun unInit() {
        dismiss()
        loadingDialog = null
        reference = null
    }
}
