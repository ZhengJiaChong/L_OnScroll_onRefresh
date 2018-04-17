package com.example.administrator.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/16.
 */

public class MenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<Map<String,Object>> mDataList;
    private static final int ITEM_VIEW=0;
    private static final int FOOT_VIEW=1;
    public MenuAdapter(Context context,List<Map<String,Object>> dataList){
        mContext = context;
        mDataList = dataList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.litem_view,null);
        View footView = LayoutInflater.from(mContext).inflate(R.layout.foot_view,null);
        if (viewType == ITEM_VIEW)
            return new ViewHolder(itemView,viewType);
        return new ViewHolder(footView,viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder=(ViewHolder)holder;
        if (getItemViewType(position)==ITEM_VIEW){
            viewHolder.imageView.setImageResource((int)mDataList.get(position).get("menu_thumb"));
            viewHolder.tvTitle.setText((String)mDataList.get(position).get("menu_title"));
            viewHolder.tvContent.setText((String)mDataList.get(position).get("menu_info"));
        }else {
            viewHolder.tvFoot.setText("加载中...");
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==mDataList.size())
            return FOOT_VIEW;
        return ITEM_VIEW;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView tvTitle,tvContent,tvFoot;
        public ViewHolder(View itemView,int viewType) {
            super(itemView);
            if (viewType == ITEM_VIEW){
                imageView = (ImageView)itemView.findViewById(R.id.image_view);
                tvTitle = (TextView)itemView.findViewById(R.id.tv_title);
                tvContent = (TextView)itemView.findViewById(R.id.tv_content);
            }else{
                tvFoot = (TextView)itemView.findViewById(R.id.tv_foot);
            }
        }
    }
}
