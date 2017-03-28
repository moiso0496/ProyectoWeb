/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import Miembros.DataBase;
import Miembros.Miembro;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author moisesfallas
 */
@Path("generic")
public class GenericResource {
    
   

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }
   public String pass;
    /**
     * Retrieves representation of an instance of POJO.GenericResource
     * @return an instance of java.lang.String
     */
    
    private void encontrar(String username) {
        for (int i = 0; i < DataBase.lista.size(); i++) {
            boolean si = DataBase.lista.get(i).getUser().equalsIgnoreCase(username);
            if (si == true) {
                pass = DataBase.lista.get(i).pass;
            } else {
                pass = "error";
            }
        }
    }
    
    private void agregar (String user, String pass, String email, int tel){
    
        DataBase.lista.add(new Miembro(user,pass,email,tel));
    }

    
    @GET
    @Path("/search/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("username")String username) {
        
        encontrar(username);
        return new Gson().toJson(pass);
      
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Path("/add/{user}/{pass}/{email}/{tel}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(@PathParam("user")String username ,@PathParam("pass")String pass,@PathParam("email")String email, @PathParam("tel") int tel) {
       
        agregar(username,pass,email,tel);
        
        String output = DataBase.lista.toString();
                
        return Response.status(200).entity(output).build();
        
        
    }
}
