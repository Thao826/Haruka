package com.exia.base.callback;


public interface HttpCallback<T> {

    void onSuccess(T t);

    void onFailure(Throwable e);
}
