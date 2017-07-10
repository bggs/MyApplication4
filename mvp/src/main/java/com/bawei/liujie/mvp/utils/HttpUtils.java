package com.bawei.liujie.mvp.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bawei.liujie.mvp.model.bean.NewsData;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/7/10
 */

public class HttpUtils {
    private NetDataCallBack net;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    NewsData data = (NewsData) msg.obj;
                    net.callback(data);
                    break;
            }
        }
    };

    public void LoadDataFromServer(String url, NetDataCallBack netDataCallBack) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(100, TimeUnit.SECONDS)
                .connectTimeout(200, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //net.err(404, e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String string = response.body().string();
                Log.e("str", "onResponse: "+string );
                NewsData data = gson.fromJson(string, NewsData.class);
                Message msg = Message.obtain();
                msg.obj = data;
                msg.what = 1;
                handler.sendMessage(msg);
            }
        });

    }
}
