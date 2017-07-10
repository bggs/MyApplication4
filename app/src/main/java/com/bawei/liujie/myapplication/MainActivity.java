package com.bawei.liujie.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.liujie.myapplication.utils.httpUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        httpUtils utils=new httpUtils();
        utils.okHttp();
    }
}
