package cn.kc.moduleutils.util;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import cn.kc.moduleutils.R;

/**
 * 作者： Abel .
 * 日期：2019/9/4
 * 说明：
 */
public class DefindedDialog extends Dialog {

    public DefindedDialog(Context context, int theme) {
        super(context, theme);
    }

    public DefindedDialog(Context context) {
        super(context);
    }

    public static class Builder {

        private Context context;
        private String title;
        private String message;
        private String positiveButtonText;
        private String negativeButtonText;
        private int position;
        private OnDedindedClickedListener onDedindedClickedListener;

        /**
         * @param context
         * @param title                     标题
         * @param message                   提示内容
         * @param positiveButtonText        确定按钮的文本
         * @param negativeButtonText        取消按钮
         * @param position
         * @param onDedindedClickedListener 两个按钮的监听
         */
        public Builder(Context context, String title, String message,
                       String positiveButtonText, String negativeButtonText, int position,
                       OnDedindedClickedListener onDedindedClickedListener) {
            super();
            this.context = context;
            this.title = title;
            this.message = message;
            this.positiveButtonText = positiveButtonText;
            this.negativeButtonText = negativeButtonText;
            this.position = position;
            this.onDedindedClickedListener = onDedindedClickedListener;
        }

        /**
         * Create the custom dialog
         */
        public DefindedDialog create() {
            final DefindedDialog dialog = new DefindedDialog(context,
                    R.style.TwoButtonDialog);// 设置dialog的风格
            // 设置dialog不可取消 点击其他地方不能隐藏
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);

            View layout = View.inflate(context, R.layout.two_button_dialog,
                    null);

            // 设置内容
            TextView tv_content = (TextView) layout
                    .findViewById(R.id.two_btn_desc);
            if (TextUtils.isEmpty(message)) {
                tv_content.setVisibility(View.GONE);
            } else {
                tv_content.setVisibility(View.VISIBLE);
                tv_content.setText(message);
                tv_content.setMovementMethod(new ScrollingMovementMethod());
            }

            // 设置标题
            TextView tv_title = (TextView) layout
                    .findViewById(R.id.two_btn_title);
//			View view = layout.findViewById(R.id.view);
            if (TextUtils.isEmpty(title)) {
                tv_title.setVisibility(View.GONE);
//				view.setVisibility(View.GONE);
            } else {
                // 间隔线
//				view.setVisibility(View.VISIBLE);
                tv_title.setVisibility(View.VISIBLE);
                tv_title.setText(title);
            }

            // 将自定义的布局设置上去
            dialog.setContentView(layout);

            // 设置确定按钮的文字以及点击事件
            Button confirm_btn = ((Button) layout
                    .findViewById(R.id.confirm_btn));
            if (TextUtils.isEmpty(positiveButtonText)) {
                confirm_btn.setText("确定");
            } else {
                confirm_btn.setText(positiveButtonText);
            }
            confirm_btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    onDedindedClickedListener.onPositiveButtonClieked(dialog,position);
                    dialog.dismiss();
                }
            });

            // 设置取消按钮
            Button cancle_btn = ((Button) layout.findViewById(R.id.cancle_btn));
            if (TextUtils.isEmpty(negativeButtonText)) {
                cancle_btn.setText("取消");
            } else {
                cancle_btn.setText(negativeButtonText);
            }
            cancle_btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    onDedindedClickedListener.onNegativeButtonClieked(dialog);
                    dialog.dismiss();
                }
            });

            // 设置dialog的宽度
            WindowManager.LayoutParams params = dialog.getWindow()
                    .getAttributes();
            params.width = getScreenWidth(context) - dp2px(context, 150);
            dialog.getWindow().setAttributes(params);

            return dialog;
        }

        /**
         * 获得屏幕宽度
         *
         * @param context
         * @return
         */
        public int getScreenWidth(Context context) {
            WindowManager wm = (WindowManager) context
                    .getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics outMetrics = new DisplayMetrics();
            wm.getDefaultDisplay().getMetrics(outMetrics);
            return outMetrics.widthPixels;
        }

        /**
         * dp转px
         *
         * @param context
         * @param
         * @return
         */
        public int dp2px(Context context, float dpVal) {
            return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    dpVal, context.getResources().getDisplayMetrics());
        }

    }

    /**
     * 当点击确定的时候会调用onPositiveButtonClieked 当点击取消的时候会调用onPositiveButtonClieked
     *
     * @author Haipeng
     * <p>
     * 2016-7-28
     */
    public interface OnDedindedClickedListener {

        void onPositiveButtonClieked(DefindedDialog dialog, int position);

        void onNegativeButtonClieked(DefindedDialog dialog);
    }
}
