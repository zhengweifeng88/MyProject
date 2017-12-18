package test.bwei.com.myproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import test.bwei.com.myproject.R;
import test.bwei.com.myproject.bean.YouKeReMenHuaTiBean;

/**
 * Created by Administrator on 2017/12/16.
 */

public class QuanBuHuaTiAdapter extends RecyclerView.Adapter<QuanBuHuaTiAdapter.MyViewHolder> {
    Context context;
    List<YouKeReMenHuaTiBean.DataBean.TopicBean> list = new ArrayList<>();

    public QuanBuHuaTiAdapter(Context context) {
        this.context = context;
    }

    //添加
    public void addData(List<YouKeReMenHuaTiBean.DataBean.TopicBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    //更新
    public void updateData(List<YouKeReMenHuaTiBean.DataBean.TopicBean> list) {
        this.list.clear();
        addData(list);
    }

    @Override
    public QuanBuHuaTiAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        QuanBuHuaTiAdapter.MyViewHolder holder = new QuanBuHuaTiAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.quanbuhuati_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(QuanBuHuaTiAdapter.MyViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getLogo()).into(holder.quanbuhuati_img);
//        holder.quanbuhuati_item_tv.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView quanbuhuati_img;
        TextView quanbuhuati_item_tv;

        public MyViewHolder(View view) {
            super(view);
            quanbuhuati_img = (ImageView) view.findViewById(R.id.quanbuhuati_item_img);
//            quanbuhuati_item_tv = (TextView) view.findViewById(R.id.quanbuhuati_item_tv);
        }
    }
}
