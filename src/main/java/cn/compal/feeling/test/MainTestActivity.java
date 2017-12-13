package cn.compal.feeling.test;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.compal.feeling.BR;
import cn.compal.feeling.R;
import cn.compal.feeling.adapter.MvvmCommonAdapter;
import cn.compal.feeling.base.BaseMVVMActivity;
import cn.compal.feeling.databinding.ActivityTestMainBinding;
import cn.compal.feeling.module.http.api.BaseApi;
import cn.compal.feeling.util.StatusBarUtil;

/**
 * Created by wolf on 2017/12/6.
 */

public class MainTestActivity extends BaseMVVMActivity<MainViewModel,ActivityTestMainBinding> implements MainContract.View
{
    List<InstructionBooksBean> mDatas = new ArrayList<>();
    MvvmCommonAdapter adapter;
    @BindView(R.id.rec_view)
    RecyclerView recyclerView;

    @Override
    protected int getLayoutRes() {
        StatusBarUtil.setImgTransparent(this);
        return R.layout.activity_test_main;
    }

    @Override
    protected void initEventAndData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(MainTestActivity.this, LinearLayoutManager.VERTICAL, false));
        adapter = new MvvmCommonAdapter(mDatas, BR.data,MainTestActivity.this,R.layout.rec_view_item);
        recyclerView.setAdapter(adapter);
        BaseApi api = new BaseApi();
        api.setModule("staff");
        api.setMothed("queryInstructionBooks.do");
        mViewModel.getZqzhHttpResponse(api);
    }

    @Override
    protected void initInject()
    {
        //getActivityComponent().inject(this);
        getActivityComponent().inject(this);
        /*mBinding.setActivity(this);
        mBinding.setViewModel(mViewModel);*/
        mBinding.setViewModel(mViewModel);
    }

    @Override
    public void setRecViewData(List<InstructionBooksBean> list) {
        mDatas = list;
        adapter.setmDatas(mDatas);
        adapter.notifyDataSetChanged();
    }
}
