package com.jason.retrofitdemo.api;




import okhttp3.RequestBody;

import retrofit2.http.Body;
import rx.Observable;

import com.jason.retrofitdemo.Datee;
import com.jason.retrofitdemo.model.User;
import com.jason.retrofitdemo.model.WrapperRspEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author zjh
 * @date 2016/8/19
 */
public interface LoginApi {

    //http://manage.jinsxy.com/InterfaceApi/user/login
//    @POST("/InterfaceApi/user/login")
//    Observable<WrapperRspEntity<User>> log/inReq(@Body RequestBody body);


    @FormUrlEncoded
    @POST("/InterfaceApi/user/register")
    Observable<WrapperRspEntity<Datee>> registerReq(@Field("phone") String userName, @Field("password") String password,
                                                    @Field("nickname") String code, @Field("reg_type") String reg_type);


      @FormUrlEncoded
    @POST("/InterfaceApi/user/login")
    Observable<WrapperRspEntity<User>> loginReq(@Field("phone") String userName, @Field("password") String password, @Field("registration_id") String code);



}
