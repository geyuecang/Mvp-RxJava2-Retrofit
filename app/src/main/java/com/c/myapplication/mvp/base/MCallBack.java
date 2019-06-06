package com.c.myapplication.mvp.base;

import com.c.myapplication.net.Result;

/**
 * author : geyuecang
 * date   : 2019/3/6 14:44
 * desc   : desc
 */
public interface MCallBack<T extends Result> {

    /**
     * 请求成功
     *
     * @param t
     * @param tag
     */
    void onSuccess(T t, String tag);

    /**
     * 返回错误信息
     *
     * @param errInfo
     * @param tag
     */
    void onNetError(T errInfo, String tag);

    /**
     * onComplete
     *
     * @param tag
     */
    void onNetComplete(String tag);

    /**
     * 网络异常
     *
     * @param e
     * @param tag
     */
    void onConnectFail(Throwable e, String tag);
}
