package com.exia.haruka;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Binder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.exia.base.base.ActivityCollector;

import java.lang.ref.WeakReference;

public class BaseActivity extends AppCompatActivity {

    /**
     * 是否在前台
     */
    protected boolean isActive = false;

    /**
     * 当前 Activity 的实例
     */
    protected Activity activity = null;

    protected ProgressBar loading = null;

    private View loadErrorView = null;

    private View badNetworkView = null;

    private View noContentView = null;

    private View loadingView = null;

    private WeakReference<Activity> weakReference = null;


    private ActivityCollector activityCollector;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        weakReference = new WeakReference(this);
        activityCollector = ActivityCollector.getInstance();
        activityCollector.add(weakReference);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setupViews();
    }

    protected void setupViews() {
        tranSparentStatusBar();
    }

    /**
     * SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN 全屏 状态栏也会隐藏
     */
    protected void tranSparentStatusBar(){
            View decorview = getWindow().getDecorView();
            decorview.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            decorview.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
    }


    /**
     * 打开软键盘
     * @param editText
     */
    protected void showSoftKeyBoard(EditText editText){
        if(editText != null){
            editText.requestFocus();
            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.showSoftInput(editText,0);
        }
    }

    /**
     * 隐藏软键盘
     */
    protected void hideSoftKeyBoard(){
        View view = getCurrentFocus();
        if(view != null){
            Binder binder = (Binder) view.getWindowToken();
            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(binder,InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

//    protected void showLoadErrorView(String tip){
//        if(loadErrorView != null){
//            loadErrorView.setVisibility(View.VISIBLE);
//            return;
//        }
//        ViewStub viewStub = findViewById(R.id.loaderrorview);
//        if(viewStub != null){
//            loadErrorView = viewStub.inflate();
//            TextView textView = loadErrorView.findViewById(R.id.error_text);
//            textView.setText(tip);
//        }
//    }
//
//    protected void showNoContentView(String tip){
//        if(noContentView != null){
//            noContentView.setVisibility(View.VISIBLE);
//        }
//        ViewStub viewStub = findViewById(R.id.nocontentview);
//        if(viewStub != null){
//            noContentView = viewStub.inflate();
//            TextView view = noContentView.findViewById(R.id.no_content_text);
//            view.setText(tip);
//        }
//    }
//
//    protected void showBadNetWorkView(String tip){
//        if(badNetworkView != null){
//            noContentView.setVisibility(View.VISIBLE);
//        }
//        ViewStub viewStub = findViewById(R.id.badnetworkview);
//        if(viewStub != null){
//            badNetworkView = viewStub.inflate();
//            TextView view = badNetworkView.findViewById(R.id.bad_network_text);
//            view.setText(tip);
//        }
//    }
//
//    protected void showLoadingView(){
//        if(loadingView != null){
//            loadingView.setVisibility(View.VISIBLE);
//        }
//        ViewStub viewStub = findViewById(R.id.loadingview);
//        if(viewStub != null){
//            loadingView = viewStub.inflate();
//        }
//    }
//
//    protected void hideLoadErrorView(){
//        if(loadErrorView != null){
//            loadErrorView.setVisibility(View.INVISIBLE);
//        }
//    }
//
//    protected void hideNoContentView(){
//        if(noContentView != null){
//            noContentView.setVisibility(View.INVISIBLE);
//        }
//    }
//
//    protected void hideBadNetWorkView(){
//        if(badNetworkView != null){
//            badNetworkView.setVisibility(View.INVISIBLE);
//        }
//    }
//
//    protected void hideLoadingView(){
//        if(loadingView != null){
//            loadingView.setVisibility(View.INVISIBLE);
//        }
//    }

}
