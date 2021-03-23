/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author zarpy
 */
@Entity
public class CityInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(length = 4)
    private String zipCode;
    @Column(length=35)
    private String city;
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    
    
    
    @ManyToOne
    private AdressEntity adresses;

    public AdressEntity getAdresses() {
        return adresses;
    }

    public void setAdresses(AdressEntity adresses) {
        this.adresses = adresses;
    }
    
    
    private Long id;
    
    public CityInfoEntity() {
    }  
    
    public CityInfoEntity(String zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
		
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
