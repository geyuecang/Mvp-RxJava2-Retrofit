package com.c.myapplication.demo;

import android.os.Bundle;
import android.util.Log;

import com.c.myapplication.R;
import com.c.myapplication.net.Result;
import com.c.myapplication.mvp.base.BaseMvpActivity;
import com.c.myapplication.mvp.base.PresenterHelper;

public class MainActivity extends BaseMvpActivity implements IBookView {

    private String TAG = getClass().getSimpleName();
    private BookPresenter bookPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_test);
        bookPresenter = PresenterHelper.create(BookPresenter.class, this);
        bookPresenter.getBook();
    }

    @Override
    public void success(Result result, String tag) {
        Log.d(TAG, "success=====>" + result.toString());
    }

    @Override
    public void netErr(Result result, String tag) {
        Log.d(TAG, "netErr=====>" + result.toString());
    }

    @Override
    public void connectFail(Throwable e, String tag) {
        Log.d(TAG, "connectFail=====>");
    }

    @Override
    public void complete(String tag) {
        Log.d(TAG, "complete=====>");
    }
}
