package com.exia.haruka.net;

public interface HarukaCallBack<T> {

    void onSuccess(T t);

    void onFailure(String error);

}
