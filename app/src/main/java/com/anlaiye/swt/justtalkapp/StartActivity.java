/*
*StartActivity.java
*Created on 2014-9-25 下午3:34 by Ivan
*Copyright(c)2014 Guangzhou Onion Information Technology Co., Ltd.
*http://www.cniao5.com
*/
package com.anlaiye.swt.justtalkapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.anlaiye.swt.justtalkapp.http.BaseRequest;
import com.anlaiye.swt.justtalkapp.model.BaseJavaBean;
import com.anlaiye.swt.justtalkapp.model.StartBean;
import com.anlaiye.swt.justtalkapp.sys.Constant;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.trinea.android.common.util.PreferencesUtils;
import cn.trinea.android.common.util.ToastUtils;

/**
 * Created by Ivan on 14-9-25.
 * Copyright(c)2014 Guangzhou Onion Information Technology Co., Ltd.
 * http://www.cniao5.com
 */
public class StartActivity extends BaseActivity {


    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);


//        PushManager.startWork(this, PushConstants.LOGIN_TYPE_API_KEY, ManifestUtil.getMetaValue(this,Constant.BD_API_KEY));


        mWebView = (WebView) this.findViewById(R.id.webview);


        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setHorizontalScrollBarEnabled(false);

        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        getUrl();
//        mWebView.loadUrl();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                jump();
            }
        }, 2000);


    }


    private void jump() {


        String memberJson = PreferencesUtils.getString(this, Constant.MEMBER);
        if (TextUtils.isEmpty(memberJson)) {
            startActivity(new Intent(this, MainActivity.class));
            this.finish();
        } else {
            handler.post(new AuthCheckRunnable());
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == Constant.SUCCESS) {
                startActivity(new Intent(StartActivity.this, MainActivity.class));
                StartActivity.this.finish();
            } else if (msg.what == Constant.FAIL) {
                ToastUtils.show(StartActivity.this, "认证过期，请重新认证");
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }

        }
    };

    public void getUrl() {
        RequestQueue mReuestQueue = Volley.newRequestQueue(this);
        String url = "http://adsvc.imcoming.com.cn/ad/app/getList.do";
        Map<String, String> maps = new HashMap<>();
        maps.put("device_id", "868026024156875");
        maps.put("schoolId", "1237");
        maps.put("time", System.currentTimeMillis() + "");
        maps.put("locationId", "1");
        maps.put("app_version", "3.1.5");
        maps.put("client_type", "2");
        JSONObject jsonObject = new JSONObject(maps);
        BaseRequest request = new BaseRequest(Request.Method.POST, url, jsonObject, new Response.Listener<BaseJavaBean>() {
            @Override
            public void onResponse(BaseJavaBean response) {
                List<StartBean> StartBean = (List<com.anlaiye.swt.justtalkapp.model.StartBean>) response.getData().getTList();
                String url = StartBean.get(0).getUrl();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> heads = new HashMap<>();
                heads.put("Content-Type", "application/json");
                return heads;
            }
        };
        mReuestQueue.add(request);

    }


    class AuthCheckRunnable implements Runnable {

        @Override
        public void run() {

            int authResult = PreferencesUtils.getInt(StartActivity.this, Constant.FLAG_AUTH, -1);
            if (authResult != -1) {
                handler.sendEmptyMessage(authResult);
            } else
                handler.postDelayed(new AuthCheckRunnable(), 1000);

        }
    }

}
