package test.bwei.com.myproject.presenter;

import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import test.bwei.com.myproject.bean.YouKeReMenHuaTiBean;
import test.bwei.com.myproject.bean.YouKeTuJianBean;
import test.bwei.com.myproject.contract.YouKeTuiJianContract;
import test.bwei.com.myproject.model.YouKeTuiJianModel;

/**
 * Created by Administrator on 2017/12/14.
 */

/**
 * Presenter层 用于Model层与View建立连接
 */
public class YouKeTuiJianPresenter implements YouKeTuiJianContract.IYouKeTuiJianPresenter{
    YouKeTuiJianContract.IYouKeTuiJianView iYouKeTuiJianView;
    YouKeTuiJianModel youKeTuiJianModel;
    //有参构造
    public YouKeTuiJianPresenter(YouKeTuiJianContract.IYouKeTuiJianView iYouKeTuiJianView) {
        this.iYouKeTuiJianView = iYouKeTuiJianView;
        youKeTuiJianModel = new YouKeTuiJianModel();
    }

    @Override
    public void showData() {
        //调用Model的方法
        Observable<YouKeTuJianBean> observable = youKeTuiJianModel.getData();
        //订阅
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<YouKeTuJianBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.e("-------->","啥--" + d);
                    }
                    //数据
                    @Override
                    public void onNext(@NonNull YouKeTuJianBean youKeTuJianBean) {
                        if(youKeTuJianBean != null){
                            List<YouKeTuJianBean.DataBean.ArticleBean> list = youKeTuJianBean.getData().getArticle();
                            iYouKeTuiJianView.setData(list);
                        }
                    }
                    //错误
                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("-------->","错误" + e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
