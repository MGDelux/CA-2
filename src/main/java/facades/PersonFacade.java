package facades;

import dtos.PersonDTO;
import entities.HobbyEntity;
import entities.PersonEntity;
import static java.lang.String.format;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.OK;
import utils.EMF_Creator;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class PersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private PersonFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static PersonFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public PersonDTO createPerson(PersonEntity rm){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rm);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new PersonDTO(rm);
    }
    public PersonDTO editPerson(PersonEntity p) throws WebApplicationException{
        EntityManager em = getEntityManager();
        PersonEntity person = em.find(PersonEntity.class, p.getId());
        if (person == null) {
            throw new WebApplicationException(String.format("Person with id: (%d) not found", p.getId()));
        }
        person.setFirstName(p.getFirstName());
        person.setLastName(p.getLastName());
        person.setPhoneInfomation(p.getPhoneInfomation());
        try {
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
            return new PersonDTO(person);
        } finally {
            em.close();
        }
    }
    
     public List<PersonDTO> getAllPersons(){
        
        EntityManager em = emf.createEntityManager();
          List<PersonEntity> rms;
        try{
        TypedQuery<PersonEntity> query = em.createQuery("SELECT p FROM PersonEntity p", PersonEntity.class);
        rms = query.getResultList();
        }catch(Exception e){
     throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience",500);
    }
        return PersonDTO.getDtos(rms);
    }
    
    public PersonDTO getById(long id){
        EntityManager em = emf.createEntityManager();
        return new PersonDTO(em.find(PersonEntity.class, id));
    }
    
    //TODO Remove/Change this before use
    public long getPersonHobbyCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long personHobbyCount = (long)em.createQuery("SELECT COUNT(r) FROM PersonEntity r").getSingleResult();
            return personHobbyCount;
        }finally{  
            em.close();
        }
        
    }
    public PersonDTO addPerson(PersonEntity person){
              EntityManager em = emf.createEntityManager();
              if(person.getAddress() == null || person.getHobby() ==null || person.getPhoneInfomation() == null || person.getFirstName() == null){
                   throw new WebApplicationException(Response
          .status(BAD_REQUEST)
          .type(MediaType.APPLICATION_JSON)
          .entity(format("Missing info please check %s", person.toString()))
          .build());
              }
            try{
                em.getTransaction().begin();
                em.persist(person);
                em.getTransaction().commit();
                System.out.println(person);
               
            }catch(Exception e){
                  throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience",500);
            }finally{
                em.close();
            }
       return new PersonDTO(person);
    }
    
    public List<PersonDTO> getAllPersonByHobby(String hobby){
        EntityManager em = emf.createEntityManager();
        
        try{
        TypedQuery<PersonEntity> query = em.createQuery("SELECT r FROM PersonEntity r", PersonEntity.class);
        List<PersonEntity> rms = query.getResultList();
        List<PersonEntity> hobbyListTemp = new ArrayList<>();
        for(PersonEntity p : rms){
            if (p.getHobby().toString().toLowerCase().contains(hobby.toLowerCase()))
            {
                System.out.println(p);
                hobbyListTemp.add(p);
                
            }
        }
         return PersonDTO.getDtos(hobbyListTemp);
        }finally{
            em.close();
        }
     
    }
    
    public List<PersonDTO> getAllPersonByCity(String city){    
      EntityManager em = emf.createEntityManager();
 
        try{
        TypedQuery<PersonEntity> query = em.createQuery("SELECT r FROM PersonEntity r", PersonEntity.class);
        List<PersonEntity> rms = query.getResultList();
        List<PersonEntity> cityListTemp = new ArrayList<>();
        for(PersonEntity p : rms){
            if (p.getAddress().toString().toLowerCase().contains(city.toLowerCase()))
            {
                System.out.println(p);
                cityListTemp.add(p);
                
            }
        }
         return PersonDTO.getDtos(cityListTemp);
        }finally{
            em.close();
        }
     
    }

    public List<PersonDTO> getPersonByPhone(String phonenr) {
              EntityManager em = emf.createEntityManager();
 try{
              List<PersonEntity> persons = new ArrayList<>();
        TypedQuery<PersonEntity> query = em.createQuery("SELECT r FROM PersonEntity r", PersonEntity.class);
        List<PersonEntity> rms = query.getResultList();
        for(PersonEntity p : rms){
            System.out.println(p.getPhoneInfomation().toString());
        if(p.getPhoneInfomation().toString().toLowerCase().contains(phonenr)){
            persons.add(p);
        }       
 }
        return PersonDTO.getDtos(persons);
        
    }finally{
     em.close();
  }

}
}
