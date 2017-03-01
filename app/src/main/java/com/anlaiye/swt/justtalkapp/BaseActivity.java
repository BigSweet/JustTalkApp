/*
*BaseActivity.java
*Created on 2014-9-25 上午10:58 by Ivan
*Copyright(c)2014 Guangzhou Onion Information Technology Co., Ltd.
*http://www.cniao5.com
*/
package com.anlaiye.swt.justtalkapp;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.anlaiye.swt.justtalkapp.http.VolleyHttpClient;
import com.anlaiye.swt.justtalkapp.sys.Constant;

/**
 * 介绍：这里写介绍
 * 作者：sweet
 * 邮箱：sunwentao@imcoming.cn
 * 时间: 2017/3/1
 */
public class BaseActivity extends AppCompatActivity {

    protected  String TAG=BaseActivity.class.getClass().getSimpleName();
    protected VolleyHttpClient mHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHttpClient = new VolleyHttpClient(this);
    }



    protected  void initActionBarBasic(){

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            setResult(Constant.RESULT_CODE);
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
