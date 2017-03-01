/*
*VolleySingleton.java
*Created on 2014-9-25 上午10:29 by Ivan
*Copyright(c)2014 Guangzhou Onion Information Technology Co., Ltd.
*http://www.cniao5.com
*/
package com.anlaiye.swt.justtalkapp.http;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * 介绍：这里写介绍
 * 作者：sweet
 * 邮箱：sunwentao@imcoming.cn
 * 时间: 2017/3/1
 */
public class VolleySingleton {


    private static VolleySingleton mInstance;


    private RequestQueue mReuestQueue;

    public static synchronized VolleySingleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleySingleton(context.getApplicationContext());
        }
        return mInstance;
    }

    VolleySingleton()

    {
    }



    private VolleySingleton(Context context) {

        mReuestQueue = Volley.newRequestQueue(context);

    }


    public RequestQueue getRequestQueue() {

        return this.mReuestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req) {

        getRequestQueue().add(req);
    }


    public void cancleRequest(Object tag) {

        getRequestQueue().cancelAll(tag);
    }


}
