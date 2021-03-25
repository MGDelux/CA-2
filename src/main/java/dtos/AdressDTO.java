/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.AdressEntity;
import entities.CityInfoEntity;
import java.util.ArrayList;
import java.util.List;

public class AdressDTO {
    private Long id;
    private String streetName;
    private String additionalInfo;
    private CityInfoEntity cityinfo;
    
    public AdressDTO(String streetName, String additionalInfo) {
        this.streetName = streetName;
        this.additionalInfo = additionalInfo;
    }
    
    public static List<AdressDTO> getDtos(List<AdressEntity> rms){
        List<AdressDTO> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new AdressDTO(rm)));
        return rmdtos;
    }


    public AdressDTO(AdressEntity rm) {
        this.id = rm.getId();
        this.streetName = rm.getStreetName();
        this.additionalInfo = rm.getAdditionalInfo();
        this.cityinfo = rm.getCityInfo();
    }  

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public CityInfoEntity getCityinfo() {
        return cityinfo;
    }

    public void setCityinfo(CityInfoEntity cityinfo) {
        this.cityinfo = cityinfo;
    }

    @Override
    public String toString() {
        return "AdressDTO{" + "id=" + id + ", streetName=" + streetName + ", additionalInfo=" + additionalInfo + ", cityinfo=" + cityinfo + '}';
    }
    
    
}
