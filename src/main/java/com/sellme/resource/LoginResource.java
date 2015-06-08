/**
 * 
 */
package com.sellme.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sellme.domain.Login;
import com.sellme.domain.StatusBean;
import com.sellme.domain.Status;

/**
 * @author Swapnil Singh
 *
 */
@Path("/sell-me")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {
    
    
    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public StatusBean login(Login login) {
        System.out.println(login);
        StatusBean response = new StatusBean();
        response.setMessage("Welcome To SellMeApp!");
        response.setStatus(Status.SUCCESSFUL);
        return response;
    }
}
