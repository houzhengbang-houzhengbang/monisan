package com.example.asus.monisan.v.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.monisan.R;
import com.example.asus.monisan.m.bean.CarBean;
import com.example.asus.monisan.m.bean.ListBean;
import com.example.asus.monisan.m.netUtil.FrescoUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class Car_List_RecyAdapter extends RecyclerView.Adapter {
    private Context context;
    private View item;

    public Car_List_RecyAdapter(Context context) {
        this.context = context;
    }

    private List<CarBean.DataBean.ListBean> list = new ArrayList<>();

    public void setData(List<CarBean.DataBean.ListBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.car_list_recy_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;

        String images = list.get(position).getImages();
        String s = images;
        int i = images.indexOf("|");
        if (i != -1) {
            s = images.substring(0, i);
        }
        FrescoUtil.setJianJin(s, viewHolder.sdv_product_list_item);
        viewHolder.tv_product_list_item1.setText(list.get(position).getTitle());

/*       item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ParticularsActivity.class);
                Log.e("123", "onClick: "+list.get(position).getPid() );
                intent.putExtra("pid", list.get(position).getPid());
                context.startActivity(intent);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView sdv_product_list_item;
        private TextView tv_product_list_item1;

        public MyViewHolder(View itemView) {
            super(itemView);
            item = itemView;
            sdv_product_list_item = itemView.findViewById(R.id.car_list_item);
            tv_product_list_item1 = itemView.findViewById(R.id.car_list_item1);
        }

    }
}
