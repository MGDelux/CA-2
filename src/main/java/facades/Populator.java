/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.PersonDTO;
import entities.HobbyEntity;
import entities.PersonEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    
    PersonEntity p1 = new PersonEntity("Jønke","j","email",22222223);
    
    
    List<HobbyEntity> activities = new ArrayList<HobbyEntity>();
    
    HobbyEntity h1 = new HobbyEntity("Fodbold","Link","General","udendørs");
    activities.add(h1);
    p1.setActivities(activities);
        
        
        
    System.out.println("Jønkes activity  " + p1.getActivities());
    
     em.getTransaction().begin();
     em.persist(p1);
     em.getTransaction().commit();
    }
}
