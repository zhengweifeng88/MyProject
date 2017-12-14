package test.bwei.com.myproject.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.List;

import test.bwei.com.myproject.R;
import test.bwei.com.myproject.adapter.YouKeTuiJianAdapter;
import test.bwei.com.myproject.bean.YouKeReMenHuaTiBean;
import test.bwei.com.myproject.bean.YouKeTuJianBean;
import test.bwei.com.myproject.contract.YouKeTuiJianContract;
import test.bwei.com.myproject.presenter.YouKeTuiJianPresenter;

/**
 * Created by Administrator on 2017/12/13.
 */

/**
 * View层 显示视图
 */
public class TuJianFragment extends Fragment implements YouKeTuiJianContract.IYouKeTuiJianView{
    private RecyclerView tuijianFragment_recyclerview;
    private SpringView tuijianFragment_springview;
    private YouKeTuiJianAdapter adapter;
    //创建Presenter对象
    private YouKeTuiJianPresenter presenter = new YouKeTuiJianPresenter(this);
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //加载布局
        View v = View.inflate(getActivity(), R.layout.tuijian_fragment, null);
        initView(v);
        return v;
    }

    /**
     *   初始化方法 找控件以及点击事件等操作
     * @param v
     */
    private void initView(View v) {
        tuijianFragment_recyclerview = (RecyclerView) v.findViewById(R.id.tuijianFragment_recyclerview);
        presenter.showData();
//        presenter.showData2();
        //设置布局管理器
        tuijianFragment_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new YouKeTuiJianAdapter(getActivity());
        //设置adapter
        tuijianFragment_recyclerview.setAdapter(adapter);
        tuijianFragment_springview = (SpringView) v.findViewById(R.id.tuijianFragment_springview);
        //设置默认的下拉刷新显示图
        tuijianFragment_springview.setHeader(new DefaultHeader(getActivity()));
//        tuijianFragment_springview.setFooter(new DefaultFooter(getActivity()));
    }

    /**
     * 耗时操作  1秒
     */
    private void finishFreshAndLoad() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tuijianFragment_springview.onFinishFreshAndLoad();
            }
        }, 1000);
    }

    @Override
    public void setData(final List<YouKeTuJianBean.DataBean.ArticleBean> list) {
        adapter.addData(list);
        tuijianFragment_springview.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                //刷新
                adapter.updateData(list);
                finishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {

            }
        });
    }
}
