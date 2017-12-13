package cn.compal.feeling.di.component;

import android.app.Activity;

import com.asiainfo.mcss.ui.LoginThirdWayActivity;

import cn.compal.feeling.MainActivity;
import cn.compal.feeling.di.module.ActivityModule;
import cn.compal.feeling.di.scope.ActivityScope;
import cn.compal.feeling.test.MainTestActivity;
import cn.compal.feeling.test.MainTestViewModel;
import cn.compal.feeling.test.MainViewModel;
import dagger.Component;

/**
 * Created by wolf on 2017/9/3.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent
{
    Activity getActivity();

    //void inject(WelcomeActivity welcomeActivity);
    void inject(MainActivity mainActivity);

    void inject(MainTestActivity mainTestActivity);

    void inject(LoginThirdWayActivity loginThirdWayActivity);

    void injectViewModel(MainViewModel viewModel);
}
