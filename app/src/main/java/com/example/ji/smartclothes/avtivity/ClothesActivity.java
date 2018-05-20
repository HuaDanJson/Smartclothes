package com.example.ji.smartclothes.avtivity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ji.smartclothes.R;
import com.example.ji.smartclothes.adapter.ClothesAdapter;
import com.example.ji.smartclothes.base.BaseActivity;
import com.example.ji.smartclothes.bean.ClothesPicture;
import com.example.ji.smartclothes.utils.DBClothesPictureUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class ClothesActivity extends BaseActivity {

    @BindView(R.id.rv_clothes_activity) RecyclerView mRecyclerView;

    private List<ClothesPicture> clothesPictureList = new ArrayList<>();

    private ClothesAdapter clothesAdapter;

    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        ButterKnife.bind(this);
        //1.获取数据源
        getMediaData();
    }

    public void getMediaData() {
        BmobQuery<ClothesPicture> query = new BmobQuery<ClothesPicture>();
        // 按时间降序查询
        query.order("-createdAt");
        query.setLimit(20);
        //从服务器获取衣服图片 集合 Arraylist
        query.findObjects(new FindListener<ClothesPicture>() {
            @Override
            public void done(List<ClothesPicture> list, BmobException e) {
                if (e == null) {
                    clothesPictureList = list;
                    if (mRecyclerView != null) {
                        gridLayoutManager = new GridLayoutManager(ClothesActivity.this, 2);
                        mRecyclerView.setLayoutManager(gridLayoutManager);
                        clothesAdapter = new ClothesAdapter(clothesPictureList, ClothesActivity.this);
                        mRecyclerView.setAdapter(clothesAdapter);
                        DBClothesPictureUtils.getInstance().deleteAllData();
                        DBClothesPictureUtils.getInstance().insertManyData(clothesPictureList);
                    }
                }

            }
        });
    }
}
