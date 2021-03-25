/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.CityInfoDTO;
import entities.CityInfoEntity;
import entities.PersonEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author mathi
 */
public class CityInfoFacade {
       private static CityInfoFacade instance;
    private static EntityManagerFactory emf;

    public CityInfoFacade() {
    }
    
     public static CityInfoFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CityInfoFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<CityInfoDTO> getAllZipCodes(){
        EntityManager em = getEntityManager();
        List<CityInfoEntity> rms;
        try{
             TypedQuery<CityInfoEntity> query = em.createQuery("SELECT p FROM CityInfoEntity p", CityInfoEntity.class);
              rms = query.getResultList();
        }finally{
            em.close();
        }
        return CityInfoDTO.getDtos(rms);
    }
    
    
    
}
