package com.anlaiye.swt.justtalkapp.convert;


import com.anlaiye.swt.justtalkapp.exception.DataException;
import com.anlaiye.swt.justtalkapp.exception.NoDataException;
import com.anlaiye.swt.justtalkapp.util.LogUtils;

/**
 * @author qianjujun
 * @time   2016/3/5 16:13
 * @TODO  gson解析实体
 */
public class GsonConvertJson<T> extends BaseGsonConvertJson<T> {
    private final Class<T> clazz;

    public GsonConvertJson(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T convert(String str) throws DataException {
        T t ;
        try {
            t = gson.fromJson(str,clazz);
        }catch (Exception e){
            LogUtils.e("hw----gson error ----", e);
            throw new DataException();
        }
        if(t==null){
            throw new NoDataException();
        }
        return t;
    }
}
