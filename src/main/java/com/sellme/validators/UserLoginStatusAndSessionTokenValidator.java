/**
 * 
 */
package com.sellme.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
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
        if(isUserLoggedIn()){
            return null;            
        }else{
            LOGGER.warn("User already logged in some other device.");
            return LoginStatusBeanFactory
                    .getStatusBean(LoginStatus.USER_ALREADY_LOGGED_IN);
        }
    }

    private boolean isUserLoggedIn() {
        boolean isCurrentUserSessionTokenValid = Strings.isNullOrEmpty(this.login.getSessionToken()) && Strings.isNullOrEmpty(this.existingLogin.getSessionToken()) && this.existingLogin.getLoginStatus() != 1;
        return isCurrentUserSessionTokenValid ||(this.existingLogin.getLoginStatus() == 1) && (login.getSessionToken().equalsIgnoreCase(existingLogin.getSessionToken()));
    }

}
