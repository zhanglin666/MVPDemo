package cn.kc.mvpdemo.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * 作者： Abel .
 * 日期：2019/9/20
 * 说明：
 */
public interface BaseContract {
    interface Model {

        /** onDestroy()执行后执行 */
        void onClear();
    }

    interface View {

        /** 显示dialog */
        void showProgressDialog();

        /** 关闭dialog */
        void dismissProgressDialog();

        /** 失败 */
        void onFail(String msg);
    }

    interface Presenter extends LifecycleObserver {

        /** 关联onDestroy()生命周期 */
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        void onClear();
    }
}
