package com.anlaiye.swt.justtalkapp.model;

import java.util.List;

/**
 * 介绍：这里写介绍
 * 作者：sweet
 * 邮箱：sunwentao@imcoming.cn
 * 时间: 2017/3/2
 */

public class Basebean<T> {
    String total;
    List<T> mTList;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<T> getTList() {
        return mTList;
    }

    public void setTList(List<T> TList) {
        mTList = TList;
    }
}
