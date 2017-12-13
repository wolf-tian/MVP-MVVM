package cn.compal.feeling.di.component;

import android.app.Activity;

import cn.compal.feeling.di.module.FragmentModule;
import cn.compal.feeling.di.scope.FragmentScope;
import dagger.Component;

/**
 * Created by wolf on 2017/9/2.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent
{
    Activity getActivity();

    //void inject(FirstFragmentPage firstFragmentPage);
}
