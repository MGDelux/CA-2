/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 *
 * @author zarpy
 */
@Entity
@NamedQuery(name = "AdressEntity.deleteAllRows", query = "DELETE from AdressEntity")

public class AdressEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String streetName;
    private String additionalInfo;
  private PersonEntity person; 
 @ManyToOne(cascade = CascadeType.PERSIST)
   private CityInfoEntity cityInfo; 

    public CityInfoEntity getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfoEntity cityInfo) {
        this.cityInfo = cityInfo;
    }

   
    
    public AdressEntity() {
    }  

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
        //WGFF
    }
   
    
    public AdressEntity(String streetName, String additionalInfo) {
        this.streetName = streetName;
        this.additionalInfo = additionalInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "AdressEntity{" + "streetName=" + streetName + ", additionalInfo=" + additionalInfo + ", cityInfo=" + cityInfo + '}';
    }

 

   
    
    
}
