package com.anlaiye.swt.justtalkapp.listener;

import java.util.List;

/**
 * 数据第二层继承
 *
 * 作者：xjzhao
 * 时间：2015-03-19 上午10:58
   修改人：  qianjujun
   修改时间：2016/3/5 16:12
   修改内容：

 */
public interface DataListener<T> {

    List<T> getList();

    int getTotal();

    int getCurrentpage();

    int getCurrentPageSize();


    int getRowSize();

    String getNextNt();


}
