package cn.compal.feeling.util;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by wolf on 2016/9/2.
 */

public class SnackbarUtil
{
    public static void show(View view, String msg)
    {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

    public static void showShort(View view, String msg)
    {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }
}
