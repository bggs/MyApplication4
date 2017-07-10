package com.bawei.liujie.mvp.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.bawei.liujie.mvp.R;
import com.bawei.liujie.mvp.model.bean.NewsData;
import com.bawei.liujie.mvp.present.IMainPresent;
import com.bawei.liujie.mvp.view.IMainView.IMainView;
import com.bawei.liujie.mvp.view.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView {

    private ListView mListview;
    private IMainPresent iMainPresent;
    private String url = "http://api.expoon.com/AppNews/getNewsList/type/1/p/1";
    private List<NewsData.DataBean> list = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initView() {
        mListview = (ListView) findViewById(R.id.listview);
    }

    private void initData() {
        iMainPresent = new IMainPresent(this);
        iMainPresent.loadNet(url);


    }

    @Override
    public void successCallBack(NewsData data) {

        List<NewsData.DataBean> data1 = data.getData();
        Log.e("dd", "successCallBack: "+data1.get(0).getNews_title() );
        list.addAll(data1);
        adapter = new MyAdapter(MainActivity.this, list);
        mListview.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
    }

    @Override
    public void errorCallBack(String str, int code) {


    }
}
