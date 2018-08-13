package com.map.library.service.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by liangchao_suxun on 17/1/16.
 * 用于判断设备是否可以访问网络。
 */

public class NetUtil {


    private static class Holder {
        public static NetUtil instance = new NetUtil();
    }

    public static NetUtil getInstance() {
        return Holder.instance;
    }

    /**
     * 是否手机信号可连接
     * @param context context
     * @return  是否手机信号可连接
     */

    public boolean isMobileAva(Context context) {

        boolean hasMobileCon = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfos = cm.getAllNetworkInfo();
        for (NetworkInfo net : netInfos) {

            String type = net.getTypeName();
            if ("MOBILE".equalsIgnoreCase(type)) {
                if (net.isConnected()) {
                    hasMobileCon = true;
                }
            }
        }
        return hasMobileCon;
    }


    /**
     * 是否wifi可连接
     * @param context context
     * @return 是否wifi可连接
     */

    public boolean isWifiCon(Context context) {
        boolean hasWifoCon = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfos = cm.getAllNetworkInfo();
        for (NetworkInfo net : netInfos) {

            String type = net.getTypeName();
            if ("WIFI".equalsIgnoreCase(type)) {
                if (net.isConnected()) {
                    hasWifoCon = true;
                }
            }

        }
        return hasWifoCon;

    }
}
