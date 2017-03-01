/*
*JSONUtil.java
*Created on 2014-9-29 上午9:54 by Ivan
*Copyright(c)2014 Guangzhou Onion Information Technology Co., Ltd.
*http://www.cniao5.com
*/
package com.anlaiye.swt.justtalkapp.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
/**
 * 介绍：这里写介绍
 * 作者：sweet
 * 邮箱：sunwentao@imcoming.cn
 * 时间: 2017/3/1
 */
public class JSONUtil {


    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();



    public static  Gson getGson(){
        return  gson;
    }



    public static <T> T fromJson(String json,Class<T> clz){

        return  gson.fromJson(json,clz);
    }


    public static <T> T fromJson(String json,Type type){

        return  gson.fromJson(json,type);
    }


}
