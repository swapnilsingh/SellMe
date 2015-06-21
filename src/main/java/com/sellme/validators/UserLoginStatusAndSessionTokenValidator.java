/**
 * 
 */
package com.sellme.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sellme.domain.Login;
import com.sellme.domain.LoginStatus;
import com.sellme.domain.StatusBean;
import com.sellme.interfaces.Validator;
import com.sellme.util.LoginStatusBeanFactory;

/**
 * @author "Swapnil Singh"
 *
 */
public class UserLoginStatusAndSessionTokenValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserLoginStatusAndSessionTokenValidator.class);

    private Login login;
    private Login existingLogin;

    /**
     * @param login
     * @param existingLogin
     */
    public UserLoginStatusAndSessionTokenValidator(Login login,
            Login existingLogin) {
        this.login = login;
        this.existingLogin = existingLogin;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sellme.interfaces.Validator#validate()
     */
    @Override
    public StatusBean validate() {
        if (this.existingLogin.getLoginStatus() == 1
                && !login.getSessionToken().equalsIgnoreCase(
                        existingLogin.getSessionToken())) {
            LOGGER.warn("User already logged in some other device.");
            return LoginStatusBeanFactory
                    .getStatusBean(LoginStatus.USER_ALREADY_LOGGED_IN);
        } else if ((this.existingLogin.getLoginStatus() == 1 || this.existingLogin
                .getLoginStatus() != 1)
                && (login.getSessionToken().equalsIgnoreCase(
                        existingLogin.getSessionToken()) || existingLogin
                        .getSessionToken() == null)) {
            LOGGER.info("User [" + this.login.getUserId()
                    + "] successfully logged in..");
            return LoginStatusBeanFactory
                    .getStatusBean(LoginStatus.USER_SUCCESSFULLY_LOGGED_IN);
        }
        return null;
    }

}
