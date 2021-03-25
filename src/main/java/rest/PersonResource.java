package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.PersonDTO;
import utils.EMF_Creator;
import facades.PersonFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("person")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final PersonFacade FACADE =  PersonFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String all(){
        List<PersonDTO> p = FACADE.getAllPersons();
        return GSON.toJson(p);
    }
    @Path("/{hobby}")
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
         

}
