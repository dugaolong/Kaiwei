package com.dgl.www.kaiwei.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dugaolong on 17/8/17.
 * 定义一个接口，封装url地址和数据请求
 */

public interface RequestServices {

    //请求方式是get，参数是dugaolong，getString方法参数
    @GET("local.php?choicename=西安&choicetype=city&page=1&gv=5.6.4&av=5.6.4&proid=ifengnews&os=android_23&df=androidphone&vt=5&screen=1080x1920&publishid=6001&nw=wifi")
    //定义返回的方法，返回的响应体使用了ResponseBody
    Call<ResponseBody> getString(@Query("deviceid") String deviceid,@Query("uid") String uid);
    /**
     * http://api.irecommend.ifeng.com/local.php?choicename=西安&choicetype=city&page=1" +
     //            "&gv=5.6.4&av=5.6.4&uid=861735038272489&deviceid=861735038272489&proid=ifengnews&os=android_23" +
     //            "&df=androidphone&vt=5&screen=1080x1920&publishid=6001&nw=wifi/
     */
}
