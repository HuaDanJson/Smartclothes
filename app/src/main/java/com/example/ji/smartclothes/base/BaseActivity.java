package com.example.ji.smartclothes.base;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    public final String TAG = getClassName();
    public Context mContext = this;
    private View loadingView;
    protected Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public Handler getHandler() {
        if (mHandler == null) {
            synchronized (this) {
                if (mHandler == null) {
                    mHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return mHandler;
    }

    public void showMessage(int text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


    public void doInUI(Runnable runnable) {
        doInUI(runnable, 0);
    }

    public void doInUI(Runnable runnable, long delayMillis) {
        getHandler().postDelayed(runnable, delayMillis);
    }

    public void toActivity(Class<? extends Activity> clazz) {
        startActivity(new Intent(this, clazz));
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        if (loadingView == null || loadingView.getParent() == null) {
            super.onBackPressed();
            return;
        }
        ArrayList<Integer> list = (ArrayList<Integer>) loadingView.getTag();
        list.clear();
        ((ViewGroup) loadingView.getParent()).removeView(loadingView);
    }

    public <V extends View> V findView(int id) {
        return (V) findViewById(id);
    }

    public String getClassName() {
        return getClass().getSimpleName();
    }

}
