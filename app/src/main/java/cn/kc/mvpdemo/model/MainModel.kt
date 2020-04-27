package cn.kc.mvpdemo.model

import android.util.Log
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
    val mIHttp by lazy {
        MainFactory.getHttpImp()
    }

    override fun getUserInfo(username: String, callback: ResultCallback<String>) {
        //工厂模式   防止更换网络框架时的修改
        mIHttp.getData(username, callback, mDisposables)
    }

    override fun onClear() {
        mDisposables.clear()
    }

}