package com.xud.moduleb.entity;

/**
 * Created by xud on 2018/3/26.
 */

public class HourDataDTO extends BaseDTO {

    public int aqi;
    public String dateTime;

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
