package com.bawei.liujie.mvp.view.IMainView;

import com.bawei.liujie.mvp.model.bean.NewsData;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/7/10
 */

public interface IMainView {
    void successCallBack(NewsData data);
    void errorCallBack(String str,int code);
}
