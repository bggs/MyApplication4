package com.bawei.liujie.mvp.present;

import com.bawei.liujie.mvp.model.bean.NewsData;
import com.bawei.liujie.mvp.utils.HttpUtils;
import com.bawei.liujie.mvp.utils.NetDataCallBack;
import com.bawei.liujie.mvp.view.IMainView.IMainView;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/7/10
 */

public class IMainPresent {

    private HttpUtils utils;
    private IMainView iMainView;

    public IMainPresent(IMainView iMainView) {
        utils = new HttpUtils();
        this.iMainView = iMainView;
    }

    public void loadNet(String url) {
        utils.LoadDataFromServer(url, new NetDataCallBack() {
            @Override
            public void callback(NewsData data) {
                iMainView.successCallBack(data);
            }

            @Override
            public void err(int errCode, String errMsg) {

                //iMainView.errorCallBack(errMsg, 405);
            }
        });
    }
}
