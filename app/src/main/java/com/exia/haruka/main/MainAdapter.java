package com.exia.haruka.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exia.haruka.R;
import com.exia.haruka.bean.WeatherBean;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainAdapter extends RecyclerView.Adapter {

    private static final int HEAD_ITEM =  10010;
    private static final int WEATHER_ITEM = 10011;


    Context context;

    WeatherBean weatherBean;

    public MainAdapter(Context context, WeatherBean weatherBean) {
        this.context = context;
        this.weatherBean = weatherBean;
    }

    public class HeadHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.head_item_temperature)
        TextView headTemperatureView;

        @BindView(R.id.head_item_max)
        TextView headMaxMinView;

        @BindView(R.id.head_item_weather)
        TextView headWeatherView;

        @BindView(R.id.head_item_city)
        TextView headCityView;

        public HeadHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


    public class WeatherHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.weather_item_date)
        TextView weatherDateView;

        @BindView(R.id.weather_item_logo)
        TextView weatherLogoView;

        @BindView(R.id.weather_item_temperature)
        TextView weatherTemperatureView;

        public WeatherHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;
        LayoutInflater inflater = LayoutInflater.from(context);
        switch (i){
            case HEAD_ITEM:
                view = inflater.inflate(R.layout.head_item,viewGroup,false);
                setItemHeight(view,HEAD_ITEM);
                return new HeadHolder(view);
            case WEATHER_ITEM:
                view = inflater.inflate(R.layout.weather_item,viewGroup,false);
                setItemHeight(view,WEATHER_ITEM);
                return new WeatherHolder(view);
        }

        return null;

    }

    /**
     * 动态设置 Item 的高度
     * @param view
     * @param type
     */
    private void setItemHeight(View view,int type) {

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int heightPixels = metrics.heightPixels;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        switch (type){

            case HEAD_ITEM:
                layoutParams.height = heightPixels/2 - getActionBarHeight(context);
                break;

            case WEATHER_ITEM:
                layoutParams.height = heightPixels /2 /7;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        WeatherBean.CityInfoBean cityInfoBean = weatherBean.getCityInfo();
        WeatherBean.DataBean dataBean = weatherBean.getData();

        int type = getItemViewType(i);
        switch (type){

            case HEAD_ITEM:
                HeadHolder headHolder = (HeadHolder)viewHolder;
                headHolder.headTemperatureView.setText(dataBean.getWendu());
                headHolder.headMaxMinView.setText("pm2.5:" + dataBean.getPm25() + "/pm10:" + dataBean.getPm10());
                headHolder.headWeatherView.setText(dataBean.getQuality());
                headHolder.headCityView.setText(cityInfoBean.getCity());
                break;

            case WEATHER_ITEM:
                WeatherBean.DataBean.ForecastBean forecastBean = dataBean.getForecast().get(i-1);
                WeatherHolder holder = (WeatherHolder)viewHolder;
                holder.weatherDateView.setText(forecastBean.getYmd());
                holder.weatherLogoView.setText(forecastBean.getType());
                holder.weatherTemperatureView.setText(forecastBean.getHigh());
        }


    }


    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return HEAD_ITEM;
        }else {
            return WEATHER_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return weatherBean.getData().getForecast().size() + 1;
    }


    /**
     * 获取ActionBar 高度
     * @param context
     * @return
     */
    public static int getActionBarHeight(Context context){
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize,tv,true)){
            return  TypedValue.complexToDimensionPixelSize(tv.data,
                    context.getResources().getDisplayMetrics());
        }
        return 0;
    }
}
