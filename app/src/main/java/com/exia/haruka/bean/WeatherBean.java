package com.exia.haruka.bean;

import java.io.Serializable;
import java.util.List;

public class WeatherBean  {

    /**
     * message : success感谢又拍云(upyun.com)提供CDN赞助
     * status : 200
     * date : 20190821
     * time : 2019-08-21 10:17:01
     * cityInfo : {"city":"天津市","citykey":"101030100","parent":"天津","updateTime":"09:32"}
     * data : {"shidu":"64%","pm25":53,"pm10":52,"quality":"良","wendu":"25","ganmao":"极少数敏感人群应减少户外活动","forecast":[{"date":"21","high":"高温 31℃","low":"低温 22℃","ymd":"2019-08-21","week":"星期三","sunrise":"05:28","sunset":"19:00","aqi":70,"fx":"北风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"22","high":"高温 32℃","low":"低温 22℃","ymd":"2019-08-22","week":"星期四","sunrise":"05:29","sunset":"18:59","aqi":143,"fx":"北风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"23","high":"高温 31℃","low":"低温 20℃","ymd":"2019-08-23","week":"星期五","sunrise":"05:30","sunset":"18:57","aqi":119,"fx":"东风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"24","high":"高温 29℃","low":"低温 21℃","ymd":"2019-08-24","week":"星期六","sunrise":"05:31","sunset":"18:56","aqi":118,"fx":"东南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"25","high":"高温 29℃","low":"低温 22℃","ymd":"2019-08-25","week":"星期日","sunrise":"05:32","sunset":"18:54","aqi":125,"fx":"东南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"26","high":"高温 30℃","low":"低温 21℃","ymd":"2019-08-26","week":"星期一","sunrise":"05:32","sunset":"18:53","aqi":141,"fx":"西南风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"27","high":"高温 30℃","low":"低温 21℃","ymd":"2019-08-27","week":"星期二","sunrise":"05:33","sunset":"18:51","fx":"东南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"28","high":"高温 32℃","low":"低温 20℃","ymd":"2019-08-28","week":"星期三","sunrise":"05:34","sunset":"18:50","fx":"西南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"29","high":"高温 31℃","low":"低温 19℃","ymd":"2019-08-29","week":"星期四","sunrise":"05:35","sunset":"18:49","fx":"南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"30","high":"高温 32℃","low":"低温 21℃","ymd":"2019-08-30","week":"星期五","sunrise":"05:36","sunset":"18:47","fx":"西南风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"31","high":"高温 32℃","low":"低温 21℃","ymd":"2019-08-31","week":"星期六","sunrise":"05:37","sunset":"18:46","fx":"东南风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"01","high":"高温 32℃","low":"低温 20℃","ymd":"2019-09-01","week":"星期日","sunrise":"05:38","sunset":"18:44","fx":"东南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"02","high":"高温 31℃","low":"低温 20℃","ymd":"2019-09-02","week":"星期一","sunrise":"05:39","sunset":"18:42","fx":"南风","fl":"3-4级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"03","high":"高温 31℃","low":"低温 20℃","ymd":"2019-09-03","week":"星期二","sunrise":"05:40","sunset":"18:41","fx":"东南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"04","high":"高温 30℃","low":"低温 19℃","ymd":"2019-09-04","week":"星期三","sunrise":"05:41","sunset":"18:39","fx":"东南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"}],"yesterday":{"date":"20","high":"高温 27℃","low":"低温 20℃","ymd":"2019-08-20","week":"星期二","sunrise":"05:27","sunset":"19:01","aqi":57,"fx":"西南风","fl":"3-4级","type":"小雨","notice":"雨虽小，注意保暖别感冒"}}
     */

    private String message;
    private int status;
    private String date;
    private String time;
    private CityInfoBean cityInfo;
    private DataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CityInfoBean getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfoBean cityInfo) {
        this.cityInfo = cityInfo;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class CityInfoBean {
        /**
         * city : 天津市
         * citykey : 101030100
         * parent : 天津
         * updateTime : 09:32
         */

        private String city;
        private String citykey;
        private String parent;
        private String updateTime;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCitykey() {
            return citykey;
        }

        public void setCitykey(String citykey) {
            this.citykey = citykey;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }

    public static class DataBean {
        /**
         * shidu : 64%
         * pm25 : 53.0
         * pm10 : 52.0
         * quality : 良
         * wendu : 25
         * ganmao : 极少数敏感人群应减少户外活动
         * forecast : [{"date":"21","high":"高温 31℃","low":"低温 22℃","ymd":"2019-08-21","week":"星期三","sunrise":"05:28","sunset":"19:00","aqi":70,"fx":"北风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"22","high":"高温 32℃","low":"低温 22℃","ymd":"2019-08-22","week":"星期四","sunrise":"05:29","sunset":"18:59","aqi":143,"fx":"北风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"23","high":"高温 31℃","low":"低温 20℃","ymd":"2019-08-23","week":"星期五","sunrise":"05:30","sunset":"18:57","aqi":119,"fx":"东风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"24","high":"高温 29℃","low":"低温 21℃","ymd":"2019-08-24","week":"星期六","sunrise":"05:31","sunset":"18:56","aqi":118,"fx":"东南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"25","high":"高温 29℃","low":"低温 22℃","ymd":"2019-08-25","week":"星期日","sunrise":"05:32","sunset":"18:54","aqi":125,"fx":"东南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"26","high":"高温 30℃","low":"低温 21℃","ymd":"2019-08-26","week":"星期一","sunrise":"05:32","sunset":"18:53","aqi":141,"fx":"西南风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"27","high":"高温 30℃","low":"低温 21℃","ymd":"2019-08-27","week":"星期二","sunrise":"05:33","sunset":"18:51","fx":"东南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"28","high":"高温 32℃","low":"低温 20℃","ymd":"2019-08-28","week":"星期三","sunrise":"05:34","sunset":"18:50","fx":"西南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"29","high":"高温 31℃","low":"低温 19℃","ymd":"2019-08-29","week":"星期四","sunrise":"05:35","sunset":"18:49","fx":"南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"30","high":"高温 32℃","low":"低温 21℃","ymd":"2019-08-30","week":"星期五","sunrise":"05:36","sunset":"18:47","fx":"西南风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"31","high":"高温 32℃","low":"低温 21℃","ymd":"2019-08-31","week":"星期六","sunrise":"05:37","sunset":"18:46","fx":"东南风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"01","high":"高温 32℃","low":"低温 20℃","ymd":"2019-09-01","week":"星期日","sunrise":"05:38","sunset":"18:44","fx":"东南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"02","high":"高温 31℃","low":"低温 20℃","ymd":"2019-09-02","week":"星期一","sunrise":"05:39","sunset":"18:42","fx":"南风","fl":"3-4级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"03","high":"高温 31℃","low":"低温 20℃","ymd":"2019-09-03","week":"星期二","sunrise":"05:40","sunset":"18:41","fx":"东南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"04","high":"高温 30℃","low":"低温 19℃","ymd":"2019-09-04","week":"星期三","sunrise":"05:41","sunset":"18:39","fx":"东南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"}]
         * yesterday : {"date":"20","high":"高温 27℃","low":"低温 20℃","ymd":"2019-08-20","week":"星期二","sunrise":"05:27","sunset":"19:01","aqi":57,"fx":"西南风","fl":"3-4级","type":"小雨","notice":"雨虽小，注意保暖别感冒"}
         */

        private String shidu;
        private double pm25;
        private double pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        private YesterdayBean yesterday;
        private List<ForecastBean> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public double getPm25() {
            return pm25;
        }

        public void setPm25(double pm25) {
            this.pm25 = pm25;
        }

        public double getPm10() {
            return pm10;
        }

        public void setPm10(double pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * date : 20
             * high : 高温 27℃
             * low : 低温 20℃
             * ymd : 2019-08-20
             * week : 星期二
             * sunrise : 05:27
             * sunset : 19:01
             * aqi : 57
             * fx : 西南风
             * fl : 3-4级
             * type : 小雨
             * notice : 雨虽小，注意保暖别感冒
             */

            private String date;
            private String high;
            private String low;
            private String ymd;
            private String week;
            private String sunrise;
            private String sunset;
            private int aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getYmd() {
                return ymd;
            }

            public void setYmd(String ymd) {
                this.ymd = ymd;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }

        public static class ForecastBean {
            /**
             * date : 21
             * high : 高温 31℃
             * low : 低温 22℃
             * ymd : 2019-08-21
             * week : 星期三
             * sunrise : 05:28
             * sunset : 19:00
             * aqi : 70
             * fx : 北风
             * fl : 3-4级
             * type : 晴
             * notice : 愿你拥有比阳光明媚的心情
             */

            private String date;
            private String high;
            private String low;
            private String ymd;
            private String week;
            private String sunrise;
            private String sunset;
            private int aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getYmd() {
                return ymd;
            }

            public void setYmd(String ymd) {
                this.ymd = ymd;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }
}
