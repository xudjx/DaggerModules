package com.xud.moduleb.entity;

public class EnvironmentFeatureDTO extends BaseDTO {

    public int aqi;
    public String date;
    public String quality;

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
