package cn.compal.feeling.test;

import android.databinding.ObservableField;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import cn.compal.feeling.base.BaseView;
import cn.compal.feeling.module.DataManager;
import cn.compal.feeling.module.http.api.BaseApi;
import cn.compal.feeling.module.http.exception.RetryWhenNetworkException;
import cn.compal.feeling.util.JSONUtils;
import cn.compal.feeling.util.RxUtil;
import cn.compal.feeling.viewModel.BaseViewModel;
import io.reactivex.functions.Consumer;

/**
 * Created by wolf on 2017/12/6.
 */

public class MainTestViewModel implements BaseViewModel<MainTestViewModel.View>
{
    public final ObservableField<List<InstructionBooksBean>> instructionBooksBean = new ObservableField<>();
    @Inject
    public DataManager mDataManager;
    MainTestViewModel.View mView;

    public MainTestViewModel()
    {
        List<InstructionBooksBean> list = new ArrayList<>();
        instructionBooksBean.set(list);
    }

    @Inject
    public MainTestViewModel(DataManager mDataManager)
    {
        this.mDataManager = mDataManager;
    }


    public void getRecViewDataResponse(BaseApi api)
    {
        mDataManager.getZqzhHttpStringResponse(api)
                .retryWhen(new RetryWhenNetworkException())
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.<Object>handleStringResult())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object response) throws Exception {
                        List<InstructionBooksBean> list = JSONUtils.parserObject2BeanList(response,InstructionBooksBean.class);
                        instructionBooksBean.set(list);
                        mView.setRecViewData(list);
                    }
                });
    }


    @Override
    public void attachView(View view)
    {
        this.mView = view;
    }

    @Override
    public void detachView() {

    }

    interface View extends BaseView
    {
        void setRecViewData(List<InstructionBooksBean> list);
    }

}
