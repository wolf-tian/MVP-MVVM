package cn.compal.feeling.di.module;


import javax.inject.Singleton;

import cn.compal.feeling.app.App;
import cn.compal.feeling.module.DataManager;
import cn.compal.feeling.module.http.IHttpHelper;
import cn.compal.feeling.module.http.RetrofitHelper;
import cn.compal.feeling.module.prefs.IPreferencesHelper;
import cn.compal.feeling.module.prefs.impl.PreferencesHelperImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by wolf on 2017/9/2.
 */

@Module
public class AppModule
{
    private final App application;

    public AppModule(App application)
    {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext()
    {
        return application;
    }


    @Provides
    @Singleton
    IPreferencesHelper providePreferencesHelper(PreferencesHelperImpl preferencesHelper)
    {
        return preferencesHelper;
    }

    @Provides
    @Singleton
    IHttpHelper provideHttpHelper(RetrofitHelper retrofitHelper)
    {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(IHttpHelper httpHelper, IPreferencesHelper preferencesHelper)
    {
        return new DataManager(httpHelper, preferencesHelper);
    }
}
