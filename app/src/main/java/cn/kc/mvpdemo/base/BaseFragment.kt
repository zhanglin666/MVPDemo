package cn.kc.moduleutils.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 作者： 张承堂  .
 * 日期： 2019/4/8
 * 版本： V1.0
 * 说明：
 */
abstract class BaseFragment : Fragment() {
    private var isInitData = false /*标志位 判断数据是否初始化*/
    private var isVisibleToUser = false /*标志位 判断fragment是否可见*/
    private var isPrepareView = false /*标志位 判断view已经加载完成 避免空指针操作*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(), container, false)
    }

    protected abstract fun getLayout(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isPrepareView = true
    }

    /*加载数据的方法,由子类实现*/
    abstract fun initData()

    /*懒加载方法*/
    private fun lazyInitData() {
        if (!isInitData && isVisibleToUser && isPrepareView) {
            isInitData = true
            initData()
        }
    }

    /*当fragment由可见变为不可见和不可见变为可见时回调*/
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        this.isVisibleToUser = isVisibleToUser
        lazyInitData()
    }

    /*fragment生命周期中onViewCreated之后的方法 在这里调用一次懒加载 避免第一次可见不加载数据*/
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lazyInitData()
    }
}