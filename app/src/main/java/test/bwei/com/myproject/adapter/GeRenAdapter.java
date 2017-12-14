package test.bwei.com.myproject.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import test.bwei.com.myproject.R;

/**
 * Created by Administrator on 2017/12/13.
 */

public class GeRenAdapter extends BaseAdapter{
    //存放图片数组
    int[] arrImg = {R.drawable.xiaoxi,R.drawable.huati,
            R.drawable.jianwen,R.drawable.fenxiang,R.drawable.fenxiang};
    //存放String字符串
    String[] arrText = {"我的消息","全部话题","我的见闻","我的关注","分享APP"};
    Context context;
    public GeRenAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //加载布局
        View v = View.inflate(context, R.layout.geren_item,null);
        //通过加载的布局找控件
        ImageView img = (ImageView) v.findViewById(R.id.geren_item_img);
        TextView tv = (TextView) v.findViewById(R.id.geren_item_tv);
        //给控件赋值
        img.setImageResource(arrImg[i]);
        tv.setText(arrText[i]);
        //返回
        return v;
    }
}
