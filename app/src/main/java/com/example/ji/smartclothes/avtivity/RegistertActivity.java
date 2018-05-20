package com.example.ji.smartclothes.avtivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.example.ji.smartclothes.R;
import com.example.ji.smartclothes.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegistertActivity extends BaseActivity {

    @BindView(R.id.et_name_register_activity)
    EditText etNameRegisterActivity;
    @BindView(R.id.et_pwd_register_activity)
    EditText etPwdRegisterActivity;
    @BindView(R.id.btn_register_activity)
    Button btnRegisterActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiest);
        ButterKnife.bind(this);
        Bmob.initialize(this, "eb546e9aa3cfde289f1a664af32a6863");
    }

    @OnClick(R.id.btn_register_activity)
    public void register() {
        submit();
    }

    private void submit() {
        String accountString = etNameRegisterActivity.getText().toString().trim();
        String passwordString = etPwdRegisterActivity.getText().toString().trim();

        BmobUser userInfoBean = new BmobUser();
        if (TextUtils.isEmpty(accountString) || TextUtils.isEmpty(passwordString)) {
            Toast.makeText(RegistertActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            userInfoBean.setUsername(accountString);
            userInfoBean.setPassword(passwordString);
            userInfoBean.signUp(new SaveListener<BmobUser>() {
                @Override
                public void done(BmobUser s, BmobException e) {
                    if (e == null) {
                        Toast.makeText(RegistertActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        RegistertActivity.this.finish();
                    } else {
                        LogUtils.e("RegistertActivity login Failed "+e);
                        Toast.makeText(RegistertActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
