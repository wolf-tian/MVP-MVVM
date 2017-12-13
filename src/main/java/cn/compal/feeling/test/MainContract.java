package cn.compal.feeling.test;


import java.util.List;

import cn.compal.feeling.base.BasePresenter;
import cn.compal.feeling.base.BaseView;
import cn.compal.feeling.module.http.api.BaseApi;

/**
 * Created by wolf on 2017/11/17.
 */

public class MainContract{

    interface View extends BaseView
    {
        void setRecViewData(List<InstructionBooksBean> list);
    }

    interface  Presenter extends BasePresenter<View>
    {
        void getZqzhHttpResponse(BaseApi api);
    }
}
