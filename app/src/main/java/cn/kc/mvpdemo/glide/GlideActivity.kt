package cn.kc.mvpdemo.glide

import android.os.Bundle
import cn.kc.moduleutils.base.BaseActivity
import cn.kc.mvpdemo.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.act_glide.*

/**
 * 作者： Abel .
 * 日期：2020/3/31
 * 说明：Glide源码解析
 */
class GlideActivity : BaseActivity() {
    override fun getLayout() = R.layout.act_glide

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        //静态图片资源地址
//        val url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg"
        //GIF动图资源地址
        val url = "http://p1.pstatp.com/large/166200019850062839d3"
        Glide.with(this).load(url)
            .placeholder(R.mipmap.az)   //添加占位图，在网络获取图片资源时先显示占位图
            .diskCacheStrategy(DiskCacheStrategy.NONE)  //禁用Glide的缓存功能
            .error(R.mipmap.more)   //异常占位图，获取资源异常时显示
            .override(300, 200)   //指定图片尺寸
                //.skipMemoryCache(true)     //禁用内存缓存
                //.diskCacheStrategy(DiskCacheStrategy.NONE)    //禁用硬盘缓存
            .into(img_view)
    }

}
/**
 *with()方法是Glide中的一组静态方法，with（）方法的重载种类很多，可以传入fragment、activity、或者是content，
 * 每一个with()方法重载都是先调用RequestManagerRetriever的静态get()方法得到一个RequestManagerRetriever
 * 对象，这个静态get()方法就是一个单例实现，后再调用RequestManagerRetriever的实例get()方法，
 * 去获取RequestManager对象，
 * with（）方法主要是传入application类型的参数和非application类型的参数，如果传入的是application类型的参数，
 * 那么Glide的生命周期即是程序的生命周期。如果传入的是非application类型的参数，不管是fragment,activity,
 * fragmentactivity，都会向当前activity当中添加一个隐藏的fragment，因为glide需要知道加载的生命周期，所以
 * 添加fragment后glide可以捕获到生命周期并进行销毁。
 *
 * Glide缓存分为两个模块，一个是内存缓存，一个是硬盘缓存，内存缓存的主要作用是防止应用重复将
 * 图片数据读取到内存当中，而硬盘缓存的主要作用是防止应用重复从网络或其他地方重复下载和读取数据
 * *
 */