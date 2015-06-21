/**
 * 
 */
package com.sellme.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.sellme.domain.Login;
import com.sellme.mapper.LoginMapper;

/**
 * @author Swapnil Singh
 *
 */
public interface LoginDAO {

    @SqlQuery("SELECT user_id , user_password, user_login_status , user_session_token from sellme_db.login WHERE user_id = :userId")
    @Mapper(LoginMapper.class)
    public List<Login> getLoginDetailsByUserId(@Bind("userId") String userId);

    @SqlQuery("SELECT user_status FROM sellme_db.user_master WHERE user_id = :userId")
    public int isUserActive(@Bind("userId") String userId);

    /**
     * @param userId
     */
    @SqlUpdate("UPDATE sellme_db.login SET user_login_status=1, user_session_token = :sessionToken WHERE user_id=:userId")
    public void signInUser(@Bind("userId") String userId,
            @Bind("sessionToken") String sessionToken);

}
