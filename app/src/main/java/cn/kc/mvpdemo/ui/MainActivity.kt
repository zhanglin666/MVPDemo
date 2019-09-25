package cn.kc.mvpdemo.ui

import android.os.Bundle
import cn.kc.moduleutils.base.BaseActivity
import cn.kc.mvpdemo.R
import cn.kc.mvpdemo.base.BaseMvpActivity
import cn.kc.mvpdemo.contract.MainContract
import cn.kc.mvpdemo.presenter.MainPresenter
import kotlinx.android.synthetic.main.act_main.*

/**
 * 作者： Abel .
 * 日期：2019/9/25
 * 说明：
 */
class MainActivity : BaseMvpActivity<MainContract.Presenter>(), MainContract.View {

    override fun getLayout() = R.layout.act_main

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        btn_click.setOnClickListener {
            mPresenter.getUserInfo("zhanglin")
        }
    }

    override fun createPresenter(): MainContract.Presenter {
        return MainPresenter(this)
    }

    override fun resultUserInfo(result: String) {
        txt_view.setText(result)
    }

    override fun onFail(msg: String?) {
        txt_view.setText(msg)
    }
}