/**
 *
 */
package com.sellme.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
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
    @SqlUpdate("INSERT INTO sellme_db.user_master (user_id, user_role, user_status, user_name, user_address, user_subscription_type, user_email, user_mobile,user_country,user_state,user_city_town) VALUES (:userId, :userRoleType, :userStatus, :userName, :userAddress, :userSubscriptionType, :userEmail, :userMobile,:country,:state,:cityOrTown);")
    void createUser(@BindBean User user);

    /**
     * The following method will return the existing user for the passed parameters.
     * @param user
     * @return
     */
    @SqlQuery("SELECT user_id, user_role, user_status, user_name, user_address, user_subscription_type, user_email, user_mobile, user_country, user_state, user_city_town FROM sellme_db.user_master WHERE user_id=:userId OR user_mobile=:userMobile OR user_email=:userEmail")
    @Mapper(UserMapper.class)
    List<User> getUserByUserIdOrMobileNumberOrEmail(@BindBean User user);

    /**
     * @param login
     */
    @SqlUpdate("INSERT INTO sellme_db.login (user_id,user_password,user_login_status,user_session_token) VALUES ( :userId , :password , :loginStatus , :sessionToken )")
    void createLogin(@Bind("userId") String userId,@Bind("password") String password,@Bind("loginStatus") boolean loginStatus,@Bind("sessionToken") String sessionToken);

}
