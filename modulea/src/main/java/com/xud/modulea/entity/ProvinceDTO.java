package com.xud.modulea.entity;

import java.util.List;

public class ProvinceDTO extends BaseDTO {

    public String province;

    public List<CityDTO> city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<CityDTO> getCity() {
        return city;
    }

    public void setCity(List<CityDTO> city) {
        this.city = city;
    }
}
