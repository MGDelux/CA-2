/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.CityInfoEntity;
import java.util.ArrayList;
import java.util.List;


public class CityInfoDTO {
    private String zipCode;
    private String city;
    
    private Long id;
    
    public CityInfoDTO(String zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }

    public static List<CityInfoDTO> getDtos(List<CityInfoEntity> rms){
        List<CityInfoDTO> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new CityInfoDTO(rm)));
        return rmdtos;
    }


    public CityInfoDTO(CityInfoEntity rm) {
        this.id = rm.getId();
        this.zipCode = rm.getZipCode();
        this.city = rm.getCity();
    }
    
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
        
        
    
}
