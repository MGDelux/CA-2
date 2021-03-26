package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.PersonDTO;
import entities.PersonEntity;
import utils.EMF_Creator;
import facades.PersonFacade;
import static java.lang.String.format;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.OK;

//Todo Remove or change relevant parts before ACTUAL use
@Path("person")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final PersonFacade FACADE =  PersonFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
     @Path("/status")
     @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String apiStatus(){
   return "{\"msg\":\"Person API Online\"}";
    }
 
     @Path("/add")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
     @Consumes(MediaType.APPLICATION_JSON)
    public void addNewPerson(PersonEntity p){
        EntityManager em = EMF.createEntityManager();
         System.out.println(p);
        try{
             if(p.getAddress() == null || p.getHobby() ==null || p.getPhoneInfomation() == null || p.getFirstName() == null){
                   throw new WebApplicationException(Response
          .status(BAD_REQUEST)
          .type(MediaType.APPLICATION_JSON)
          .entity(format("Missing info please check %s", p.toString()))
          .build());
         
             }
        }catch(Exception e){
                  throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience",501);
    }finally{
              FACADE.addPerson(p);
        }
    }
    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getbyid(@PathParam("id")long id) throws Exception{
        System.out.println(id);
        PersonDTO p = FACADE.getById(id);
        System.out.println(p);
        return GSON.toJson(p);
    }
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String all(){
        List<PersonDTO> p = FACADE.getAllPersons();
        return GSON.toJson(p);
    }
    @Path("/hobby/{hobby}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String hobby(@PathParam("hobby")String hobby) throws Exception{
        System.out.println(hobby);
        List<PersonDTO> p = FACADE.getAllPersonByHobby(hobby);
        System.out.println(p);
        return GSON.toJson(p);
    }
     @Path("/city/{city}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
         public String city(@PathParam("city")String city) throws Exception{
                     System.out.println(city);
              List<PersonDTO> p = FACADE.getAllPersonByCity(city);
              System.out.println(p);
        return GSON.toJson(p);
         }
         
   @Path("/phone/{phonenr}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
         public String phone(@PathParam("phonenr")String phonenr) throws Exception{
                     System.out.println(phonenr);
            List<PersonDTO> list =  FACADE.getPersonByPhone(phonenr);
        return GSON.toJson(list);
         }
         
}
