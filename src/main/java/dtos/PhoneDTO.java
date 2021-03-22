/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.PhoneEntity;
import java.util.ArrayList;
import java.util.List;

public class PhoneDTO {
    private Long id;
    private int number;
    private String description;

    
    public PhoneDTO(int number, String description) {
        this.number = number;
        this.description = description;
    }
    
    public static List<PhoneDTO> getDtos(List<PhoneEntity> rms){
        List<PhoneDTO> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new PhoneDTO(rm)));
        return rmdtos;
    }


    public PhoneDTO(PhoneEntity rm) {
        this.id = rm.getId();
        this.number = rm.getNumber();
        this.description = rm.getDescription();
    } 

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
