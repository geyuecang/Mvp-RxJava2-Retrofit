package com.c.myapplication.mvp.auto;

import java.lang.reflect.Field;

/**
 * author : geyuecang
 * date   : 2019/3/26 17:18
 * desc   : desc
 */
public interface IProcessor {
    void process(Object obj, Field f);
}
