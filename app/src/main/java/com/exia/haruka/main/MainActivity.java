package com.exia.haruka.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.exia.haruka.BaseActivity;
import com.exia.haruka.R;
import com.exia.haruka.bean.WeatherBean;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IMainContract.V<WeatherBean> {

    private IMainContract.P<WeatherBean> presenter = null;


    @BindView(R.id.toolbar_main)
    Toolbar toolbar;

    @BindView(R.id.rv_main)
    RecyclerView main_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setLightStatusBar();
        attachPresenter();
        requestDefaultWeather();

    }

    /**
     * 请求默认天气
     */
    private void requestDefaultWeather() {
        showLoadingView();
        presenter.requestWeather("101030100");
    }


    @Override
    protected void setupViews() {
        super.setupViews();
        ButterKnife.bind(this);
        main_rv.setLayoutManager(new LinearLayoutManager(this));

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }


    /**
     * 设置状态栏高光
     */
    private void setLightStatusBar() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    @Override
    public void attachPresenter() {
        if(presenter == null){
            presenter = new MainPresenter(this);
        }
    }

    @Override
    public void lodaWeather(WeatherBean bean) {
        main_rv.setAdapter(new MainAdapter(this,bean));
        hideLoadingView();
    }

}
