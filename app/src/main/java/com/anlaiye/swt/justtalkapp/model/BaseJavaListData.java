package com.anlaiye.swt.justtalkapp.model;


import com.anlaiye.swt.justtalkapp.listener.DataListener;

import java.util.List;

/**
 * @author qianjujun
 * @time   2016/3/5 16:11
 * @TODO  java 分页数据的基类
 */
public class BaseJavaListData<T extends BaseListJavaBean<K>,K> extends BaseData<T> implements DataListener<K> {
    @Override
    public List<K> getList() {
        if(isSuccess()){
            return getData().getList();
        }
        return null;
    }

    @Override
    public int getTotal() {
        if(isSuccess()){
            return getData().getTotal();
        }
        return 0;
    }


    @Override
    public int getCurrentpage() {
        if(isSuccess()){
            return getData().getPageNo();
        }
        return 0;
    }

    @Override
    public int getCurrentPageSize() {
        return getList()==null?0:getList().size();
    }


    @Override
    public int getRowSize() {
        return 1;
    }

    @Override
    public String getNextNt() {
        if(isSuccess()){
            return getData().getNt();
        }
        return null;
    }

    protected boolean isSuccess(){
        return getFlag()==1&&null!=getData();
    }
}
