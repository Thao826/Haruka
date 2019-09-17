package com.exia.haruka.main;

import android.os.Bundle;
import android.widget.TextView;

import com.exia.haruka.BaseActivity;
import com.exia.haruka.R;
import com.exia.haruka.bean.WeatherBean;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IMainContract.V<WeatherBean> {

    private IMainContract.P<WeatherBean> presenter = null;

    @BindView(R.id.tv_show)
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        attachPresenter();
        presenter.requestWeather("101030100");

    }

    @Override
    protected void setupViews() {
        super.setupViews();
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void attachPresenter() {
        if(presenter == null){
            presenter = new MainPresenter(this);
        }
    }

    @Override
    public void lodaWeather(WeatherBean bean) {
        textView.setText(bean.getMessage());
    }

}
