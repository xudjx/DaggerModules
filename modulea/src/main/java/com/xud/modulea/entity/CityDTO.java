package com.xud.modulea.entity;

import java.util.List;

public class CityDTO extends BaseDTO {

    public String city;

    public List<DistrictDTO> district;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<DistrictDTO> getDistrict() {
        return district;
    }

    public void setDistrict(List<DistrictDTO> district) {
        this.district = district;
    }
}
