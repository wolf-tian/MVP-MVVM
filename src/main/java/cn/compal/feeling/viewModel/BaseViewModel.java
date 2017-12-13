package cn.compal.feeling.viewModel;

import cn.compal.feeling.base.BaseView;

/**
 * Created by wolf on 2017/12/6.
 */

public interface BaseViewModel<T extends BaseView>
{
    void attachView(T view);

    void detachView();
}
