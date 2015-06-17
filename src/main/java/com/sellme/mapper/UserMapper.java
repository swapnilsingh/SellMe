/**
 *
 */
package com.sellme.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.sellme.domain.User;

/**
 * @author Swapnil Singh
 *
 */
public class UserMapper implements ResultSetMapper<User> {

    /*
     * (non-Javadoc)
     *
     * @see org.skife.jdbi.v2.tweak.ResultSetMapper#map(int, java.sql.ResultSet,
     * org.skife.jdbi.v2.StatementContext)
     */
    @Override
    public User map(int arg0, ResultSet resultSet, StatementContext arg2)
            throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getString("userid"));
        user.setUserRoleType(resultSet.getInt("user_role"));
        user.setUserStatus(resultSet.getBoolean("user_status"));
        user.setUserName(resultSet.getString("user_name"));
        user.setUserAddress(resultSet.getString("user_address"));
        user.setUserSubscriptionType(resultSet.getInt("user_subscription_type"));
        user.setUserEmail(resultSet.getString("user_email"));
        user.setUserMobile(resultSet.getString("user_mobile"));
        user.setCountry(resultSet.getInt("user_country"));
        user.setState(resultSet.getLong("user_state"));
        user.setCityOrTown(resultSet.getLong("user_city_town"));
        return user;
    }

}
