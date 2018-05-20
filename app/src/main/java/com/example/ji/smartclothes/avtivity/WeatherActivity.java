package com.example.ji.smartclothes.avtivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ji.smartclothes.R;
import com.example.ji.smartclothes.base.BaseActivity;
import com.example.ji.smartclothes.bean.Weather;
import com.example.ji.smartclothes.utils.DBWeatherUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class WeatherActivity extends BaseActivity {

    @BindView(R.id.tv_weather_weather_activity) TextView mWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);
        getMediaData();
    }

    public void getMediaData() {
        BmobQuery<Weather> query = new BmobQuery<Weather>();
        // 按时间降序查询
        query.order("-createdAt");
        query.setLimit(10);

        //从服务器获取天气数据 集合 Arraylist
        query.findObjects(new FindListener<Weather>() {
            @Override
            public void done(List<Weather> list, BmobException e) {
                if (e == null) {
                    if (list != null && list.size() > 0) {
                        Weather weather = list.get(0);
                        if (weather != null) {
                            //清除数据库
                            DBWeatherUtils.getInstance().deleteAllData();
                            mWeather.setText("当前天气：" + weather.getCloud() + "\n" +
                                    "当前气温：" + weather.getTemperature() + "℃\n" +
                                    "当前城市：" + weather.getCity() + "\n" +
                                    "友情提示：" + weather.getRemind());
                            weather.setGetDateTiem(1);
                            DBWeatherUtils.getInstance().insertOneData(weather);
                        }


                    }
                }
            }
        });
    }
}
