/**
 * 
 */
package com.sellme.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sellme.domain.Login;
import com.sellme.domain.LoginStatus;
import com.sellme.domain.StatusBean;
import com.sellme.domain.UserRoleType;
import com.sellme.interfaces.Validator;
import com.sellme.util.LoginStatusBeanFactory;

/**
 * @author "Swapnil Singh"
 *
 */
public class UserExistanceValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserExistanceValidator.class);

    private Login existingLoginInDB;
    private Login login;

    /**
     * @param loginDetailsInDb
     */
    public UserExistanceValidator(Login existingLoginInDB, Login login) {
        this.existingLoginInDB = existingLoginInDB;
        this.login = login;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sellme.interfaces.Validator#validate()
     */
    @Override
    public StatusBean validate() {
        if(!UserRoleType.isValidUserRoleType(this.login.getUserRole()) || this.login.getUserRole() != this.existingLoginInDB.getUserRole()){
            LOGGER.warn("Invalid User Role[" + login.getUserRole() + "]");
            return LoginStatusBeanFactory
                    .getStatusBean(LoginStatus.INVALID_USER_ROLE);
        }
        if (this.existingLoginInDB == null) {
            LOGGER.warn("User does not exists[" + login.getUserId() + "]");
            return LoginStatusBeanFactory
                    .getStatusBean(LoginStatus.USER_DOES_NOT_EXISTS);
        }
        return null;
    }

}
