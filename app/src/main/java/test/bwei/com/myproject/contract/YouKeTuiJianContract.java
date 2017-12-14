package test.bwei.com.myproject.contract;

import java.util.List;

import io.reactivex.Observable;
import test.bwei.com.myproject.bean.YouKeReMenHuaTiBean;
import test.bwei.com.myproject.bean.YouKeTuJianBean;

/**
 * 放MVP接口的类
 */
public class YouKeTuiJianContract {
    public interface IYouKeTuiJianModel{
        Observable<YouKeTuJianBean> getData();
    }
    public interface IYouKeTuiJianPresenter{
        void showData();
    }
    public interface IYouKeTuiJianView{
        void setData(List<YouKeTuJianBean.DataBean.ArticleBean> list);
    }
}
