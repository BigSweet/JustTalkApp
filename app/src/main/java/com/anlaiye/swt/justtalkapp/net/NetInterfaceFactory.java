package com.anlaiye.swt.justtalkapp.net;


/**
 * @author Qianjujun
 * @time 2016/3/8
 */
public class NetInterfaceFactory {
    public static NetInterface getNetInterface(){
        return IonNetInterface.get();
    }

}
