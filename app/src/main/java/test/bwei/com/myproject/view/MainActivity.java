package test.bwei.com.myproject.view;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import test.bwei.com.myproject.R;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    //声明存储fragment的集合
    private ArrayList<Fragment> fragments;
    //声明四个导航对应fragment
    TuJianFragment tuJianFragment;
    GuanZhuFragment guanZhuFragment;
    //声明ViewPager
    private ViewPager vp;
    //声明fragment管理
    FragmentManager fragmentManager;
    private TextView tv_tujian;
    private TextView tv_guanzhu;
    private View view_tuijian;
    private View view_guanzhu;
    private ImageView img_geren;
    private ImageView img_fabu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //刚进入 默认
        tv_tujian.setSelected(true);
        tv_guanzhu.setSelected(false);
        String localdeviceId = getLocaldeviceId(this);
    }

    //获取设备号
    public String getLocaldeviceId(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        if (deviceId == null || deviceId.trim().length() == 0) {
            WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = wifi.getConnectionInfo();
            deviceId = info.getMacAddress();
        }
        return deviceId;
    }

    private void initView() {
        tv_tujian = (TextView) findViewById(R.id.tv_tujian);
        tv_tujian.setOnClickListener(this);
        tv_guanzhu = (TextView) findViewById(R.id.tv_guanzhu);
        tv_guanzhu.setOnClickListener(this);
        view_tuijian = (View) findViewById(R.id.view_tuijian);
        view_guanzhu = (View) findViewById(R.id.view_guanzhu);
        img_geren = (ImageView) findViewById(R.id.img_geren);
        //点击跳转到个人信息页面
        img_geren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,GeRenActivity.class));
            }
        });
        img_fabu = (ImageView) findViewById(R.id.img_fabu);
        //点击跳转到发布页面
        img_fabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FaBuActivity.class));
            }
        });
        vp = (ViewPager) findViewById(R.id.vp);
        //实例化Fragment
        tuJianFragment = new TuJianFragment();
        guanZhuFragment = new GuanZhuFragment();
        //创建集合
        fragments = new ArrayList<>();
        //添加到集合
        fragments.add(tuJianFragment);
        fragments.add(guanZhuFragment);
        //得到管理类
        fragmentManager = getSupportFragmentManager();
        //为ViewPager设置适配器用于部署fragments
        vp.setAdapter(new MyFragmentPagerAdapter(fragmentManager));
        //ViewPager滑动监听事件
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                /**
                 * 滑动同时 上方的TextView字体颜色改变以及View的显示与隐藏
                 */
                switch (position) {
                    case 0:
                        tv_tujian.setSelected(true);
                        tv_guanzhu.setSelected(false);
                        view_tuijian.setVisibility(View.VISIBLE);
                        view_guanzhu.setVisibility(View.GONE);
                        break;
                    case 1:
                        tv_tujian.setSelected(false);
                        tv_guanzhu.setSelected(true);
                        view_tuijian.setVisibility(View.GONE);
                        view_guanzhu.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     *   点击TextView 切换不同的ViewPager页面
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_tujian:
                vp.setCurrentItem(0);
                view_tuijian.setVisibility(View.VISIBLE);
                view_guanzhu.setVisibility(View.GONE);
                break;
            case R.id.tv_guanzhu:
                vp.setCurrentItem(1);
                view_tuijian.setVisibility(View.GONE);
                view_guanzhu.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }
    //创建内部类MyFragmentPagerAdapter
    class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
