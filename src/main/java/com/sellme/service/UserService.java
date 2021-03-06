/**
 *
 */
package com.sellme.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sellme.dao.UserDAO;
import com.sellme.domain.Status;
import com.sellme.domain.StatusBean;
import com.sellme.domain.User;
import com.sellme.util.PasswordEncryptorUtil;

/**
 * @author Swapnil Singh
 *
 */
public class UserService {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserService.class);
    private UserDAO userDAO;

    /**
     * @param userDAO
     * @param sellMeConfiguration
     */
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * The following method will create the user.
     *
     * @param user
     */
    public StatusBean createUser(User user) {
        StatusBean statusBean = new StatusBean();
        LOGGER.info("Calling UserDao");
        List<User> existingUser = this.userDAO
                .getUserByUserIdOrMobileNumberOrEmail(user);
        if (existingUser.isEmpty()) {
            user.setUserSubscriptionDate();
            this.userDAO.createUser(user);
            this.userDAO.createLogin(user.getUserId(),
                    PasswordEncryptorUtil.encrypt(user.getPassword()), true,
                    PasswordEncryptorUtil.encrypt(new Date().toString()));
            statusBean.setStatus(Status.SUCCESSFUL);
            statusBean.setMessage("User Created Successfully");
            LOGGER.info(statusBean.toString());
            return statusBean;
        } else {
            statusBean.setStatus(Status.UNSUCCESSFUL);
            statusBean.setMessage(getFailureReason(user, existingUser.get(0)));
            LOGGER.warn("User Already Exists:" + statusBean);
            return statusBean;
        }
    }

    /**
     * The following method prepares the Create user violation message.
     * 
     * @param user
     * @param existingUser
     * @return
     */
    private String getFailureReason(User user, User existingUser) {
        if (user.getUserId().equalsIgnoreCase(existingUser.getUserId())) {
            return "UserId Already Exists.";
        }
        if (user.getUserMobile().equalsIgnoreCase(existingUser.getUserMobile())) {
            return "Mobile Number Already Registered.";
        }
        if (user.getUserEmail().equalsIgnoreCase(existingUser.getUserEmail())) {
            return "Email-Id already registered.";
        } else {
            return "Unkonwn Reason";
        }
    }

}
