package com.example.ji.smartclothes.avtivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.ji.smartclothes.R;
import com.example.ji.smartclothes.base.BaseActivity;
import com.example.ji.smartclothes.bean.ClothesPicture;
import com.example.ji.smartclothes.utils.DBClothesPictureUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppearClothesActivity extends BaseActivity {

    @BindView(R.id.iv1_appear_clothes_activity) ImageView iv1AppearClothesActivity;
    @BindView(R.id.iv2_appear_clothes_activity) ImageView iv2AppearClothesActivity;
    private List<ClothesPicture> mClothesPicture = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appear_clothes);
        ButterKnife.bind(this);
        getDate();
    }

    public void getDate() {
        //获取isSelected 的所有数据 就是被选择的数据
        mClothesPicture = DBClothesPictureUtils.getInstance().queryDataDependIsSelected(true);
        if (mClothesPicture.size() == 2) {
            if (mClothesPicture.get(0).getClothesPictureType() == 1) {
                Glide.with(mContext)
                        .load(mClothesPicture.get(0).getClothesPicture())
                        .placeholder(R.drawable.icon_11)
                        .centerCrop()
                        .into(iv1AppearClothesActivity);

                Glide.with(mContext)
                        .load(mClothesPicture.get(1).getClothesPicture())
                        .placeholder(R.drawable.icon_11)
                        .centerCrop()
                        .into(iv2AppearClothesActivity);
            } else {
                Glide.with(mContext)
                        .load(mClothesPicture.get(1).getClothesPicture())
                        .placeholder(R.drawable.icon_11)
                        .centerCrop()
                        .into(iv1AppearClothesActivity);

                Glide.with(mContext)
                        .load(mClothesPicture.get(0).getClothesPicture())
                        .placeholder(R.drawable.icon_11)
                        .centerCrop()
                        .into(iv2AppearClothesActivity);
            }

        }
    }

    @Override
    protected void onDestroy() {
        for (ClothesPicture clothesPicture : mClothesPicture) {
            clothesPicture.setIsSelected(false);
        }
        DBClothesPictureUtils.getInstance().updateManData(mClothesPicture);
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}

