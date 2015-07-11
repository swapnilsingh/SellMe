/**
 * 
 */
package com.sellme.validators;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sellme.domain.LoginStatus;
import com.sellme.domain.StatusBean;
import com.sellme.domain.User;
import com.sellme.interfaces.Validator;
import com.sellme.util.LoginStatusBeanFactory;

/**
 * @author "Swapnil Singh"
 *
 */
public class UserSubscriptionValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserSubscriptionValidator.class);
    
    private User userDetails;

    /**
     * @param login
     * @param userDetails
     */
    public UserSubscriptionValidator(User userDetails) {
        this.userDetails = userDetails;
    }

    /* (non-Javadoc)
     * @see com.sellme.interfaces.Validator#validate()
     */
    @Override
    public StatusBean validate() {
        if(this.userDetails.getUserSubscriptionEndDate() != null && new Date().after(this.userDetails.getUserSubscriptionEndDate())){
            LOGGER.warn("User Subscription Ended!");
            return LoginStatusBeanFactory.getStatusBean(LoginStatus.USER_SUBSCRIPTION_ENDED);
        }
        return null;
    }

}
