package com.example.ji.smartclothes.avtivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ji.smartclothes.R;
import com.example.ji.smartclothes.base.BaseActivity;
import com.example.ji.smartclothes.bean.FeedBackBean;
import com.example.ji.smartclothes.utils.ToastHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class FeedBackActivity extends BaseActivity {

    @BindView(R.id.edt_feed_back) EditText edtFeedBack;
    @BindView(R.id.textView) TextView textView;
    @BindView(R.id.ll_feed_back_activity) LinearLayout llFeedBackActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ll_feed_back_activity)
    public void feedBackClick() {
        FeedBackBean feedBackBean = new FeedBackBean();
        feedBackBean.setFeedbackContent(edtFeedBack.getText().toString());
        feedBackBean.setCreatTimeAsId(System.currentTimeMillis());
        BmobUser bmobUser = BmobUser.getCurrentUser();
        if (bmobUser != null) {
            feedBackBean.setUserName(bmobUser.getUsername());
        }
        feedBackBean.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    ToastHelper.showShortMessage("非常感谢收到您的反馈，我们定会第一时间处理");
                    finish();
                } else {
                    ToastHelper.showShortMessage("反馈失败");
                }
            }
        });
    }
}
