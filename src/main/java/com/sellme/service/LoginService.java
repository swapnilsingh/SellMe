/**
 *
 */
package com.sellme.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.sellme.dao.LoginDAO;
import com.sellme.dao.UserDAO;
import com.sellme.domain.Login;
import com.sellme.domain.LoginBeacon;
import com.sellme.domain.LoginStatus;
import com.sellme.domain.Status;
import com.sellme.domain.StatusBean;
import com.sellme.domain.User;
import com.sellme.interfaces.Validator;
import com.sellme.util.LoginStatusBeanFactory;
import com.sellme.util.PasswordEncryptorUtil;
import com.sellme.validators.UserCredentialsValidator;
import com.sellme.validators.UserExistanceValidator;
import com.sellme.validators.UserLoginStatusAndSessionTokenValidator;
import com.sellme.validators.UserStatusValidator;
import com.sellme.validators.UserSubscriptionValidator;

/**
 * @author Swapnil Singh
 *
 */
public class LoginService {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(LoginService.class);

    private LoginDAO loginDAO;
    private UserDAO userDAO;

    private static final int FIRST_ELEMENT = 0;

    /**
     * @param loginDAO
     */
    public LoginService(LoginDAO loginDAO,UserDAO userDAO) {
        this.loginDAO = loginDAO;
        this.userDAO = userDAO;
    }

    private StatusBean userLogin(Login login) {
        StatusBean statusBean = null;
        List<Validator> loginValidators = initializeValidators(login);
        LOGGER.info("Checking Login Validations..");
        for (Validator loginValidator : loginValidators) {
            statusBean = loginValidator.validate();
            if (statusBean != null) {
                LOGGER.warn("Invalid Login attempt..");
                return statusBean;
            } else {
                statusBean = LoginStatusBeanFactory
                        .getStatusBean(LoginStatus.USER_SUCCESSFULLY_LOGGED_IN);
            }
        }
        LOGGER.info("User ["+login.getUserId()+"] logged in successfully!");
        signInUser(login);
        return statusBean;
    }

    private void signInUser(Login login) {
        Login existingLogin = getExistingLogin(login.getUserId());
        if(Strings.isNullOrEmpty(login.getSessionToken()) && Strings.isNullOrEmpty(existingLogin.getSessionToken()) && existingLogin.getLoginStatus()==0){
            this.loginDAO
            .signInUser(login.getUserId(), PasswordEncryptorUtil.encrypt(new Date().toString()));
        }else{
            this.loginDAO
            .signInUser(login.getUserId(), login.getSessionToken());
        }
    }

    private List<Validator> initializeValidators(Login login) {
        List<Validator> loginValidators = new ArrayList<Validator>();
        Login existingLogin = getExistingLogin(login.getUserId());
        User userDetails = getUserDetails(login.getUserId());
        int isUserActive = getIsUserActive(login.getUserId());
        LOGGER.info("Initlizing Login Validator..");
        loginValidators.add(new UserExistanceValidator(existingLogin, login));
        if (existingLogin != null) {
            loginValidators.add(new UserCredentialsValidator(login.getUserId(),
                    login.getUserPassword(), existingLogin
                            .getUserPassword()));
            loginValidators.add(new UserLoginStatusAndSessionTokenValidator(
                    login, existingLogin));
            loginValidators.add(new UserSubscriptionValidator(userDetails));
            loginValidators.add(new UserStatusValidator(login.getUserId(), isUserActive));
        }
        return loginValidators;
    }

    /**
     * @param userId
     * @return
     */
    private int getIsUserActive(String userId) {
        return this.loginDAO.isUserActive(userId);
    }

    /**
     * @param userId
     * @return
     */
    private User getUserDetails(String userId) {
        return this.userDAO.getUserByUserId(userId);
    }

    public LoginBeacon getLoginBeacon(Login login) {
        LoginBeacon loginBecon = new LoginBeacon();
        loginBecon.setStatusBean(userLogin(login));
        if(loginBecon.getStatusBean().getStatus()== Status.SUCCESSFUL && Strings.isNullOrEmpty(login.getSessionToken())){
            loginBecon.setSessionToken(getExistingLogin(login.getUserId()).getSessionToken());
        }
        return loginBecon;
    }

    private Login getExistingLogin(String userId) {
        List<Login> loginDetailsInDb = loginDAO.getLoginDetailsByUserId(userId);
        return !loginDetailsInDb.isEmpty() ? loginDetailsInDb
                .get(FIRST_ELEMENT) : null;
    }

    /**
     * @param userId
     * @param sessionToken
     * @return
     */
    public StatusBean userLogout(String userId, String sessionToken) {
        StatusBean statusBean = new StatusBean();
        statusBean.setMessage("Logout Error due to curropt data transmission.");
        statusBean.setStatus(Status.UNSUCCESSFUL);
        Login existingLoginDetails = getExistingLogin(userId);
        if (existingLoginDetails != null
                && existingLoginDetails.getUserId().equalsIgnoreCase(userId)
                && existingLoginDetails.getSessionToken().equalsIgnoreCase(
                        sessionToken)) {
            this.loginDAO.logout(userId, sessionToken,"");
            statusBean.setMessage("Successfully Logged Out!");
            statusBean.setStatus(Status.SUCCESSFUL);
        }
        return statusBean;
    }

}
