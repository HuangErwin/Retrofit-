package com.jason.retrofitdemo.net.interceptor;


import com.jason.retrofitdemo.BaseBean;
import com.jason.retrofitdemo.util.InterceptorUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @author zjh
 * @date 2016/8/31
 */
public class RspCheckInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
            try {
                ResponseBody rspBody = response.body();
                JSONObject jsonObject = new JSONObject(InterceptorUtils.getRspData(rspBody));
                String status = jsonObject.getString("code");

                JSONArray data1 = jsonObject.getJSONArray("data");
                if(null!=data1){
                    jsonObject.remove("data");

                    jsonObject.put("data",null);
                }
                //                if (status < 200 || status >= 300){
//                    throw new IOException(jsonObject.getString("msg"));
//                }
            } catch (JSONException e) {
                e.printStackTrace();
                throw new IOException("parase data error");
            }catch (Exception e){
                if (e instanceof IOException){
                    throw (IOException)e;
                }
            }

        return response;
    }



}
