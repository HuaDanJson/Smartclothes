package com.example.ji.smartclothes.avtivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ji.smartclothes.R;
import com.example.ji.smartclothes.base.BaseActivity;
import com.example.ji.smartclothes.bean.Weather;
import com.example.ji.smartclothes.utils.DBWeatherUtils;
import com.example.ji.smartclothes.utils.ResourceUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WeatherClothesActivity extends BaseActivity {

    @BindView(R.id.iv1_close_activity) ImageView mImageView1;
    @BindView(R.id.iv2_close_activity) ImageView mImageView2;
    @BindView(R.id.iv3_close_activity) ImageView mImageView3;
    @BindView(R.id.iv_back_close_activity) ImageView ivBackCloseActivity;
    @BindView(R.id.tv_temper_close_activity) TextView tvTemperCloseActivity;

    //零下-10以下
    private int close1[] = {R.drawable.icon_011, R.drawable.icon_012};

    //0 ~ -10
    private int close2[] = {R.drawable.icon_05};

    //0 ~ 5
    private int close3[] = {R.drawable.icon_5};

    //5 ~ 10
    private int close4[] = {R.drawable.icon_6, R.drawable.icon_8};

    //10~15
    private int close5[] = {R.drawable.icon_11, R.drawable.icon_12, R.drawable.icon_13};

    //15~20
    private int close6[] = {R.drawable.icon_16};

    //20~25
    private int close7[] = {R.drawable.icon_21};

    //25~30
    private int close8[] = {R.drawable.icon_26, R.drawable.icon_28};

    //30以上
    private int close9[] = {R.drawable.icon_31, R.drawable.icon_32};

    private int temperature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_clothes);
        ButterKnife.bind(this);
        Weather weather = DBWeatherUtils.getInstance().queryOneData(1);
        if (weather != null) {
            temperature = weather.getTemperature();
            tvTemperCloseActivity.setText(temperature + "℃");
            if (temperature < -10) {
                Log.i("aaa", " ~~~~~~~~  -10");
                mImageView1.setVisibility(View.VISIBLE);
                mImageView2.setVisibility(View.VISIBLE);
                mImageView3.setVisibility(View.GONE);
                mImageView1.setImageDrawable(ResourceUtil.getDrawable(close1[0]));
                mImageView2.setImageDrawable(ResourceUtil.getDrawable(close1[1]));
            } else if (temperature >= -10 && temperature < 0) {
                Log.i("aaa", "-10~~~0");
                mImageView1.setVisibility(View.VISIBLE);
                mImageView2.setVisibility(View.GONE);
                mImageView3.setVisibility(View.GONE);
                mImageView1.setImageDrawable(ResourceUtil.getDrawable(close2[0]));
            } else if (temperature >= 0 && temperature < 5) {
                Log.i("aaa", "0~~~5");
                mImageView1.setVisibility(View.VISIBLE);
                mImageView2.setVisibility(View.GONE);
                mImageView3.setVisibility(View.GONE);
                mImageView1.setImageDrawable(ResourceUtil.getDrawable(close3[0]));
            } else if (temperature >= 5 && temperature < 10) {
                Log.i("aaa", "5~~~10");
                mImageView1.setVisibility(View.VISIBLE);
                mImageView2.setVisibility(View.VISIBLE);
                mImageView3.setVisibility(View.GONE);
                mImageView1.setImageDrawable(ResourceUtil.getDrawable(close4[0]));
                mImageView2.setImageDrawable(ResourceUtil.getDrawable(close4[1]));
            } else if (temperature >= 10 && temperature < 15) {
                Log.i("aaa", "10~~~15");
                mImageView1.setVisibility(View.VISIBLE);
                mImageView2.setVisibility(View.VISIBLE);
                mImageView3.setVisibility(View.VISIBLE);
                mImageView1.setImageDrawable(ResourceUtil.getDrawable(close5[0]));
                mImageView2.setImageDrawable(ResourceUtil.getDrawable(close5[1]));
                mImageView3.setImageDrawable(ResourceUtil.getDrawable(close5[2]));
            } else if (temperature >= 15 && temperature < 20) {
                Log.i("aaa", "15~~~20");
                mImageView1.setVisibility(View.VISIBLE);
                mImageView2.setVisibility(View.GONE);
                mImageView3.setVisibility(View.GONE);
                mImageView1.setImageDrawable(ResourceUtil.getDrawable(close6[0]));
            } else if (temperature >= 20 && temperature < 25) {
                Log.i("aaa", "20~~~25");
                mImageView1.setVisibility(View.VISIBLE);
                mImageView2.setVisibility(View.GONE);
                mImageView3.setVisibility(View.GONE);
                mImageView1.setImageDrawable(ResourceUtil.getDrawable(close7[0]));
            } else if (temperature >= 25 && temperature < 30) {
                Log.i("aaa", "25~~~30");
                mImageView1.setVisibility(View.VISIBLE);
                mImageView2.setVisibility(View.VISIBLE);
                mImageView3.setVisibility(View.GONE);
                mImageView1.setImageDrawable(ResourceUtil.getDrawable(close8[0]));
                mImageView2.setImageDrawable(ResourceUtil.getDrawable(close8[1]));
            }
        } else if (temperature >= 30) {
            mImageView1.setVisibility(View.VISIBLE);
            mImageView2.setVisibility(View.VISIBLE);
            mImageView3.setVisibility(View.GONE);
            mImageView1.setImageDrawable(ResourceUtil.getDrawable(close9[0]));
            mImageView2.setImageDrawable(ResourceUtil.getDrawable(close9[1]));
        }
    }

    @OnClick(R.id.iv_back_close_activity)
    public void backClick() {
        finish();
    }
}
