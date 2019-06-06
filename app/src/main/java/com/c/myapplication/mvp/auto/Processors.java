package com.c.myapplication.mvp.auto;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * author : geyuecang
 * date   : 2019/3/26 17:42
 * desc   : desc
 */
public class Processors {
    private HashMap<Class<? extends Annotation>, Class<? extends IProcessor>> map = new HashMap<>();

    public Processors() {
        put(AutoWired.class, AutoWiredProcessor.class);
    }

    public void put(Class<AutoWired> k, Class<AutoWiredProcessor> v) {
        map.put(k, v);
    }

    public  <T extends IProcessor> T get(Class<? extends Annotation> k) {
        try {
            return (T) map.get(k).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void map(Mapper mapper) {
        for (Map.Entry<Class<? extends Annotation>, Class<? extends IProcessor>> entry
                : map.entrySet()) {
            mapper.on(entry.getKey(), entry.getValue());
        }
    }

    public interface Mapper {
        void on(Class<? extends Annotation> k, Class<? extends IProcessor> v);
    }
}
