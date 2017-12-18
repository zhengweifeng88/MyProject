package test.bwei.com.myproject.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import test.bwei.com.myproject.R;
import test.bwei.com.myproject.adapter.QuanBuHuaTiAdapter;
import test.bwei.com.myproject.adapter.YouKeTuiJianAdapter;
import test.bwei.com.myproject.bean.YouKeReMenHuaTiBean;
import test.bwei.com.myproject.contract.YouKeReMenHuaTiContract;
import test.bwei.com.myproject.contract.YouKeTuiJianContract;
import test.bwei.com.myproject.presenter.YouKeReMenHuaTiPresenter;
import test.bwei.com.myproject.presenter.YouKeTuiJianPresenter;

public class QuanBuHuaTiActivity extends AppCompatActivity implements YouKeReMenHuaTiContract.IYouKeReMenHuaTiView {
    private QuanBuHuaTiAdapter adapter;
    private ImageView quanbuhuati_img;
    private RecyclerView quanbuhuati_recycler;
//    private YouKeReMenHuaTiPresenter presenter = new YouKeReMenHuaTiPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_bu_hua_ti);
        initView();
    }

    @Override
    public void setData(List<YouKeReMenHuaTiBean.DataBean.TopicBean> list) {
        adapter.addData(list);
    }

    private void initView() {
        quanbuhuati_img = (ImageView) findViewById(R.id.quanbuhuati_img);
        quanbuhuati_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        quanbuhuati_recycler = (RecyclerView) findViewById(R.id.quanbuhuati_recycler);
//        presenter.showData();
        //设置布局管理器
        quanbuhuati_recycler.setLayoutManager(new LinearLayoutManager(QuanBuHuaTiActivity.this));
        adapter = new QuanBuHuaTiAdapter(QuanBuHuaTiActivity.this);
        //设置adapter
        quanbuhuati_recycler.setAdapter(adapter);
    }
}
