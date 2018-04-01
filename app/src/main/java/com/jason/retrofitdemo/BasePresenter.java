package com.jason.retrofitdemo;

import com.jason.retrofitdemo.api.LoginApi;
import com.jason.retrofitdemo.model.WrapperRspEntity;
import com.jason.retrofitdemo.net.RetrofitManager;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Liangyao on 2018/4/2 00:53.
 * <p>
 * email: developkk@foxmail.com
 * <p>
 * doc:
 */
public class BasePresenter  implements Observer<WrapperRspEntity<? extends BaseBean>> {
    private final BaseView view;
    public BasePresenter(BaseView homeView) {
     this.view = homeView;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        view.dismissDialog();
        view.onError(e);
    }

    @Override
    public void onNext(WrapperRspEntity<? extends BaseBean> wrapperRspEntity) {
        view.dismissDialog();
        view.onSuccess(wrapperRspEntity);
    }



    public Observable setObservable(Observable observable) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public LoginApi getApi() {
        return RetrofitManager.getInstance().createReq(LoginApi.class);
    }


}
