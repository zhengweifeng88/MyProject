package test.bwei.com.myproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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
import test.bwei.com.myproject.view.QuanBuHuaTiActivity;

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
            ((MyViewHolder)holder).pinlun.setText(list.get(position).getComment_count());
            ((MyViewHolder)holder).xihuan.setText(list.get(position).getRead_count());
            ((MyViewHolder)holder).time.setText(list.get(position).getUpdate_time());
            ((MyViewHolder)holder).guanzhetv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }else if(holder instanceof MyViewHolder2){
            youKeReMenHuaTiPresenter.showData();
            ((MyViewHolder2)holder).lv.setHasFixedSize(true);

            StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
            ((MyViewHolder2)holder).lv.setLayoutManager(manager);
            youKeReMenHuaTiAdapter = new YouKeReMenHuaTiAdapter(context);
            ((MyViewHolder2)holder).lv.setAdapter(youKeReMenHuaTiAdapter);
            ((MyViewHolder2)holder).textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, QuanBuHuaTiActivity.class);
                    context.startActivity(intent);

                }
            });
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
        TextView tv,pinlun,xihuan,time,guanzhetv;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tuijian_fragment_item_tv);
            img = (ImageView) view.findViewById(R.id.tuijian_fragment_item_img);
            pinlun = (TextView) view.findViewById(R.id.tuijian_fragment_item_pinlun);
            xihuan = (TextView) view.findViewById(R.id.tuijian_fragment_item_xihuan);
            time = (TextView) view.findViewById(R.id.tuijian_fragment_item_time);
            guanzhetv = (TextView) view.findViewById(R.id.tuijian_fragment_item_guanzhutv);
        }
    }
    class MyViewHolder2 extends RecyclerView.ViewHolder {
        RecyclerView lv;
        TextView textView;
        public MyViewHolder2(View view) {
            super(view);
            lv = (RecyclerView) view.findViewById(R.id.tuijian_fragment_item2_lv);
            textView = (TextView) view.findViewById(R.id.tuijian_fragment_item2_tv);
        }
    }
}
