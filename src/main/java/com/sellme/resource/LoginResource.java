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
import com.sellme.domain.Status;
import com.sellme.domain.StatusBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @author Swapnil Singh
 *
 */
@Path("/sell-me")
@Api(value="/sell-me",description="The following endpoint will expose the methods will perform login related opreations")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {
    
    
    @Path("/login")
    @POST
    @ApiOperation(value = "Accepts Login JSON", notes = "Authenticate User token", response = StatusBean.class)
    @Consumes(MediaType.APPLICATION_JSON)
    public StatusBean login(@ApiParam Login login) {
        System.out.println(login);
        StatusBean response = new StatusBean();
        response.setMessage("Welcome To SellMeApp!");
        response.setStatus(Status.SUCCESSFUL);
        return response;
    }
}
