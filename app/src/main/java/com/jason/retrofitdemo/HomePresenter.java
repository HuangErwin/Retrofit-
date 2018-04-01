package com.jason.retrofitdemo;

import com.jason.retrofitdemo.api.LoginApi;
import com.jason.retrofitdemo.model.WrapperRspEntity;
import com.jason.retrofitdemo.net.RetrofitManager;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/3/31 0031.
 */

public class HomePresenter extends BasePresenter{

    private HomeView homeView;

    public HomePresenter(HomeView homeView) {
        super(homeView);
        this.homeView = homeView;
    }

//    private RequestBody createRequestBody(String json) {
//        return RequestBody.create(JSON, json.toString());
//    }

//    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//    public static final MediaType JSON = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");



    public void requestLogin(String test1, String s,String id ) {
        homeView.showDialog();

//        JSONObject json = new JSONObject();
//        try {
//            json.put("phone", test1);
//            json.put("password", s);
//            json.put("registration_id", id);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

//        RequestBody body = new FormBody.Builder()
//                .add("phone",test1)
//                .add("password",s)
//                .add("registration_id",id).build();


//        RequestBody requestBody = createRequestBody(json.toString());

       setObservable(getApi().loginReq(test1,s,id)).subscribe(this);
    }

    /**
     * 注册
     * @param s
     * @param s1
     * @param s2
     */
    public void requestRegister(String s, String s1, String s2,String s4) {
        homeView.showDialog();
        setObservable(getApi().registerReq(s, s1,s2,s4)).subscribe(this);
    }


}
