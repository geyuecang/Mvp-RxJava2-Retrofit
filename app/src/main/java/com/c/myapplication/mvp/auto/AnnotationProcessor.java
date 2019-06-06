package com.c.myapplication.mvp.auto;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * author : geyuecang
 * date   : 2019/3/26 17:56
 * desc   : desc
 */
public class AnnotationProcessor {
    private static Processors processors = new Processors();

    public static void of(Object obj) {
        for (Class<?> klass = obj.getClass();
             !isClassSuperBase(klass);
             klass = klass.getSuperclass()) {
            Field[] fields = klass.getDeclaredFields();
            for (Field f : fields) {
                process(obj, f);
            }
        }
    }

    private static void process(final Object obj, final Field f) {
        processors.map(new Processors.Mapper() {
            @Override
            public void on(Class<? extends Annotation> k, Class<? extends IProcessor> v) {
                if (f.isAnnotationPresent(k)) {
                    IProcessor p = processors.get(k);
                    if (p != null) p.process(obj, f);
                }
            }
        });
    }

    private static boolean isClassSuperBase(Class<?> klass) {
        return AppCompatActivity.class.equals(klass)
                || Activity.class.equals(klass)
                || Object.class.equals(klass);
    }
}
