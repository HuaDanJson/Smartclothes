package com.example.ji.smartclothes.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import cn.bmob.v3.BmobObject;

@Entity
public class ClothesPicture extends BmobObject {

    @Id(autoincrement = false)
    public long clothesPictureNumber;
    @Property(nameInDb = "Weather")
    private int clothesPictureType;//图片类型
    private String clothesPicture;//图片URL
    private boolean isSelected;

    @Generated(hash = 319387822)
    public ClothesPicture(long clothesPictureNumber, int clothesPictureType,
                          String clothesPicture, boolean isSelected) {
        this.clothesPictureNumber = clothesPictureNumber;
        this.clothesPictureType = clothesPictureType;
        this.clothesPicture = clothesPicture;
        this.isSelected = isSelected;
    }

    @Generated(hash = 1840213549)
    public ClothesPicture() {
    }

    public long getClothesPictureNumber() {
        return this.clothesPictureNumber;
    }

    public void setClothesPictureNumber(long clothesPictureNumber) {
        this.clothesPictureNumber = clothesPictureNumber;
    }

    public int getClothesPictureType() {
        return this.clothesPictureType;
    }

    public void setClothesPictureType(int clothesPictureType) {
        this.clothesPictureType = clothesPictureType;
    }

    public String getClothesPicture() {
        return this.clothesPicture;
    }

    public void setClothesPicture(String clothesPicture) {
        this.clothesPicture = clothesPicture;
    }

    public boolean getIsSelected() {
        return this.isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    @Override
    public String toString() {
        return "ClothesPicture{" +
                "clothesPictureNumber=" + clothesPictureNumber +
                ", clothesPictureType=" + clothesPictureType +
                ", clothesPicture='" + clothesPicture + '\'' +
                ", isSelected=" + isSelected +
                '}';
    }
}
