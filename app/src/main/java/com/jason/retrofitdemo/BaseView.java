package com.jason.retrofitdemo;

import com.jason.retrofitdemo.model.WrapperRspEntity;

/**
 * Created by Liangyao on 2018/4/2 00:57.
 * <p>
 * email: developkk@foxmail.com
 * <p>
 * doc:
 */
public interface BaseView {
    void onSuccess(WrapperRspEntity<? extends BaseBean> userWrapperRspEntity);
    void onError(Throwable e);
    void showDialog();
    void dismissDialog();
}
