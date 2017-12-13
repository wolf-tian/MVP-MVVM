package cn.compal.feeling.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.compal.feeling.app.App;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by wolf on 2017/11/14.
 */

public abstract class SimpleMVVMActivity extends SupportActivity
{
    protected Activity mContext;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        onViewCreated();
        mUnBinder = ButterKnife.bind(this);
        mContext = this;
        App.getInstance().addActivity(this);
        initEventAndData();
    }

    /**
     * 手动处理view创建时相关事宜
     */
    protected void onViewCreated()
    {

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        App.getInstance().removeActivity(this);
        mUnBinder.unbind();
    }

    protected abstract int getLayoutRes();

    protected abstract void initEventAndData();
}
