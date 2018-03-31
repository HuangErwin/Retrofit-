package com.jason.retrofitdemo;

import com.jason.retrofitdemo.api.LoginApi;
import com.jason.retrofitdemo.model.User;
import com.jason.retrofitdemo.model.WrapperRspEntity;
import com.jason.retrofitdemo.net.RetrofitManager;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/3/31 0031.
 */

public class HomePresenter implements Observer<WrapperRspEntity<? extends BaseBean>> {

    private HomeView homeView;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
    }

    /**
     * 登录
     * @param test1
     * @param s
     * @param userClass
     */
    public void requestLogin(String test1, String s, Class<User> userClass) {
        homeView.showDialog();
        setObservable(getApi().loginReq(test1, s)).subscribe(this);
    }

    /**
     * 注册
     * @param s
     * @param s1
     * @param s2
     */
    public void requestRegister(String s, String s1, String s2) {
        homeView.showDialog();
        setObservable(getApi().registerReq(s, s1,s2)).subscribe(this);
    }


    private Observable setObservable(Observable observable) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private LoginApi getApi() {
        return RetrofitManager.getInstance().createReq(LoginApi.class);
    }

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        homeView.dismissDialog();
    }

    @Override
    public void onNext(WrapperRspEntity<? extends BaseBean> wrapperRspEntity) {
        homeView.dismissDialog();
        homeView.onSuccess(wrapperRspEntity);
    }


}
