package cn.compal.feeling.base;

/**
 * Created by wolf on 2017/9/2.
 */

public interface BasePresenter<T extends BaseView>
{

    void attachView(T view);

    void detachView();
}

