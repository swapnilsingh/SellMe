/**
 * 
 */
package com.sellme.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author Swapnil Singh
 *
 */
@Path("/sell-me")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {
    @GET
    public String login(@QueryParam("id") String userId,
            @QueryParam("pwd") String userPassword) {
        return "Hello "+ userId +" your password is "+userPassword;
    }
}
