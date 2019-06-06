package com.c.myapplication.mvp.base;

import android.support.v7.app.AppCompatActivity;

public class BaseMvpActivity extends AppCompatActivity {

    @Override
    protected void onDestroy() {
        PresenterHelper.onDestroyed(this, BaseMvpActivity.class);
        super.onDestroy();
    }
}
