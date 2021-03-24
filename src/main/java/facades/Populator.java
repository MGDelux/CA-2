/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.PersonDTO;
import entities.AdressEntity;
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
        private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final PersonFacade FACADE =  PersonFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        PersonFacade pf = PersonFacade.getFacadeExample(emf);
       PersonEntity pe = new PersonEntity("fnavn","enavn","email",1234);
       pf.createPerson(pe);
    }
    
    public static void main(String[] args) {  
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityManager em = emf.createEntityManager(); 
    
    PersonEntity p1 = new PersonEntity("Jønke","j","email",22222223);
    
    AdressEntity a1 = new AdressEntity("Lyngbyvej 132","privat telefon");
    
    p1.setAddress(a1);
    
    
    List<HobbyEntity> activities = new ArrayList<HobbyEntity>();
    
    HobbyEntity h1 = new HobbyEntity("Fodbold","Link","General","udendørs");
    activities.add(h1);
    p1.setActivities(activities);
        
        
     em.getTransaction().begin();
     em.persist(p1);
     em.getTransaction().commit();
    
        
    System.out.println("Jønkes activity  " + p1.getActivities());
    
    System.out.println("Jønkes adresse  " + p1.getAddress());
    
   
    }
}
