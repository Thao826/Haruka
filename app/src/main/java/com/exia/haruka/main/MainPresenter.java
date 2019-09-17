package com.exia.haruka.main;

import android.util.Log;

import com.exia.haruka.net.HarukaCallBack;
import com.exia.haruka.bean.WeatherBean;


public class MainPresenter implements IMainContract.P<WeatherBean> {

    private static final String TAG = "MainPresenter";

    private IMainContract.M modle = null;

    private IMainContract.V view = null;

    MainPresenter(IMainContract.V view) {
        modle = new MainMode(this);
        this.view = view;
    }

    @Override
    public void detachView() {

        modle = null;

        view = null;
    }

    @Override
    public void requestWeather(String code) {
        modle.requestWeather(code, new HarukaCallBack<WeatherBean>() {

            @Override
            public void onSuccess(WeatherBean bean) {
                view.lodaWeather(bean);
            }

            @Override
            public void onFailure(String error) {
                Log.d(TAG, "onFailure: " + error);
            }
        });
    }

}
