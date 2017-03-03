package com.anlaiye.swt.justtalkapp.convert;


import com.anlaiye.swt.justtalkapp.exception.DataException;

/**
 * @author qianjujun
 * @time   2016/3/5 16:13
 * @TODO  json解析接口
 */
public interface ConvertJson<T> {

    T convert(String str) throws DataException;



}
