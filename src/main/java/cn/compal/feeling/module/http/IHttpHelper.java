package cn.compal.feeling.module.http;

import cn.compal.feeling.module.http.api.BaseApi;
import io.reactivex.Flowable;

/**
 * Created by wolf on 2017/11/16.
 */

public interface IHttpHelper
{
    //Flowable<ZqzhHttpResponse<List<InstructionBooksBean>>>  getZqzhHttpResponse(BaseApi api);

    Flowable<Object>  getZqzhHttpStringResponse(BaseApi api);

}
