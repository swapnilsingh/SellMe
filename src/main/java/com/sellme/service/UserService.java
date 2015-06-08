/**
 * 
 */
package com.sellme.service;

import com.sellme.core.SellMeConfiguration;
import com.sellme.dao.UserDAO;
import com.sellme.domain.User;

/**
 * @author Swapnil Singh
 *
 */
public class UserService {

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
     * @param user
     */
    public void createUser(User user){
        this.userDAO.createUser();
    }
    
}
