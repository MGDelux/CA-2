package facades;

import dtos.PersonDTO;
import entities.PersonEntity;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
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
    
    public PersonDTO createPerson(PersonDTO rm){
        PersonEntity rme = new PersonEntity(rm.getFirstName(), rm.getLastName(), rm.getEmail(), rm.getPhoneNr());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rme);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new PersonDTO(rme);
    }
    public PersonDTO editPerson(PersonEntity p) throws Exception{
        EntityManager em = getEntityManager();
        PersonEntity person = em.find(PersonEntity.class, p.getId());
        if (person == null) {
            throw new Exception(String.format("Person with id: (%d) not found", p.getId()));
        }
        person.setFirstName(p.getFirstName());
        person.setLastName(p.getLastName());
        person.setPhoneNr(p.getPhoneNr());
        try {
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
            return new PersonDTO(person);
        } finally {
            em.close();
        }
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
    
    public List<PersonDTO> getAllPersonByHobby(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<PersonEntity> query = em.createQuery("SELECT r FROM PersonEntity r", PersonEntity.class);
        List<PersonEntity> rms = query.getResultList();
        return PersonDTO.getDtos(rms);
    }
    
    public List<PersonDTO> getAllPersonByCity(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<PersonEntity> query = em.createQuery("SELECT r FROM PersonEntity r", PersonEntity.class);
        List<PersonEntity> rms = query.getResultList();
        return PersonDTO.getDtos(rms);
    }
    
  

}
