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
import entities.CityInfoEntity;
import entities.HobbyEntity;
import entities.PersonEntity;
import entities.PhoneEntity;
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
       PersonEntity pe = new PersonEntity("fnavn","enavn","email");
       pf.createPerson(pe);
    }
    
    public static void main(String[] args) {  
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityManager em = emf.createEntityManager(); 
    
    PersonEntity p1 = new PersonEntity("Jønke","j","email");
       PersonEntity p2 = new PersonEntity("Ali","A","email@ali.com");
    CityInfoEntity cie = new CityInfoEntity("3400","HILLERØD");
     CityInfoEntity cie2 = new CityInfoEntity("1080","KØB EN HAVN");
    AdressEntity a1 = new AdressEntity("Lyngbyvej 132","privat telefon");
    AdressEntity a2 = new AdressEntity("Pøls 132","privat telefon");
        PhoneEntity ph1 = new PhoneEntity(342432234,"SOME VIRGINS PHONE");
        PhoneEntity ph2 = new PhoneEntity(123123434,"SOME CHADS PHONE");
        ArrayList<PhoneEntity> phon1 = new ArrayList<>();
    ArrayList<PhoneEntity> phon = new ArrayList<>();
phon1.add(ph2);
phon.add(ph1);
    ArrayList<HobbyEntity> activities = new ArrayList<>();
    ArrayList<HobbyEntity> activities1 = new ArrayList<>();
    HobbyEntity h1 = new HobbyEntity("HÅNDBOLD","Link","General","udendørs");
    HobbyEntity h2 = new HobbyEntity("fodbold","Link","General","udendørs");
    a1.setCityInfo(cie);
    a2.setCityInfo(cie2);
        p1.setAddress(a1);
        p2.setAddress(a2);

    activities.add(h1);
    activities1.add(h2);
    activities1.add(h1);
    p2.setHobby(activities);
    p2.setPhoneInfomation(phon1);
    p1.setPhoneInfomation(phon);
    p1.setHobby(activities1);
        
        
     em.getTransaction().begin();
     em.persist(p1);
     em.persist(p2);
     em.getTransaction().commit();
        System.out.println("Håndbold person" +FACADE.getAllPersonByHobby("HÅNDBOLD"));
        
    System.out.println("Jønkes activity  " + p1.getHobby());
    
    System.out.println("Jønkes adresse  " + p1.getAddress());
     System.out.println("Jønkes tlf  " + p1.getPhoneInfomation());

    
   
    }
}
