package com.jason.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jason.retrofitdemo.model.User;
import com.jason.retrofitdemo.model.WrapperRspEntity;

import java.util.Observable;

import rx.Observer;

public class MainActivity extends AppCompatActivity implements HomeView {
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.tv);

        /**
         * 创建presenter 对象，并把本类的引用传过去，实现他的方法。接收方是一个借口，所以需要实现他的方法。
         */
        HomePresenter homePresenter = new HomePresenter(this);
        homePresenter.requestLogin("test1", "123456",User.class);//调用登录的借口


        homePresenter.requestRegister("2","3","4");

    }


    @Override
    public void onSuccess(WrapperRspEntity<? extends BaseBean> userWrapperRspEntity) {


    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {

    }
}
