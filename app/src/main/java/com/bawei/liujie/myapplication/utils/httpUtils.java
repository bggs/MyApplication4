package com.bawei.liujie.myapplication.utils;

import android.util.Log;

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
 * date:2017/7/6
 */

public class httpUtils {
    private String url = "http://www.baidu.com";
    private static final String TAG = "MainActivity";

    public void okHttp() {

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        //创建okHttpClient对象
                        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                .connectTimeout(10, TimeUnit.SECONDS)
                                .readTimeout(20, TimeUnit.SECONDS)
                                .build();
                        //创建一个Request
                        Request request = new Request.Builder()
                                .url(url)
                                .build();
                        Call call = okHttpClient.newCall(request);
                        //请求加入调度
                        call.enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                Log.e(TAG, "onFailure: " + e.getMessage());
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                Log.i(TAG, "onResponse: " + response.body().string());
                            }
                        });
                        try {
                            Response response = call.execute();
                            if(response.isSuccessful()){
                                String string = response.body().string();
                                System.out.println(string);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
        ).start();
    }
}
