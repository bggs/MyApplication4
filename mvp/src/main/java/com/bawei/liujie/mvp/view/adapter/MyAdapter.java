package com.bawei.liujie.mvp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.liujie.mvp.R;
import com.bawei.liujie.mvp.model.bean.NewsData;

import java.util.List;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/7/10
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<NewsData.DataBean> list;

    public MyAdapter(Context context, List<NewsData.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.listview,null);
            holder=new ViewHolder();
            holder.icon= (ImageView) convertView.findViewById(R.id.icon);
            holder.text= (TextView) convertView.findViewById(R.id.text);
            convertView.getTag();
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        //Glide.with(context).load(list.get(position).getPic_url()).into(holder.icon);
        holder.text.setText(list.get(position).getNews_title());
        return convertView;
    }
    class ViewHolder{
        ImageView icon;
        TextView text;
    }
}
