package cn.kc.mvpdemo.presenter

import cn.kc.moduleutils.base.ResultCallback
import cn.kc.mvpdemo.contract.MainContract
import cn.kc.mvpdemo.model.MainModel

/**
 * 作者： Abel .
 * 日期：2019/9/25
 * 说明：
 */
class MainPresenter(private val mView: MainContract.View) : MainContract.Presenter {
    private val mModel: MainContract.Model

    init {
        mModel = MainModel()
    }

    override fun getUserInfo(username: String) {
        mView.showProgressDialog()
//        mModel.getUserInfo(username,this)
        mModel.getUserInfo(username, object : ResultCallback<String> {
            override fun onSuccess(result: String) {
                mView.dismissProgressDialog()
                mView.resultUserInfo(result)
            }

            override fun onFail(msg: String) {
                mView.dismissProgressDialog()
                mView.onFail(msg)
            }
        })
    }

    override fun onClear() {
        mModel.onClear()
    }

}