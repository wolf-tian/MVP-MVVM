package cn.compal.feeling.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by wolf on 2017/12/12.
 */

public class ToastUtil {

    public static void show(Context ctx,String msg)
    {
        Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show();
    }

    public static void showShort(Context ctx, String msg)
    {
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
    }
}
