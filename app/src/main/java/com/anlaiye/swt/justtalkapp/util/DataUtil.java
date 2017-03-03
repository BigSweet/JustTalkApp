package com.anlaiye.swt.justtalkapp.util;


import com.anlaiye.swt.justtalkapp.net.JavaRequestParem;
import com.anlaiye.swt.justtalkapp.net.RequestParem;

/**
 * 介绍：这里写介绍
 * 作者：sweet
 * 邮箱：sunwentao@imcoming.cn
 * 时间: 2017/3/2
 */

public class DataUtil {

    //获取社团类型列表
    public static RequestParem getUrl() {
        return JavaRequestParem.post("http://adsvc.imcoming.com.cn/ad/app/getList.do")
                .putBody("locationId", "1")
                .putBody("client_type", "2")
                .putBody("device_id", "868026024156875")
                .putBody("schoolId", "1237")
                .putBody("app_version","3.1.5")
                .putBody("time", System.currentTimeMillis());

    }
}
