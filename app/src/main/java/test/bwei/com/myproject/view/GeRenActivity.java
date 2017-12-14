package test.bwei.com.myproject.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import test.bwei.com.myproject.R;
import test.bwei.com.myproject.adapter.GeRenAdapter;

public class GeRenActivity extends AppCompatActivity {

    private ImageView geren_shezhi;
    private TextView geren_name;
    private TextView geren_zhiwei;
    private ListView geren_lv;
    private ImageView img_geren;
    private ImageView geren_touxiang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ge_ren);
        initView();
    }

    /**
     * 初始化控件 点击事件操作
     */
    private void initView() {
        geren_shezhi = (ImageView) findViewById(R.id.geren_shezhi);
        geren_name = (TextView) findViewById(R.id.geren_name);
        geren_zhiwei = (TextView) findViewById(R.id.geren_zhiwei);
        geren_lv = (ListView) findViewById(R.id.geren_lv);
        //设置Adapter
        geren_lv.setAdapter(new GeRenAdapter(GeRenActivity.this));
        img_geren = (ImageView) findViewById(R.id.img_geren);
        //点击关闭当前页面
        img_geren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        geren_touxiang = (ImageView) findViewById(R.id.geren_touxiang);
        //加载图片
        Glide.with(this).load(R.mipmap.ic_launcher)
                .bitmapTransform(new CropCircleTransformation(this))
                .into(geren_touxiang);

    }
}
