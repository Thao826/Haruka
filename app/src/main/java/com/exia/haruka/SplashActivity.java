package com.exia.haruka;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.exia.haruka.bean.CityBean;
import com.exia.haruka.main.MainActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.litepal.LitePal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class SplashActivity extends BaseActivity {

    private static final String ISINITDATA = "isinitDatabas";

    private static final Long DELAY_COUNT = 3000L;

    private boolean isforwarding = false;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedPreferences = getSharedPreferences("config",Context.MODE_PRIVATE);
        Boolean isinitdata = sharedPreferences.getBoolean(ISINITDATA,false);
        if(!isinitdata){
            initDatabase();
        }
        delayToNextActivity();
    }

    /**
     * 延迟执行
     * Runnable 执行的线程是在 Handler 所在的线程
     */
    private void delayToNextActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                forwardToNextActivity();
            }
        },DELAY_COUNT);
    }

    private void initDatabase() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                LitePal.getDatabase();
                String json = getJson(SplashActivity.this,"city.json");
                Gson gson = new Gson();
                List<CityBean> list = gson.fromJson(json,new TypeToken<List<CityBean>>(){}.getType());
                for (CityBean bean : list) {
                    bean.save();
                }
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(ISINITDATA,true);
                editor.apply();
                forwardToNextActivity();
            }
        }).start();
    }

    /**
     * 跳转至下一个 Activity
     */
    private void forwardToNextActivity(){
        if(!isforwarding){
            isforwarding = true;
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
            finish();
            overridePendingTransition(R.anim.app_scale_in_delay,R.anim.app_scale_out_delay);
        }
    }


    /**
     * 获取本地 json 文件
     * @param fileName 文件名
     * @param context
     * @return
     */
    public static String getJson(Context context,String fileName) {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = context.getAssets();
            //通过管理器打开文件并读取
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
