package cn.kc.moduleutils.util;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import cn.kc.moduleutils.R;

/**
 * 作者： Abel .
 * 日期：2019/9/23
 * 说明：
 */
public abstract class Dialogchoosephone extends Dialog implements View.OnClickListener {

    private Activity activity;
    private LinearLayout btnPickBySelect, btnPickByTake;

    public Dialogchoosephone(Activity activity) {
        super(activity, R.style.ActionSheetDialogStyle);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.takephoto_dialog);

        btnPickBySelect = findViewById(R.id.btnPickBySelect);
        btnPickByTake = findViewById(R.id.btnPickByTake);

        btnPickBySelect.setOnClickListener(this);
        btnPickByTake.setOnClickListener(this);

        setViewLocation();
        setCanceledOnTouchOutside(true);//外部点击取消
    }

    /**
     * 设置dialog位于屏幕底部
     */
    private void setViewLocation() {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;

        Window window = this.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.x = 0;
        lp.y = height;
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        // 设置显示位置
        onWindowAttributesChanged(lp);
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btnPickBySelect) {
            btnPickBySelect();
            this.cancel();
        } else if (i == R.id.btnPickByTake) {
            btnPickByTake();
            this.cancel();
        }
    }

    public abstract void btnPickBySelect();

    public abstract void btnPickByTake();
}
