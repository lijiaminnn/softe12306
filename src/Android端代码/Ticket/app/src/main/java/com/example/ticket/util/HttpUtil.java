package com.example.ticket.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by 张燕华 on 2018/12/25.
 */

public class HttpUtil {
    public static void getByOkHttp(final String address, final RequestBody requestBody,
                                   final okhttp3.Callback callback) {
        new Thread(new Runnable() {
            @Override
                public void run() {
                try {
                    /** 声明客户端*/
                    OkHttpClient client = new OkHttpClient();

                    /**声明请求*/
                    Request request = new Request.Builder()
                            .post(requestBody)
                            .url(address)
                            .build();
                    /** 客户端发起请求*/
                    client.newCall(request).enqueue(callback);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

}
