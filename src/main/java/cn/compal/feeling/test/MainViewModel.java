package cn.compal.feeling.test;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import cn.compal.feeling.base.RxPresenter;
import cn.compal.feeling.module.DataManager;
import cn.compal.feeling.module.http.api.BaseApi;
import cn.compal.feeling.module.http.tools.HttpRequestUtil;
import cn.compal.feeling.util.JSONUtils;

/**
 * Created by wolf on 2017/12/7.
 */

public class MainViewModel extends RxPresenter<MainContract.View> implements MainContract.Presenter {
    private DataManager mDataManager;

    @Inject
    public MainViewModel(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getZqzhHttpResponse(BaseApi api) {
        addSubscribe(HttpRequestUtil.fetchHttpClient(api, mDataManager, mView, new HttpRequestUtil.ResponseMethod() {

            @Override
            public void onNext(Object response) {
                List<InstructionBooksBean> list = JSONUtils.parserObject2BeanList(response, InstructionBooksBean.class);
                Log.i("--->", "addSubscribe list.size() = " + list.size());
                Log.i("--->", "addSubscribe list.get(1).getSysModuleName() = " + list.get(1).getSysModuleName());
                mView.setRecViewData(list);
            }
        }));
    }
}
