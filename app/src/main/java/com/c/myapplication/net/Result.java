package com.c.myapplication.net;

import java.io.Serializable;

/**
 * author : geyuecang
 * date   : 2019/6/6 9:35
 * desc   : desc
 */
public class Result<T,V> implements Serializable {
    private int status;
    private T data;
    private V message;
    private String errType;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public V getMessage() {
        return message;
    }

    public void setMessage(V message) {
        this.message = message;
    }

    public String getErrType() {
        return errType;
    }

    public void setErrType(String errType) {
        this.errType = errType;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", data=" + data +
                ", message=" + message +
                ", errType='" + errType + '\'' +
                '}';
    }
}
