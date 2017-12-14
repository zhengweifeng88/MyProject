package test.bwei.com.myproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import test.bwei.com.myproject.R;
import test.bwei.com.myproject.bean.YouKeReMenHuaTiBean;
import test.bwei.com.myproject.bean.YouKeTuJianBean;
import test.bwei.com.myproject.contract.YouKeReMenHuaTiContract;
import test.bwei.com.myproject.presenter.YouKeReMenHuaTiPresenter;

/**
 * Created by Administrator on 2017/12/14.
 */

public class YouKeTuiJianAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements YouKeReMenHuaTiContract.IYouKeReMenHuaTiView{
    Context context;
    List<YouKeTuJianBean.DataBean.ArticleBean> list = new ArrayList<>();
    YouKeReMenHuaTiPresenter youKeReMenHuaTiPresenter = new YouKeReMenHuaTiPresenter(this);
    YouKeReMenHuaTiAdapter youKeReMenHuaTiAdapter;
    int TYPE1 = 1;
    int TYPE2 = 2;
    public YouKeTuiJianAdapter(Context context) {
        this.context = context;
    }
    //添加
    public void addData(List<YouKeTuJianBean.DataBean.ArticleBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    //更新
    public void updateData(List<YouKeTuJianBean.DataBean.ArticleBean> list) {
        this.list.clear();
        addData(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 2){
            //加载布局
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.tuijian_fragment_item, parent,
                    false));
            return holder;
        }else{
            MyViewHolder2 holder2 = new MyViewHolder2(LayoutInflater.from(context).inflate(R.layout.tuijian_fragment_item2, parent,
                    false));
            return holder2;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyViewHolder){
            //赋值
            Glide.with(context).load(list.get(position).getFace()).into(((MyViewHolder)holder).img);
            ((MyViewHolder)holder).tv.setText(list.get(position).getSummary());
        }else if(holder instanceof MyViewHolder2){
            youKeReMenHuaTiPresenter.showData();
            youKeReMenHuaTiAdapter = new YouKeReMenHuaTiAdapter(context);
            ((MyViewHolder2)holder).lv.setAdapter(youKeReMenHuaTiAdapter);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if(position == 3){
            return 1;
        }else{
            return 2;
        }
//        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        //返回集合长度
        return list.size();
    }

    @Override
    public void setData(List<YouKeReMenHuaTiBean.DataBean.TopicBean> list) {
        youKeReMenHuaTiAdapter.addData(list);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tuijian_fragment_item_tv);
            img = (ImageView) view.findViewById(R.id.tuijian_fragment_item_img);
        }
    }
    class MyViewHolder2 extends RecyclerView.ViewHolder {
        ListView lv;
        public MyViewHolder2(View view) {
            super(view);
            lv = (ListView) view.findViewById(R.id.tuijian_fragment_item2_lv);
        }
    }
}
