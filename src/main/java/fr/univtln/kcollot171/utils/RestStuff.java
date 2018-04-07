package fr.univtln.kcollot171.utils;

import fr.univtln.kcollot171.data.Chien;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;
import java.util.List;

@Path("/rest")
@Produces({"application/json", "application/xml"})
public class RestStuff {
    public RestStuff(){}

    private final static ChienManager cmanager = new ChienManager();

    @GET
    @Path("/chiens")
    public List<Chien> getChiens(){
        return cmanager.getChiens();
    }

    @GET
    @Path("/chiens/{id}")
    public Chien getChien(@PathParam("id") final int id){
        return cmanager.getChien(id);
    }

    @DELETE
    @Path("/chiens/{id}")
    public void deleteChien(@PathParam("id") final int id){
        cmanager.deleteChien(id);
    }

    @POST
    @Path("/chiens")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addChien(Chien chien){
        cmanager.addChien(chien);
    }

    @PUT
    @Path("/chiens")
    public void majChien(Chien chien){
        cmanager.majChien(chien);
    }

}
