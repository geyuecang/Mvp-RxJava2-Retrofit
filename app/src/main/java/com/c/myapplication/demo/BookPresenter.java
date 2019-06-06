package com.c.myapplication.demo;

import com.c.myapplication.net.Network;
import com.c.myapplication.net.Result;
import com.c.myapplication.mvp.base.BasePresenter;
import com.c.myapplication.mvp.base.MCallBack;

import io.reactivex.Observable;

/**
 * author : geyuecang
 * date   : 2019/6/6 11:22
 * desc   : desc
 */
public class BookPresenter extends BasePresenter {
    public void getBook() {
        Observable<Result<BookListBean, String>> bookList = Network
                .getInstance()
                .getApiService(BookApi.class, BookApi.HOST)
                .getBookList(1);
        doAsync(bookList, BookApi.BOOKLIST, new MCallBack() {
            @Override
            public void onSuccess(Result result, String tag) {
                if (hasView()) {
                    ((IBookView) getView()).success(result, tag);
                }
            }

            @Override
            public void onNetError(Result errInfo, String tag) {
                if (hasView()) {
                    ((IBookView) getView()).netErr(errInfo, tag);
                }
            }

            @Override
            public void onNetComplete(String tag) {
                if (hasView()) {
                    ((IBookView) getView()).complete(tag);
                }
            }

            @Override
            public void onConnectFail(Throwable e, String tag) {
                if (hasView()) {
                    ((IBookView) getView()).connectFail(e, tag);
                }
            }
        });
    }
}
