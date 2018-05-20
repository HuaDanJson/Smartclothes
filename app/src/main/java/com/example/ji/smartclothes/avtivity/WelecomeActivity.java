package com.example.ji.smartclothes.avtivity;

import android.os.Bundle;

import com.example.ji.smartclothes.R;
import com.example.ji.smartclothes.base.BaseActivity;
import com.example.ji.smartclothes.utils.SharePreferenceUtil;

import cn.bmob.v3.BmobUser;

public class WelecomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welecome);
        if (SharePreferenceUtil.getInstance().getBoolean("IsLogout", false)) {
            toActivity(LoginActivity.class);
            finish();
        } else {
            BmobUser bmobUser = BmobUser.getCurrentUser();
            if (bmobUser != null) {
                toActivity(MainActivity.class);
            } else {
                toActivity(LoginActivity.class);
            }
            finish();
        }

    }
}
