package com.c.myapplication.mvp.base;

/**
 * author : geyuecang
 * date   : 2019/3/8 10:22
 * desc   : desc
 */
public abstract class BaseMvpFragment extends BaseLazyFragment {


    @Override
    public void onDestroy() {
        PresenterHelper.onDestroyed(this, BaseMvpFragment.class);
        super.onDestroy();
    }
}
