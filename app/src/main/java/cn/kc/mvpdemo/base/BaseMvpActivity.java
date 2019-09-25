package cn.kc.mvpdemo.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import cn.kc.moduleutils.base.BaseActivity;
import org.jetbrains.annotations.Nullable;

/**
 * 作者： Abel .
 * 日期：2019/9/25
 * 说明：
 */
public abstract class BaseMvpActivity<P extends BaseContract.Presenter> extends BaseActivity
        implements BaseContract.View {
    private ProgressDialog mProgressDialog;
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            getLifecycle().addObserver(mPresenter);
        }
    }

    @Override
    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("网络加载中...");
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    protected abstract P createPresenter();
}
