package com.example.ji.smartclothes.avtivity;

import android.os.Bundle;
import android.widget.Button;

import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.PermissionUtils;
import com.example.ji.smartclothes.R;
import com.example.ji.smartclothes.base.BaseActivity;
import com.example.ji.smartclothes.utils.SharePreferenceUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_check_weather_main_activity) Button btnCheckWeatherMainActivity;
    @BindView(R.id.btn_advice_main_activity) Button btnAdviceMainActivity;
    @BindView(R.id.btn_clothes_main_activity) Button btnClothesMainActivity;
    @BindView(R.id.btn_note_main_activity) Button btnNoteMainActivity;
    @BindView(R.id.btn_feedback_main_activity) Button btnFeedbackMainActivity;
    @BindView(R.id.btn_log_out_main_activity) Button btnLogOutMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getPermission();
    }

    public void getPermission() {
        PermissionUtils.permission(PermissionConstants.STORAGE, PermissionConstants.LOCATION, PermissionConstants.PHONE)
                .rationale(new PermissionUtils.OnRationaleListener() {
                    @Override
                    public void rationale(final ShouldRequest shouldRequest) {
                        shouldRequest.again(true);
                    }
                })
                .callback(new PermissionUtils.FullCallback() {
                    @Override
                    public void onGranted(List<String> permissionsGranted) {


                    }

                    @Override
                    public void onDenied(List<String> permissionsDeniedForever,
                                         List<String> permissionsDenied) {
                        if (!permissionsDeniedForever.isEmpty()) {
                            PermissionUtils.launchAppDetailsSettings();
                        }
                    }
                }).request();
    }

    @OnClick(R.id.btn_check_weather_main_activity)
    public void checkWeatherClick() {
        toActivity(WeatherActivity.class);
    }

    @OnClick(R.id.btn_advice_main_activity)
    public void advice() {
        toActivity(WeatherClothesActivity.class);
    }

    @OnClick(R.id.btn_clothes_main_activity)
    public void clothes() {
        toActivity(ClothesActivity.class);
    }

    @OnClick(R.id.btn_note_main_activity)
    public void note() {
        toActivity(NoteActivity.class);
    }

    @OnClick(R.id.btn_feedback_main_activity)
    public void feedBack() {
        toActivity(FeedBackActivity.class);
    }

    @OnClick(R.id.btn_log_out_main_activity)
    public void logout() {
        SharePreferenceUtil.getInstance().putBoolean("IsLogout", true);
        toActivity(LoginActivity.class);
        finish();
    }

}
