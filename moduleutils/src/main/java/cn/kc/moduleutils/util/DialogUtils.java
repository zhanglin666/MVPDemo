package cn.kc.moduleutils.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;

/**
 * \ 对话框工具箱
 * <p>
 * Created by 72913 on 2017/10/24.
 */

public class DialogUtils {
    /**
     * 只要内容的dialog 两个按钮的文字设置为默认  不要标题
     *
     * @param context
     * @param content
     * @param listener
     * @return
     */
    public static Dialog commonDialogTwoBtn(Context context, String content,
                                            DefindedDialog.OnDedindedClickedListener listener) {
        return commonDialogTwoBtn(context, null, content, "确定", "取消", 0,listener);
    }

    /**
     * 只要内容的dialog 两个按钮的文字设置为不默认
     *
     * @param context
     * @param content
     * @param positiveName
     * @param negativeName
     * @param listener
     * @return
     */
    public static Dialog commonDialogTwoBtn(Context context, String content,
                                            String positiveName, String negativeName,int position,
                                            DefindedDialog.OnDedindedClickedListener listener) {
        return commonDialogTwoBtn(context, null, content, positiveName,
                negativeName,position, listener);
    }

    /**
     * 既要内容 又要标题的dialog 并且两个按钮的文字设置为默认
     *
     * @param context
     * @param title
     * @param content
     * @param listener
     * @return
     */
    public static Dialog commonDialogTwoBtn(Context context, String title,
                                            String content, DefindedDialog.OnDedindedClickedListener listener) {
        return commonDialogTwoBtn(context, title, content, "确定", "取消",0, listener);
    }

    /**
     * 既要内容 又要标题的dialog 并且两个按钮的文字不默认
     *
     * @param context
     * @param title
     * @param content
     * @param positiveName
     * @param negativeName
     * @param listener
     * @return
     */
    public static Dialog commonDialogTwoBtn(Context context, String title,
                                            String content, String positiveName, String negativeName,int position,
                                            DefindedDialog.OnDedindedClickedListener listener) {
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        if (listener == null) {
            return null;
        }
        DefindedDialog.Builder alert = new DefindedDialog.Builder(context,
                title, content, positiveName, negativeName, position,listener);

        DefindedDialog dialog = alert.create();
        dialog.show();
        return dialog;
    }
}
