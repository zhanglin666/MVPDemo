package cn.kc.mvpdemo.model

import cn.kc.moduleutils.base.ResultCallback
import cn.kc.mvpdemo.utils.ApiService
import cn.kc.mvpdemo.utils.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * 作者： Abel .
 * 日期：2020/4/10
 * 说明：
 */
class HttpImp : IHttp {

    override fun getData(
        username: String, callback: ResultCallback<String>,
        mDisposables: CompositeDisposable
    ) {
        RetrofitUtils.setBaseUrl("https://api.github.com/")
        val disposable = RetrofitUtils.instance!!.getApiServier(ApiService::class.java)
            .getUserInfo(username)
            .subscribeOn(Schedulers.io())
            .map {
                return@map it.string()
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    callback.onSuccess(it.toString())
                },
                {
                    callback.onFail(throw Throwable(it.message))
                }
            )
        mDisposables.add(disposable)
    }
}