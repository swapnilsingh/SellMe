/**
 *
 */
package com.sellme.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sellme.dao.LoginDAO;
import com.sellme.domain.Login;
import com.sellme.domain.LoginBeacon;
import com.sellme.domain.LoginStatus;
import com.sellme.domain.Status;
import com.sellme.domain.StatusBean;
import com.sellme.interfaces.Validator;
import com.sellme.util.LoginStatusBeanFactory;
import com.sellme.util.PasswordEncryptorUtil;
import com.sellme.validators.UserCredentialsValidator;
import com.sellme.validators.UserExistanceValidator;
import com.sellme.validators.UserLoginStatusAndSessionTokenValidator;
import com.sellme.validators.UserStatusValidator;

/**
 * @author Swapnil Singh
 *
 */
public class LoginService {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(LoginService.class);

    private LoginDAO loginDAO;

    private static final int FIRST_ELEMENT = 0;

    /**
     * @param loginDAO
     */
    public LoginService(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    private StatusBean userLogin(Login login) {
        StatusBean statusBean = null;
        List<Login> loginDetailsInDb = loginDAO.getLoginDetailsByUserId(login
                .getUserId());
        List<Validator> loginValidators = new ArrayList<Validator>();
        LOGGER.info("Initlizing Login Validator..");
        loginValidators
                .add(new UserExistanceValidator(loginDetailsInDb, login));
        if (getExistingLogin(loginDetailsInDb) != null) {
            loginValidators.add(new UserCredentialsValidator(login.getUserId(),
                    login.getUserPassword(), getExistingLogin(loginDetailsInDb)
                            .getUserPassword()));
            loginValidators.add(new UserLoginStatusAndSessionTokenValidator(
                    login, getExistingLogin(loginDetailsInDb)));
        }
        loginValidators.add(new UserStatusValidator(login.getUserId(), loginDAO
                .isUserActive(login.getUserId())));
        LOGGER.info("Checking Login Validations..");
        for (Validator loginValidator : loginValidators) {
            statusBean = loginValidator.validate();
            if (statusBean == null) {
                statusBean = LoginStatusBeanFactory
                        .getStatusBean(LoginStatus.USER_SUCCESSFULLY_LOGGED_IN);
            } else if (statusBean != null) {
                if (statusBean.getStatus() == Status.UNSUCCESSFUL) {
                    LOGGER.warn("Invalid Login attempt..");
                    return statusBean;
                } else {
                    return statusBean;
                }
            }
        }
        if (statusBean.getStatus() == Status.SUCCESSFUL) {
            this.loginDAO
                    .signInUser(login.getUserId(), login.getSessionToken());
        }
        return statusBean;
    }

    public LoginBeacon getLoginBeacon(Login login) {
        LoginBeacon loginBecon = new LoginBeacon();
        loginBecon.setStatusBean(userLogin(login));
        if(loginBecon.getStatusBean().getStatus()== Status.SUCCESSFUL){
            loginBecon.setSessionToken(PasswordEncryptorUtil.encrypt(new Date()
            .toString()));
        }
        return loginBecon;
    }

    private Login getExistingLogin(List<Login> loginDetailsInDb) {
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
        List<Login> loginDetailsInDb = loginDAO.getLoginDetailsByUserId(userId);
        Login existingLoginDetails = getExistingLogin(loginDetailsInDb);
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
