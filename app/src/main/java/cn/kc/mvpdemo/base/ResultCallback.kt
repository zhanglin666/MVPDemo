package cn.kc.moduleutils.base

/**
 * 作者： Abel .
 * 日期：2019/9/20
 * 说明：
 */
interface ResultCallback<T> {

    fun onSuccess(result: T)

    fun onFail(msg: String)
}
