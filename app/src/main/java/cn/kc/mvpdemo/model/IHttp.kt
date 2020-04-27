package cn.kc.mvpdemo.model

import cn.kc.moduleutils.base.ResultCallback
import io.reactivex.disposables.CompositeDisposable

/**
 * 作者： Abel .
 * 日期：2020/4/10
 * 说明：网络请求接口规范
 */
interface IHttp {
    fun getData(username: String, callback: ResultCallback<String>, mDisposables: CompositeDisposable)
}