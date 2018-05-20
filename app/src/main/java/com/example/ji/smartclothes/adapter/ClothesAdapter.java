package com.example.ji.smartclothes.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.ji.smartclothes.R;
import com.example.ji.smartclothes.avtivity.AppearClothesActivity;
import com.example.ji.smartclothes.bean.ClothesPicture;
import com.example.ji.smartclothes.utils.DBClothesPictureUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ClothesAdapter extends RecyclerView.Adapter {

    private List<ClothesPicture> clothesPictureList = new ArrayList<>();
    private Context mContext;

    public ClothesAdapter(List<ClothesPicture> clothesPictureList, Context mContext) {
        this.mContext = mContext;
        this.clothesPictureList = clothesPictureList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_clothes, parent, false);
        return new ClothesAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        ((ClothesAdapterViewHolder) viewHolder).mClothes.setAlpha(1.0f);
        Glide.with(mContext)
                .load(clothesPictureList.get(position).getClothesPicture())
                .placeholder(R.drawable.icon_11)
                .centerCrop()
                .into(((ClothesAdapterViewHolder) viewHolder).mClothes);

        ((ClothesAdapterViewHolder) viewHolder).mClothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ClothesAdapterViewHolder) viewHolder).mClothes.setAlpha(0.25f);
                //更新数据库中的数据为Selected
                ClothesPicture clothesPicture = DBClothesPictureUtils.getInstance().queryOneData(clothesPictureList.get(position).getClothesPictureNumber());
                if (clothesPicture != null) {
                    clothesPicture.setIsSelected(true);
                    DBClothesPictureUtils.getInstance().updateData(clothesPicture);
                }

                if (isSelectTwoPicture()) {
                    Intent intent = new Intent(mContext, AppearClothesActivity.class);
                    mContext.startActivity(intent);
                    notifyDataSetChanged();
                    for (int i = 0; i < clothesPictureList.size(); i++) {
                        clothesPictureList.get(i).setIsSelected(false);
                    }
                }
            }
        });
    }

    public boolean isSelectTwoPicture() {
        List<ClothesPicture> clothesPictures = DBClothesPictureUtils.getInstance().queryDataDependIsSelected(true);
        if (clothesPictures != null && clothesPictures.size() >= 2) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public int getItemCount() {
        return clothesPictureList.size();
    }

    public static class ClothesAdapterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_close_adapter)
        ImageView mClothes;

        public ClothesAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
