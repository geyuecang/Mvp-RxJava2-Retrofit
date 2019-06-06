package com.c.myapplication.mvp.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by shichunxiang on 2017/12/26.
 */

public class AppUtil {

    public static String getAppVersionName(Context context) {
        String version = "";
        PackageInfo pInfo = getPackageInfo(context);
        if (pInfo != null) {
            return pInfo.versionName;
        }
        return version;
    }

    public static PackageInfo getPackageInfo(Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            return pm.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = cm.getActiveNetworkInfo();
        if (network != null && network.isConnected()) {
            return true;
        }
        return false;
    }

    /**
     * 获取appVersion  消息新接口和第三方登录接口开始使用
     *
     * @return
     */
    public static String getNewAppVersion() {
        String versionName = AppUtil.getNewAppVersion();
        String appName = "ANDROID_KFZ_COM";

        String apiId = appName + "_" + versionName;
        return apiId;
    }
}
