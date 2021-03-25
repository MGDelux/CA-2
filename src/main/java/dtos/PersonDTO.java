/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.HobbyEntity;
import entities.PersonEntity;
import entities.PhoneEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class PersonDTO {
    
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<PhoneEntity> phoneInfomation;
    private List<HobbyEntity> hobbies;
    private AdressDTO adress;
    
    public PersonDTO(String firstName, String lastName, String email, long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
              
    }
    
    public static List<PersonDTO> getDtos(List<PersonEntity> rms){
        List<PersonDTO> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new PersonDTO(rm)));
        return rmdtos;
    }


    public PersonDTO(PersonEntity rm) {
        this.id = rm.getId();
        this.firstName = rm.getFirstName();
        this.lastName = rm.getLastName();
        this.email = rm.getEmail();
        this.phoneInfomation = rm.getPhoneInfomation();
        this.hobbies = rm.getHobby();
        this.adress = new AdressDTO(rm.getAddress());
    }

    public AdressDTO getAdress() {
        return adress;
    }

    public void setAdress(AdressDTO adress) {
        this.adress = adress;
    }

    
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PhoneEntity> getPhoneInfomation() {
        return phoneInfomation;
    }

    public void setPhoneInfomation(List<PhoneEntity> phoneInfomation) {
        this.phoneInfomation = phoneInfomation;
    }


    public List<HobbyEntity> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<HobbyEntity> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneInfomation=" + phoneInfomation + ", hobbies=" + hobbies + ", adress=" + adress + '}';
    }

   

  

    
    
    
}
