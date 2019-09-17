package com.exia.haruka.main;

import com.exia.haruka.net.Haruka;
import com.exia.haruka.net.HarukaCallBack;
import com.exia.haruka.bean.WeatherBean;
;

public class MainMode implements IMainContract.M<WeatherBean> {


    private IMainContract.P<WeatherBean> presenter;

    private Haruka haruka;


    MainMode(IMainContract.P<WeatherBean> presenter) {
        this.presenter = presenter;
        haruka = Haruka.getInstance();
    }

    @Override
    public void requestWeather(String code, HarukaCallBack<WeatherBean> callBack) {
        haruka.getWeather(code,callBack);
    }
}
