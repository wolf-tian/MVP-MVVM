package cn.compal.feeling.base;

import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatDelegate;
import android.view.ViewGroup;

import javax.inject.Inject;

import cn.compal.feeling.app.App;
import cn.compal.feeling.di.component.ActivityComponent;
import cn.compal.feeling.di.component.DaggerActivityComponent;
import cn.compal.feeling.di.module.ActivityModule;
import cn.compal.feeling.util.SnackbarUtil;

/**
 * Created by wolf on 2017/12/6.
 */

public abstract class BaseMVVMActivity<T extends BasePresenter,D extends ViewDataBinding> extends SimpleMVVMActivity implements BaseView
{
    @Inject
    protected T mViewModel;

    protected D mBinding;

    public static SharedPreferences guestureSp, settingsApp,settings;

    protected ActivityComponent getActivityComponent()
    {
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule()
    {
        return new ActivityModule(this);
    }

    protected void initDataBinding() {
        int layoutId = getLayoutRes();
        mBinding = DataBindingUtil.setContentView(this, layoutId);
    }

    @Override
    protected void onViewCreated()
    {
        super.onViewCreated();
        settings = this.getSharedPreferences("WADE_MOBILE_STORAGE", 0);
        guestureSp=getSharedPreferences("GuestureLockSP",0);
        settingsApp = this.getSharedPreferences("WADE_MOBILE_STORAGE_APP", 0);
        initDataBinding();
        initInject();
        if (mViewModel != null)
            mViewModel.attachView(this);
    }

    @Override
    protected void onDestroy()
    {
        if (mBinding != null)
            mBinding.unbind();
        if (mViewModel != null)
            mViewModel.detachView();
        super.onDestroy();
    }

    @Override
    public void showErrorMsg(String msg)
    {
        SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void useNightMode(boolean isNight)
    {
        if (isNight)
        {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else
        {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();
    }

    @Override
    public void stateError()
    {

    }

    @Override
    public void stateEmpty()
    {

    }

    @Override
    public void stateLoading()
    {

    }

    @Override
    public void stateMain()
    {

    }

    protected abstract void initInject();
}