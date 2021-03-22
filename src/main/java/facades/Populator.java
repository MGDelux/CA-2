/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.PersonDTO;
import entities.PersonEntity;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        PersonFacade fe = PersonFacade.getFacadeExample(emf);
        fe.create(new PersonDTO(new PersonEntity("First 1", "Last 1")));
        fe.create(new PersonDTO(new PersonEntity("First 2", "Last 2")));
        fe.create(new PersonDTO(new PersonEntity("First 3", "Last 3")));
        
    }
    
    public static void main(String[] args) {
        populate();
    }
}
