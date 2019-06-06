package com.c.myapplication.demo;

import com.c.myapplication.net.Result;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * author : geyuecang
 * date   : 2019/6/6 9:53
 * desc   : desc
 */
public interface BookApi {

    String BOOKLIST = "BOOKLIST";
    String HOST = "https://" + "neibuapp.kongfz.com" + "/";

    @FormUrlEncoded
    @POST("/invokeOperation/app/api/getBookList")
    Observable<Result<BookListBean, String>> getBookList(@Field("currPage") int page);
}
