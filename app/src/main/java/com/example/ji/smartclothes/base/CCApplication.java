package com.example.ji.smartclothes.base;

import android.support.multidex.MultiDexApplication;

import com.blankj.utilcode.util.Utils;
import com.example.ji.smartclothes.utils.DBClothesPictureUtils;
import com.example.ji.smartclothes.utils.DBWeatherUtils;
import com.example.ji.smartclothes.utils.SharePreferenceUtil;
import com.example.ji.smartclothes.utils.ToastHelper;

import cn.bmob.v3.Bmob;
import interfaces.heweather.com.interfacesmodule.view.HeConfig;

public class CCApplication extends MultiDexApplication {

    public static CCApplication instance;

    public static CCApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.init(getApplicationContext());
        Utils.init(this);
        Bmob.initialize(this, "eb546e9aa3cfde289f1a664af32a6863");
        HeConfig.init("HE1805182157491763", "bbc081f799e44f158fef95e90a511f85");
        HeConfig.switchToFreeServerNode();
        //初始化ToastHelper
        ToastHelper.init(getApplicationContext());

        //初始化SharePreferenceUtil
        SharePreferenceUtil.initInstance(getApplicationContext());

        //初始化数据库中EWeather 这张表
        DBWeatherUtils.Init(getApplicationContext());

        DBClothesPictureUtils.Init(getApplicationContext());
    }
}
