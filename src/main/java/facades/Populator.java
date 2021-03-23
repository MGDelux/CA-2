/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.PersonDTO;
import entities.HobbyEntity;
import entities.PersonEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        PersonFacade fe = PersonFacade.getFacadeExample(emf);
        fe.createPerson(new PersonDTO(new PersonEntity("First 1", "Last 1","EMAIL",12345)));
        
    }
    
    public static void main(String[] args) {  
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityManager em = emf.createEntityManager(); 
    populate();
    
    PersonEntity p1 = new PersonEntity("Jønke","j","email",22222223);
    
    HobbyEntity h1 = new HobbyEntity("Fodbold","Link","General","udendørs");
    
    p1.setHobbyEntity(h1);
        
    System.out.println("Jønkes activity  " + p1.getHobbyEntity());
    }
}
