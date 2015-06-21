/**
 * 
 */
package com.sellme.validators;

import java.util.List;

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
public class UserExistanceValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserExistanceValidator.class);

    private List<Login> loginDetailsInDb;
    private Login login;

    /**
     * @param loginDetailsInDb
     */
    public UserExistanceValidator(List<Login> loginDetailsInDb, Login login) {
        this.loginDetailsInDb = loginDetailsInDb;
        this.login = login;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sellme.interfaces.Validator#validate()
     */
    @Override
    public StatusBean validate() {
        if (this.loginDetailsInDb.isEmpty()) {
            LOGGER.warn("User does not exists[" + login.getUserId() + "]");
            return LoginStatusBeanFactory
                    .getStatusBean(LoginStatus.USER_DOES_NOT_EXISTS);
        }
        return null;
    }

}
