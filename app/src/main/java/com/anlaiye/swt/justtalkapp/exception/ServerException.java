package com.anlaiye.swt.justtalkapp.exception;


import com.anlaiye.swt.justtalkapp.result.ResultMessage;

/**
 * 介绍：这里写介绍
 * 作者：sweet
 * 邮箱：sunwentao@imcoming.cn
 * 时间: 2017/3/2
 */
public class ServerException extends Exception{
    private int errorCode;

    public ServerException(String detailMessage, int errorCode) {
        super(detailMessage);
        this.errorCode = errorCode;
    }


    public ResultMessage parse(){
        return ResultMessage.error(errorCode, this);
    }
}
