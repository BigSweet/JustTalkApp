package com.anlaiye.swt.justtalkapp.model;

/**
 * 介绍：这里写介绍
 * 作者：sweet
 * 邮箱：sunwentao@imcoming.cn
 * 时间: 2017/3/2
 */

public class BaseJavaBean {

    String result;
    String flag;
    String message;
    Basebean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Basebean getData() {
        return data;
    }

    public void setData(Basebean data) {
        this.data = data;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
