package com.baway.jingzeyang;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by 荆泽阳 on 2017/3/9.
 * .::::.
 * .::::::::.
 * :::::::::::  Goddess bless, never bug
 * ..:::::::::::'
 * '::::::::::::'
 * .::::::::::
 * '::::::::::::::..
 * ..::::::::::::.
 * ``::::::::::::::::
 * ::::``:::::::::'        .:::.
 * ::::'   ':::::'       .::::::::.
 * .::::'      ::::     .:::::::'::::.
 * .:::'       :::::  .:::::::::' ':::::.
 * .::'        :::::.:::::::::'      ':::::.
 * .::'         ::::::::::::::'         ``::::.
 * ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 * '.:::::'                    ':'````..
 */

public class XrecyclerViewAdapter extends XRecyclerView.Adapter<XrecyclerViewAdapter.MyViewHolder> {
    private List<Bean.ResultBean.RowsBean.InfoBean> list;
    private Context context;

    public XrecyclerViewAdapter(List<Bean.ResultBean.RowsBean.InfoBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(View.inflate(context, R.layout.adapteritem, null));

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.text1.setText(list.get(position).getAddress());
        holder.text2.setText(list.get(position).getLoupan_name());
        holder.text3.setText(list.get(position).getTags());

        holder.text4.setText(list.get(position).getPrice()+"");
        Glide.with(context).load(list.get(position).getDefault_image()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView text1, text2, text3, text4;

        public MyViewHolder(View v) {
            super(v);
            imageView = (ImageView) v.findViewById(R.id.imager);
            text1 = (TextView) v.findViewById(R.id.text1);
            text2 = (TextView) v.findViewById(R.id.text2);
            text3 = (TextView) v.findViewById(R.id.text3);
            text4 = (TextView) v.findViewById(R.id.text4);

        }
    }
}
