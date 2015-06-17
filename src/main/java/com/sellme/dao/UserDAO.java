/**
 *
 */
package com.sellme.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.sellme.domain.User;
import com.sellme.mapper.UserMapper;

/**
 * @author Swapnil Singh
 *
 */
public interface UserDAO {

    /**
     * The following method inserts User JSON into the database.
     * @param user
     */
    @SqlUpdate("INSERT INTO sellme_db.user_master (userid, user_role, user_status, user_name, user_address, user_subscription_type, user_email, user_mobile) VALUES (:userId, :userRoleType, :userStatus, :userName, :userAddress, :userSubscriptionType, :userEmail, :userMobile);")
    void createUser(@BindBean User user);

    /**
     * The following method will return the existing user for the passed parameters.
     * @param user
     * @return
     */
    @SqlQuery("SELECT userid, user_role, user_status, user_name, user_address, user_subscription_type, user_email, user_mobile FROM sellme_db.user_master WHERE userid=:userId OR user_mobile=:userMobile OR user_email=:userEmail")
    @Mapper(UserMapper.class)
    List<User> getUserByUserIdOrMobileNumberOrEmail(@BindBean User user);

}
