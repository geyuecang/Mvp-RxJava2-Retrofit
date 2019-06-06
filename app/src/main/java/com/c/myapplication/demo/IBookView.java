package com.c.myapplication.demo;

import com.c.myapplication.net.Result;
import com.c.myapplication.mvp.base.IView;

/**
 * author : geyuecang
 * date   : 2019/6/6 11:25
 * desc   : desc
 */
public interface IBookView extends IView {
    void success(Result result, String tag);

    void netErr(Result result, String tag);

    void connectFail(Throwable e, String tag);

    void complete(String tag);
}
