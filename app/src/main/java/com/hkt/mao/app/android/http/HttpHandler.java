package com.hkt.mao.app.android.http;


import com.alibaba.fastjson.JSONObject;

/**
 * Created by Administrator on 2018\2\28 0028.
 */

public interface HttpHandler {
    public abstract void requestSuccess(JSONObject json);
    public abstract void requestError(String error);
}
