package test.bwei.com.myproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import test.bwei.com.myproject.R;
import test.bwei.com.myproject.bean.YouKeReMenHuaTiBean;

/**
 * Created by Administrator on 2017/12/14.
 */
public class YouKeReMenHuaTiAdapter extends RecyclerView.Adapter<YouKeReMenHuaTiAdapter.MyViewHolder>
{
    Context context;
    List<YouKeReMenHuaTiBean.DataBean.TopicBean> list = new ArrayList<>();

    public YouKeReMenHuaTiAdapter(Context context) {
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
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.remenhuati_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        Glide.with(context).load(list.get(position).getLogo()).into(holder.remenhuati_item_img);
        holder.remenhuati_item_title.setText(list.get(position).getTitle());
        holder.remenhuati_item_comment_count.setText(list.get(position).getComment_count() + "人参与");
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        ImageView remenhuati_item_img;
        TextView remenhuati_item_title;
        TextView remenhuati_item_comment_count;

        public MyViewHolder(View view)
        {
            super(view);
            remenhuati_item_img = (ImageView) view.findViewById(R.id.remenhuati_item_img);
            remenhuati_item_title = (TextView) view.findViewById(R.id.remenhuati_item_title);
            remenhuati_item_comment_count = (TextView) view.findViewById(R.id.remenhuati_item_comment_count);
        }
    }
}

