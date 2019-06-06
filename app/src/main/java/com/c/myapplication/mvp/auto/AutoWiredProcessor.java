package com.c.myapplication.mvp.auto;

import com.c.myapplication.mvp.base.IView;
import com.c.myapplication.mvp.base.Presenter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author : geyuecang
 * date   : 2019/3/26 17:20
 * desc   : desc
 */
public class AutoWiredProcessor implements IProcessor {
    @Override
    public void process(Object obj, Field f) {
        Class<?> type = (Class<?>) f.getGenericType();
        if (type.isPrimitive()) return; //判断是否是基本类型
        f.setAccessible(true);
        try {
            f.set(obj, type.newInstance());
            if (Presenter.class.isAssignableFrom(type)) {
                processPresenter(obj, f, type);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        f.setAccessible(false);

    }

    private void processPresenter(Object obj, Field f, Class<?> type) {
        try {
            Method onCreate = type.getMethod("onCreate", IView.class);
            onCreate.invoke(f.get(obj), obj);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
