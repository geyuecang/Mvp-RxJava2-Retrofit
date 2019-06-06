package com.c.myapplication.net;

import java.io.IOException;

/**
 * author : geyuecang
 * date   : 2019/6/5 17:26
 * desc   : desc
 */
public class NetworkNotConnectedException extends IOException {
    public NetworkNotConnectedException() {
        super("网络未连接，请检查网络");
    }
}
