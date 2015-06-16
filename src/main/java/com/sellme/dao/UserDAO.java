package com.sellme.dao;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import com.sellme.domain.User;

/**
 * @author Swapnil Singh
 *
 */
public interface UserDAO {

    /**
     * The following method will insert User into the database.
     *
     * @param userid
     * @param userRoleType
     * @param userStatus
     * @param userName
     * @param userAddress
     * @param userSubscriptionType
     * @param userEmail
     * @param userMobile
     */
    @SqlUpdate("INSERT INTO sellme_db.user_master (userid, user_role, user_status, user_name, user_address, user_subscription_type, user_email, user_mobile) VALUES (:userId, :userRoleType, :userStatus, :userName, :userAddress, :userSubscriptionType, :userEmail, :userMobile);")
    void createUser(@BindBean User user);

}
