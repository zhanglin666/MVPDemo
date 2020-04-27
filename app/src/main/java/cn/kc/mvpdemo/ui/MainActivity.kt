package cn.kc.mvpdemo.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.edit
import cn.kc.moduleutils.base.BaseActivity
import cn.kc.mvpdemo.R
import cn.kc.mvpdemo.base.BaseMvpActivity
import cn.kc.mvpdemo.contract.MainContract
import cn.kc.mvpdemo.glide.GlideActivity
import cn.kc.mvpdemo.presenter.MainPresenter
import cn.kc.mvpdemo.utils.toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.act_main.*
import java.util.jar.Manifest

/**
 * 作者： Abel .
 * 日期：2019/9/25
 * 说明：mvp模式调用github登录
 * 添加sharedpreferce简易调用方法
 */
class MainActivity : BaseMvpActivity<MainContract.Presenter>(), MainContract.View {
    override fun getLayout() = R.layout.act_main

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)

        getSharedPreferences("main", Context.MODE_PRIVATE).edit {
            putString("data", "message")
        }

        btn_click.setOnClickListener {
            mPresenter.getUserInfo("zhanglin")
        }
        btn_glide.setOnClickListener {
            goActivity(this, GlideActivity().javaClass)
        }

    }

    override fun createPresenter(): MainContract.Presenter {
        return MainPresenter(this)
    }

    override fun resultUserInfo(result: String) {
        txt_view.setText(result)
        toast("测试信息，查看是否调用")
    }

    override fun onFail(msg: String?) {
        txt_view.setText(msg)
    }

}

