/**
 *
 */
package com.sellme.service;

import com.sellme.dao.LoginDAO;
import com.sellme.domain.Login;
import com.sellme.domain.Status;
import com.sellme.domain.StatusBean;

/**
 * @author Swapnil Singh
 *
 */
public class LoginService {

    private LoginDAO loginDAO;

    /**
     * @param loginDAO
     */
    public LoginService(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    public StatusBean userLogin(Login login) {
        StatusBean statusBean = new StatusBean();
        if (userDoesNotExists(login)) {
            statusBean.setMessage("User does not exists.["+login+"]");
            statusBean.setStatus(Status.UNSUCCESSFUL);
        }
        if (userAlreadyLoggedIn(login)) {
            statusBean.setMessage("User already logged in some other device.");
            statusBean.setStatus(Status.UNSUCCESSFUL);
        }
        if(userIsDeactivated(login)){
            statusBean.setMessage("User account is deactivated please contact Admin.["+login+"]");
            statusBean.setStatus(Status.UNSUCCESSFUL);
        }
        if (userInvalidCredentials(login)) {
            statusBean.setMessage("Invalid Credentials!.");
            statusBean.setStatus(Status.UNSUCCESSFUL);
        }else{
            setLoginSuccefulMessage(statusBean);
        }
        return statusBean;
    }

    /**
     * @param login
     * @return
     */
    private boolean userIsDeactivated(Login login) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @param statusBean
     */
    private void setLoginSuccefulMessage(StatusBean statusBean) {
        statusBean.setMessage("Welcome to Sell Me!");
        statusBean.setStatus(Status.SUCCESSFUL);
    }

    /**
     * @param login
     * @return
     */
    private boolean userInvalidCredentials(Login login) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @param login
     * @return
     */
    private boolean userAlreadyLoggedIn(Login login) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @param login
     * @return
     */
    private boolean userDoesNotExists(Login login) {
        // TODO Auto-generated method stub
        return false;
    }

}
