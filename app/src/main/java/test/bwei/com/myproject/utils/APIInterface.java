package test.bwei.com.myproject.utils;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import test.bwei.com.myproject.bean.YouKeReMenHuaTiBean;
import test.bwei.com.myproject.bean.YouKeTuJianBean;

/**
 * Created by Administrator on 2017/11/9.
 * 各个方法 get post
 */

public interface APIInterface {
//    //注册
//    @FormUrlEncoded
//    @POST("user/addUser")
//    Observable<RegisterBean> getRegisterRx(@FieldMap Map<String, String> map);
//    //登录
//    @FormUrlEncoded
//    @POST("user/addLogin")
//    Observable<LoginBean> getLoginRx(@FieldMap Map<String, String> map);
//    //热门页
//    @GET("user/findHot")
//    Observable<FindHotBean> getFindHotRx();
//    //段子页
//    @GET("character/select_character")
//    Observable<EpisodeBean> getEpisodeRx();
//    //视频页
//    @GET("media/showMedia")
//    Observable<VideoBean> getVideoRx();
    //游客推荐页
    @GET("/api/articles?user=surfer&flag=index2&fromUid=138&page=1")
    Observable<YouKeTuJianBean> getYKIndexRx();
    @GET("/api/topics?user=surfer&flag=index&fromUid=138&page=1&limit=4")
    Observable<YouKeReMenHuaTiBean> getYKIndexRx2();
}
