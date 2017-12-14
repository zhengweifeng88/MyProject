package test.bwei.com.myproject.contract;

import java.util.List;

import io.reactivex.Observable;
import test.bwei.com.myproject.bean.YouKeReMenHuaTiBean;
import test.bwei.com.myproject.bean.YouKeTuJianBean;

/**
 * 放MVP接口的类
 */
public class YouKeReMenHuaTiContract {
    public interface IYouKeReMenHuaTiModel{
        Observable<YouKeReMenHuaTiBean> getData();
    }
    public interface IYouKeReMenHuaTiPresenter{
        void showData();
    }
    public interface IYouKeReMenHuaTiView{
        void setData(List<YouKeReMenHuaTiBean.DataBean.TopicBean> list);
    }
}
