package cn.compal.feeling.module;

import cn.compal.feeling.module.http.IHttpHelper;
import cn.compal.feeling.module.http.api.BaseApi;
import cn.compal.feeling.module.prefs.IPreferencesHelper;
import io.reactivex.Flowable;

/**
 * Created by wolf on 2017/11/17.
 */

public class DataManager implements IHttpHelper, IPreferencesHelper
{
    IHttpHelper mHttpHelper;
    IPreferencesHelper mPreferencesHelper;

    public DataManager(IHttpHelper httpHelper, IPreferencesHelper preferencesHelper)
    {
        mHttpHelper = httpHelper;
        mPreferencesHelper = preferencesHelper;
    }

/*    @Override
    public  Flowable<ZqzhHttpResponse<List<InstructionBooksBean>>> getZqzhHttpResponse(BaseApi api)
    {
        return mHttpHelper.getZqzhHttpResponse(api);
    }*/

    @Override
    public Flowable<Object> getZqzhHttpStringResponse(BaseApi api)
    {
        return mHttpHelper.getZqzhHttpStringResponse(api);
    }
}
