package com.example.ji.smartclothes.avtivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.example.ji.smartclothes.R;
import com.example.ji.smartclothes.base.BaseActivity;
import com.example.ji.smartclothes.utils.SharePreferenceUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_name_login_activity)
    EditText etNameLoginActivity;
    @BindView(R.id.et_pwd_login_activity)
    EditText etPwdLoginActivity;
    @BindView(R.id.btn_login_login_activity)
    Button btnLoginLoginActivity;
    @BindView(R.id.btn_register_login_activity)
    Button btnRegisterLoginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Bmob.initialize(this, "eb546e9aa3cfde289f1a664af32a6863");
    }

    @OnClick(R.id.btn_login_login_activity)
    public void login() {
        doLogin();
    }

    @OnClick(R.id.btn_register_login_activity)
    public void registerClick() {
        toActivity(RegistertActivity.class);
    }

    private void doLogin() {
        //获取用户输入的name
        String accountString = etNameLoginActivity.getText().toString().trim();
        String passwordString = etPwdLoginActivity.getText().toString().trim();

        //判断 name pwd isEmpty
        if (!TextUtils.isEmpty(accountString) && !TextUtils.isEmpty(passwordString)) {
            //New 一个User 并把Name 和PWD 赋值给这个用户
            BmobUser userInfoBean = new BmobUser();
            userInfoBean.setUsername(accountString);
            userInfoBean.setPassword(passwordString);
            //把该用户上传到服务器
            userInfoBean.login(new SaveListener<BmobUser>() {
                //服务器的CallBack BmobException 异常
                @Override
                public void done(BmobUser userInfoBean, BmobException e) {
                    if (e == null) {
                        BmobUser currentUser = BmobUser.getCurrentUser(BmobUser.class);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        SharePreferenceUtil.getInstance().putBoolean("IsLogout", false);
                        LoginActivity.this.finish();
                    } else {
                        LogUtils.e("LoginActivity login Failed " + e);
                        Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(LoginActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
        }
    }

}
