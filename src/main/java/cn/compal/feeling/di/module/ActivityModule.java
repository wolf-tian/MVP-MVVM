package cn.compal.feeling.di.module;

import android.app.Activity;

import cn.compal.feeling.di.scope.ActivityScope;
import cn.compal.feeling.test.MainTestViewModel;
import dagger.Module;
import dagger.Provides;

/**
 * Created by wolf on 2017/9/2.
 */


@Module
public class ActivityModule
{
    private Activity mActivity;

    private MainTestViewModel mainTestViewModel;

    public ActivityModule(Activity activity)
    {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity()
    {
        return mActivity;
    }

    @Provides
    MainTestViewModel provideMainTestViewModel() {
        return new MainTestViewModel();
    }
}
