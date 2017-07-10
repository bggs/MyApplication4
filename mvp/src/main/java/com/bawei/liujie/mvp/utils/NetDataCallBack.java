package com.bawei.liujie.mvp.utils;

import com.bawei.liujie.mvp.model.bean.NewsData;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/7/10
 */

public interface NetDataCallBack {
    void callback(NewsData data);
    void err(int errCode, String errMsg);
}
