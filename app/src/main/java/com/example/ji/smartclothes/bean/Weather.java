package com.example.ji.smartclothes.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import cn.bmob.v3.BmobObject;

@Entity
public class Weather extends BmobObject {
    @Id(autoincrement = false)
    public long getDateTiem;
    @Property(nameInDb = "Weather")
    private int temperature;//温度
    private String cloud;//天气情况
    private String city;//城市
    private String remind;//天气提示
    @Generated(hash = 677740281)
    public Weather(long getDateTiem, int temperature, String cloud, String city,
            String remind) {
        this.getDateTiem = getDateTiem;
        this.temperature = temperature;
        this.cloud = cloud;
        this.city = city;
        this.remind = remind;
    }
    @Generated(hash = 556711069)
    public Weather() {
    }
    public long getGetDateTiem() {
        return this.getDateTiem;
    }
    public void setGetDateTiem(long getDateTiem) {
        this.getDateTiem = getDateTiem;
    }
    public int getTemperature() {
        return this.temperature;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    public String getCloud() {
        return this.cloud;
    }
    public void setCloud(String cloud) {
        this.cloud = cloud;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getRemind() {
        return this.remind;
    }
    public void setRemind(String remind) {
        this.remind = remind;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "getDateTiem=" + getDateTiem +
                ", temperature=" + temperature +
                ", cloud='" + cloud + '\'' +
                ", city='" + city + '\'' +
                ", remind='" + remind + '\'' +
                '}';
    }
}
