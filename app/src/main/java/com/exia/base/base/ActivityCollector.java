package com.exia.base.base;

import android.app.Activity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ActivityCollector {

    private ArrayList<WeakReference<Activity>> activityList;


    /**
     * 使用静态内部类来实现 SingleIntance
     * 用 Jvm 本身的机制保证了线程的安全问题
     * 同时读取实例的时候也不会进行同步，没有性能缺陷，还不依赖JDK
     */

    private ActivityCollector() {
        activityList = new ArrayList<>();
    }

    private static class Holder{
        private static ActivityCollector INSTANCE = new ActivityCollector();
    }

    public static ActivityCollector getInstance(){
        return Holder.INSTANCE;
    }


    public void add(WeakReference<Activity> weakReference){
        activityList.add(weakReference);
    }

    public boolean remove(WeakReference<Activity> weakReference){
        return activityList.remove(weakReference);
    }

    public void finishAll(){
        if(!activityList.isEmpty()){
            for(WeakReference<Activity> weakReference : activityList){
                Activity activity = weakReference.get();
                if(activity != null && !activity.isFinishing()){
                    activity.finish();
                }
            }
        }
    }
}
