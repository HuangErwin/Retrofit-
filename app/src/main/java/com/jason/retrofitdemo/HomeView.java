package com.jason.retrofitdemo;

import com.jason.retrofitdemo.model.User;
import com.jason.retrofitdemo.model.WrapperRspEntity;

/**
 * Created by Administrator on 2018/3/31 0031.
 */

public interface HomeView {

    void onSuccess(WrapperRspEntity<? extends BaseBean> userWrapperRspEntity);
    void onError(Throwable e);
    void showDialog();
    void dismissDialog();
}
