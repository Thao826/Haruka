package com.exia.haruka.net;

import android.annotation.SuppressLint;

import com.exia.base.http.HttpUtil;
import com.exia.haruka.bean.WeatherBean;
import com.exia.haruka.main.HarukaServer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;

/**
 * 网络请求库
 */
public class Haruka {

    private static final String BASE_URL = "http://t.weather.sojson.com/";

    private HarukaServer mHarukaServer;

    private Haruka() {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        mHarukaServer = HttpUtil.createService(BASE_URL, client,HarukaServer.class);

    }

    @SuppressLint("CheckResult")
    public void getWeather(String code, final HarukaCallBack<WeatherBean> callBack){
        mHarukaServer.getWeatherData(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherBean>() {
                    @Override
                    public void accept(WeatherBean bean) throws Exception {
                        callBack.onSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callBack.onFailure(throwable.getMessage());
                    }
                });

    }

    public static Haruka getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final Haruka INSTANCE = new Haruka();
    }
}
