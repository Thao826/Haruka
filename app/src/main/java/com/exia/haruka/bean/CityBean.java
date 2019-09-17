package com.exia.haruka.bean;

import com.google.gson.annotations.SerializedName;

import org.litepal.crud.LitePalSupport;
import org.litepal.exceptions.DataSupportException;

import java.io.Serializable;
import java.util.Objects;

public class CityBean extends LitePalSupport implements Serializable {



    @SerializedName("city_code")
    private String cityCode;

    @SerializedName("city_name")
    private String cityName;


    public CityBean(String cityCode, String cityName) {
        this.cityCode = cityCode;
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    /**
     *用于防止创建重复 CityBean
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        CityBean cityBean = (CityBean)obj;
        return Objects.equals(this.cityName,cityBean.cityName)
                && Objects.equals(this.cityCode,cityBean.cityCode);
    }
}
