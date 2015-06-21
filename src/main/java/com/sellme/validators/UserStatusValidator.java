/**
 * 
 */
package com.sellme.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sellme.domain.LoginStatus;
import com.sellme.domain.StatusBean;
import com.sellme.interfaces.Validator;
import com.sellme.util.LoginStatusBeanFactory;

/**
 * @author "Swapnil Singh"
 *
 */
public class UserStatusValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserStatusValidator.class);

    private String userId;
    private int isUserActive = 0;

    /**
     * @param userActive
     */
    public UserStatusValidator(String userId, int userActive) {
        this.userId = userId;
        this.isUserActive = userActive;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sellme.interfaces.Validator#validate()
     */
    @Override
    public StatusBean validate() {
        if (this.isUserActive == 0) {
            LOGGER.warn("User ID [" + this.userId + "] disabled by Admin.");
            return LoginStatusBeanFactory
                    .getStatusBean(LoginStatus.USER_DISABLED);
        }
        return null;
    }
}
