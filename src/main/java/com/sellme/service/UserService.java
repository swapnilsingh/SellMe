package com.sellme.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sellme.dao.UserDAO;
import com.sellme.domain.User;

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
    public void createUser(User user) {
        LOGGER.info("Calling UserDao");
        this.userDAO.createUser(user);
    }

}
