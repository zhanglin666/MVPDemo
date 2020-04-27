package cn.kc.moduleutils.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * 作者： Abel .
 * 日期：2020/1/8
 * 说明：自定义圆角头像
 */

class CircleIco(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var bitmap: Bitmap? = null

    //获取圆角图片
    //获取屏幕宽高
    //新建一个位图文件
    //在此位图上进行绘制
    //初始化画笔
    //        paint.setStrokeWidth(5);//画笔宽度
    //        paint.setAntiAlias(true);//是否抗锯齿
    //        paint.setDither(true); //防抖动
    //        paint.setStyle(Paint.Style.FILL); //画笔类型 STROKE空心 FILL 实心
    //        paint.setColor(Color.BLUE);//画笔颜色
    //绘制一个圆
    //获取宽和高的较小数
    //图片相交模式
    //绘制图片底图
    //        matrix.postScale(1, 1);//不缩放，原图显示
    //缩放全部显示
    val circleBitmap: Bitmap
        get() {
            val w = width
            val h = height
            val newBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(newBitmap)
            val paint = Paint()
            val radius = Math.min(w, h) / 2
            canvas.drawCircle((w / 2).toFloat(), (h / 2).toFloat(), radius.toFloat(), paint)

            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
            val matrix = Matrix()
            matrix.postScale(w.toFloat() / bitmap!!.width, h.toFloat() / bitmap!!.height, 0f, 0f)
            canvas.drawBitmap(bitmap!!, matrix, paint)
            return newBitmap
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //绘制
        if (bitmap != null)
            canvas.drawBitmap(circleBitmap, 0f, 0f, null)
    }

    // 设置bitmap
    fun setImageBitmap(bitmap: Bitmap) {
        this.bitmap = bitmap
        invalidate()
    }

    // 测量模式
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (bitmap == null) return

        val bw = bitmap!!.width
        val bh = bitmap!!.height

        var sizeW = MeasureSpec.getSize(widthMeasureSpec)
        var sizeH = MeasureSpec.getSize(heightMeasureSpec)
        val modeW = View.MeasureSpec.getMode(widthMeasureSpec)
        val modeH = View.MeasureSpec.getMode(heightMeasureSpec)

        if (modeW == View.MeasureSpec.AT_MOST)
            sizeW = bw

        if (modeH == View.MeasureSpec.AT_MOST)
            sizeH = bh

        setMeasuredDimension(sizeW, sizeH)
    }
}