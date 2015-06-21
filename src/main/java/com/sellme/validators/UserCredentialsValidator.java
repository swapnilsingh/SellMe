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
import com.sellme.util.PasswordEncryptorUtil;

/**
 * @author "Swapnil Singh"
 *
 */
public class UserCredentialsValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserCredentialsValidator.class);
    private String userId;
    private String loginPassword;
    private String existingPassword;

    /**
     * @param userPassword
     * @param existingUserPassword
     */
    public UserCredentialsValidator(String userId, String userPassword,
            String existingUserPassword) {
        this.userId = userId;
        this.loginPassword = userPassword;
        this.existingPassword = existingUserPassword;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sellme.interfaces.Validator#validate()
     */
    @Override
    public StatusBean validate() {
        if (!PasswordEncryptorUtil.check(this.loginPassword,
                this.existingPassword)) {
            LOGGER.warn("Invalid credentials supplied for userId ["
                    + this.userId + "]");
            return LoginStatusBeanFactory
                    .getStatusBean(LoginStatus.INVALID_CREDENTIALS);
        }
        return null;
    }

}
