/**
 * 
 */
package com.sellme.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sellme.core.SellMeConfiguration;
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
    private SellMeConfiguration sellMeConfiguration;

    /**
     * @param userDAO
     * @param sellMeConfiguration
     */
    public UserService(UserDAO userDAO, SellMeConfiguration sellMeConfiguration) {
        this.userDAO = userDAO;
        this.sellMeConfiguration = sellMeConfiguration;
    }

    /**
     * The following method will create the user.
     * 
     * @param user
     */
    public void createUser(User user) {
        LOGGER.info("Inserting User into database");
        this.userDAO.createUser(user);
    }

}
