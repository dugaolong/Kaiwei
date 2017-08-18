package com.dgl.www.kaiwei.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dgl.www.kaiwei.R;
import com.dgl.www.kaiwei.bean.DataItem;

import java.util.List;

/**
 * Created by dugaolong on 16/8/21.
 */
public class RecycleAdapter extends RecyclerView.Adapter<MyViewHolder> implements View.OnClickListener{

    private LayoutInflater mInflater;
    private Context mContext;
    private List<DataItem> mDatas;

    public RecycleAdapter(Context context, List<DataItem> datas) {
        this.mContext = context;
        this.mDatas = datas;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onClick(View view) {
        onItemClickListener.onItemClick(view, (Integer) view.getTag());
    }

    //定义一个回调接口
    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }
    //定义一个接口的变量
    public OnItemClickListener onItemClickListener;
    //暴露对外的方法,提供实现者调用
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    //创建itemview
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycle_item,parent,false);
        view.setOnClickListener(this);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    //item和data绑定
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String imageUrl = mDatas.get(position).getThumbnail();
        if(!"".equals(imageUrl)){
            holder.imageView.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(imageUrl).into(holder.imageView);
        }else {
            holder.imageView.setVisibility(View.GONE);
        }

        holder.title.setText(mDatas.get(position).getTitle());
        holder.source.setText(mDatas.get(position).getSource());
        holder.itemView.setTag(position);
    }

    //数据总个数
    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView title;
    TextView source;
    //初始化item中的控件
    public MyViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image_item);
        title = (TextView) itemView.findViewById(R.id.title_item);
        source = (TextView) itemView.findViewById(R.id.source_item);
    }
}
