package cn.compal.feeling.module.prefs.impl;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import cn.compal.feeling.app.App;
import cn.compal.feeling.module.prefs.IPreferencesHelper;


/**
 * Created by wolf on 2016/9/30.
 */

public class PreferencesHelperImpl implements IPreferencesHelper
{
    private static final String SHAREDPREFERENCES_NAME = "feeling_base_sp";

    private final SharedPreferences mSPrefs;

    @Inject
    public PreferencesHelperImpl()
    {
        mSPrefs = App.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }
}
