package cn.kc.mvpdemo.contract

import cn.kc.moduleutils.base.ResultCallback
import cn.kc.mvpdemo.base.BaseContract

/**
 * 作者： Abel .
 * 日期：2019/9/25
 * 说明：
 */
interface MainContract {
    interface Model : BaseContract.Model {
        fun getUserInfo(username: String, callback: ResultCallback<String>)
    }

    interface View : BaseContract.View {
        fun resultUserInfo(result: String)
    }

    interface Presenter : BaseContract.Presenter {
        fun getUserInfo(username: String)
    }
}