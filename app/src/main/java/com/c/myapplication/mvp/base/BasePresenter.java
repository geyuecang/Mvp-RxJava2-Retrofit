package com.c.myapplication.mvp.base;

import com.c.myapplication.net.Result;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author : geyuecang
 * date   : 2019/3/5 16:36
 * desc   : desc
 */
public class BasePresenter extends Presenter {
    private CompositeDisposable mCompositeDisposable;

    protected <T extends Result> void doAsync(Observable<T> observable, final String tag, final MCallBack callBack) {
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisable(d);
                    }

                    @Override
                    public void onNext(T value) {
                        //服务器正常返回
                        if (value.getStatus() == 0) {
                            callBack.onNetError(value, tag);
                        } else if (value.getStatus() == 1) {
                            callBack.onSuccess(value, tag);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        //服务器异常
                        callBack.onConnectFail(e, tag);
                    }

                    @Override
                    public void onComplete() {
                        callBack.onNetComplete(tag);
                    }
                });

    }

    private void addDisable(Disposable d) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(d);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }
}
