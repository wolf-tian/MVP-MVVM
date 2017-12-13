package cn.compal.feeling.module.http;

import java.util.Map;

import javax.inject.Inject;

import cn.compal.feeling.module.http.api.BaseApi;
import cn.compal.feeling.module.http.service.ZqzhHttpService;
import io.reactivex.Flowable;

/**
 * Created by wolf on 2017/11/17.
 */

public class RetrofitHelper implements IHttpHelper
{
    private ZqzhHttpService mZqzhHttpService;

    @Inject
    public RetrofitHelper(ZqzhHttpService mZqzhHttpService)
    {
        this.mZqzhHttpService = mZqzhHttpService;
    }

/*    @Override
    public Flowable<ZqzhHttpResponse<List<InstructionBooksBean>>> getZqzhHttpResponse(BaseApi api)
    {
        Map<String, String> parameters = api.getParameters();
        if (null == parameters)
        {
            return mZqzhHttpService.getRepoDataByModeAndQtype(api.getModule(), api.getMothed());
        }
        else
        {
            return mZqzhHttpService.getRepoDataByModeAndQtype(api.getModule(), api.getMothed(), api.getParameters());
        }
    }*/

    @Override
    public Flowable<Object> getZqzhHttpStringResponse(BaseApi api)
    {
        Map<String, String> parameters = api.getParameters();
        if (null == parameters)
        {
            return mZqzhHttpService.getStringRepoDataByModeAndQtype(api.getModule(), api.getMothed());
        }
        else
        {
            return mZqzhHttpService.getStringRepoDataByModeAndQtype(api.getModule(), api.getMothed(), api.getParameters());
        }
    }
}
