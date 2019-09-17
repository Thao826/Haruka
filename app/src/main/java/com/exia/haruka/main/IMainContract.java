package com.exia.haruka.main;

import com.exia.haruka.net.HarukaCallBack;

public interface IMainContract {

    interface M<T>{
        void requestWeather(String code, HarukaCallBack<T> callBack);
    }

    interface V<T>{

        void attachPresenter();

        void lodaWeather(T bean);

    }

    interface P<T>{
        void detachView();

        void requestWeather(String code);

    }
}
