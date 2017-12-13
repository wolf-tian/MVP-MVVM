package cn.compal.feeling.di.component;


import javax.inject.Singleton;

import cn.compal.feeling.app.App;
import cn.compal.feeling.di.module.AppModule;
import cn.compal.feeling.di.module.HttpModule;
import cn.compal.feeling.module.DataManager;
import cn.compal.feeling.module.http.RetrofitHelper;
import cn.compal.feeling.module.prefs.impl.PreferencesHelperImpl;
import dagger.Component;

/**
 * Created by wolf on 2017/8/2.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent
{
    App getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    RetrofitHelper retrofitHelper();  //提供http的帮助类

    PreferencesHelperImpl preferencesHelper(); //提供sp帮助类
}
