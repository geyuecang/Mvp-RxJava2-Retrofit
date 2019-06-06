package com.c.myapplication.mvp.base;

import java.lang.reflect.Field;

/**
 * author : geyuecang
 * date   : 2019/3/6 12:26
 * desc   : desc
 */
public class PresenterHelper {
    public static <T extends IView, P extends Presenter> P create(Class<P> klass, T view) {

        try {
            P presenter = klass.newInstance();
            presenter.onCreate(view);
            return presenter;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static <T> void onDestroyed(T object, Class<?> superClass) {
        for (Class<?> klass = object.getClass();
             !superClass.equals(klass);
             klass = klass.getSuperclass()) {
            Field[] fields = klass.getDeclaredFields();
            Presenter p;

            for (Field f : fields) {
                if (!Presenter.class.isAssignableFrom(f.getType())) {
                    continue;
                }
                f.setAccessible(true);
                try {
                    p = (Presenter) f.get(object);
                    p.onDestroy();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                f.setAccessible(false);
            }
        }
    }
}
