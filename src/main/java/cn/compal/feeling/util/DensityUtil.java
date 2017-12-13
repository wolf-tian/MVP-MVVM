package cn.compal.feeling.util;

import android.content.Context;

/**
 * @Description Android常用单位转换
 * @author wolf
 * @date 2016-8-11 上午10:23:39
 * @version 1.0
 */
public class DensityUtil {

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从sp值转换为px(像素)值
	 */
	public static int sp2px(Context context, float spValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从sp值转换为dip值
	 */
	public static int sp2dip(Context context, float spValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) ((spValue * fontScale + 0.5f) / scale + 0.5f);
	}

}
