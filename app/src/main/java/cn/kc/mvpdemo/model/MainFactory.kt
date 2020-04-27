package cn.kc.mvpdemo.model

/**
 * 作者： Abel .
 * 日期：2020/4/10
 * 说明：如果需要修改网络请求框架 修改HttpImp即可
 */
class MainFactory {
    companion object {
        fun getHttpImp(): IHttp {
            return HttpImp()
        }
    }
}