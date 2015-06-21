/**
 *
 */
package com.sellme.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sellme.domain.Login;
import com.sellme.domain.LoginBeacon;
import com.sellme.domain.StatusBean;
import com.sellme.service.LoginService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @author Swapnil Singh
 *
 */
@Path("/sell-me")
@Api(value = "/sell-me", description = "The following endpoint will expose the methods will perform login related opreations")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(LoginResource.class);
    private LoginService loginService;

    /**
     * @param loginService
     */
    public LoginResource(LoginService loginService) {
        this.loginService = loginService;
    }

    @Path("/login")
    @POST
    @ApiOperation(value = "Accepts Login JSON", notes = "Authenticate User token", response = LoginBeacon.class)
    @Consumes(MediaType.APPLICATION_JSON)
    public LoginBeacon login(@ApiParam Login login) {
        LOGGER.info("User trying to Login.. [" + login.getUserId() + "]");
        return loginService.getLoginBeacon(login);
    }
    @Path("/logout")
    @POST
    @ApiOperation(value = "Accepts Login JSON", notes = "User Logging out", response = StatusBean.class)
    @Produces(MediaType.APPLICATION_JSON)
    public StatusBean logout(@QueryParam("userId") String userId,@QueryParam("sessionToken") String sessionToken) {
        LOGGER.info("User trying to Logout.. [" + userId + "]");
        return loginService.userLogout(userId,sessionToken);
    }
}
