package test.bwei.com.myproject.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.bwei.com.myproject.R;
import test.bwei.com.myproject.bean.YouKeReMenHuaTiBean;

/**
 * Created by Administrator on 2017/12/14.
 */

public class YouKeReMenHuaTiAdapter extends BaseAdapter{
    Context context;
    List<YouKeReMenHuaTiBean.DataBean.TopicBean> list = new ArrayList<>();

    public YouKeReMenHuaTiAdapter(Context context) {
        this.context = context;
    }
    //添加
    public void addData(List<YouKeReMenHuaTiBean.DataBean.TopicBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    //更新
    public void updateData(List<YouKeReMenHuaTiBean.DataBean.TopicBean> list) {
        this.list.clear();
        addData(list);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.remenhuati_item,null);
        TextView tv = (TextView) v.findViewById(R.id.remenhuati_item_tv);
        tv.setText(list.get(0).getTitle());
        return v;
    }
}
