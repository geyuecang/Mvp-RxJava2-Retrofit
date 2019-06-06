package com.c.myapplication.mvp.base;

/**
 * author : geyuecang
 * date   : 2019/3/5 15:26
 * desc   : desc
 */
public class Presenter<T extends IView> {

    /**
     * 保存view
     */
    private T mView;

    /**
     * 当view创建时调用
     *
     * @param view
     */
    public void onCreate(T view) {
        this.mView = view;
    }

    /**
     * 当view销毁时调用
     */
    public void onDestroy() {
        mView = null;
    }

    /**
     * 获取当前 view
     *
     * @return
     */
    protected T getView() {
        if (hasView()) {
            return mView;
        }
        return null;
    }

    /**
     * 判断当前view是否为空
     *
     * @return
     */
    protected boolean hasView() {
        return mView != null;
    }

}
