package test.bwei.com.myproject.model;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.bwei.com.myproject.bean.YouKeReMenHuaTiBean;
import test.bwei.com.myproject.bean.YouKeTuJianBean;
import test.bwei.com.myproject.contract.YouKeReMenHuaTiContract;
import test.bwei.com.myproject.contract.YouKeTuiJianContract;
import test.bwei.com.myproject.utils.APIInterface;
import test.bwei.com.myproject.utils.Address;

/**
 * Created by Administrator on 2017/12/14.
 */

/**
 * Model层 用于网络请求数据
 */
public class YouKeReMenHuaTiModel implements YouKeReMenHuaTiContract.IYouKeReMenHuaTiModel {
    @Override
    public Observable<YouKeReMenHuaTiBean> getData() {
        //创建Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Address.IP)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        //得到APIInterface对象
        APIInterface apiInterface = retrofit.create(APIInterface.class);
        //得到被观察者
        Observable<YouKeReMenHuaTiBean> observable = apiInterface.getYKIndexRx2();
        //返回
        return observable;
    }
}
