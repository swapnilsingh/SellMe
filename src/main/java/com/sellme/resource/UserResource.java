/**
 * 
 */
package com.sellme.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sellme.dao.UserDAO;
import com.sellme.domain.StatusBean;
import com.sellme.domain.User;
import com.sellme.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @author Swapnil Singh
 *
 */
@Path("/user")
@Api(value="/user",description="The following endpoint exposes the methods which would perform User releated opreations.")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);
    private UserService userService;
    
    /**
     * @param userService
     */
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @POST
    @ApiOperation(value = "Accepts User JSON", notes = "Create User", response = StatusBean.class)
    @Consumes(MediaType.APPLICATION_JSON)
    public StatusBean createUser(@ApiParam User user){
        userService.createUser(user);
        return new StatusBean();
    }
}
