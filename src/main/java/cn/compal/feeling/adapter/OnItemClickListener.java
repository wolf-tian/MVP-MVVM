package cn.compal.feeling.adapter;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by wolf on 2017/8/10.
 */

public interface OnItemClickListener {

    /**
     * 响应点击事件监听回调
     * @param view 响应事件的View
     * @param adapterPosition item所在的位置
     */
    void onItemClick(@NonNull View view, int adapterPosition);
}
