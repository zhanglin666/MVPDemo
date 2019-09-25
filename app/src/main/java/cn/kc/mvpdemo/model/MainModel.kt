package cn.kc.mvpdemo.model

import cn.kc.moduleutils.base.ResultCallback
import cn.kc.mvpdemo.contract.MainContract
import cn.kc.mvpdemo.utils.ApiService
import cn.kc.mvpdemo.utils.RetrofitUtils
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * 作者： Abel .
 * 日期：2019/9/25
 * 说明：
 */
class MainModel : MainContract.Model {

    private val mDisposables: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun getUserInfo(username: String, callback: ResultCallback<String>) {
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

    override fun onClear() {
        mDisposables.clear()
    }

}