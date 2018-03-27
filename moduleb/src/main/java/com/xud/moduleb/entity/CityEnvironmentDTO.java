package com.xud.moduleb.entity;

import java.util.List;

public class CityEnvironmentDTO extends BaseDTO {

    public int aqi;
    public String city;//**************//
    public String distrct;//****************//
    public String province;

    List<EnvironmentFeatureDTO> fetureData;

    List<HourDataDTO> hourData;

    public int no2;
    public int pm10;
    public int pm25;//*************//
    public int so2;
    public String quality;

    public String  updateTime;

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrct() {
        return distrct;
    }

    public void setDistrct(String distrct) {
        this.distrct = distrct;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<EnvironmentFeatureDTO> getFetureData() {
        return fetureData;
    }

    public void setFetureData(List<EnvironmentFeatureDTO> fetureData) {
        this.fetureData = fetureData;
    }

    public List<HourDataDTO> getHourData() {
        return hourData;
    }

    public void setHourData(List<HourDataDTO> hourData) {
        this.hourData = hourData;
    }

    public int getNo2() {
        return no2;
    }

    public void setNo2(int no2) {
        this.no2 = no2;
    }

    public int getPm10() {
        return pm10;
    }

    public void setPm10(int pm10) {
        this.pm10 = pm10;
    }

    public int getPm25() {
        return pm25;
    }

    public void setPm25(int pm25) {
        this.pm25 = pm25;
    }

    public int getSo2() {
        return so2;
    }

    public void setSo2(int so2) {
        this.so2 = so2;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
