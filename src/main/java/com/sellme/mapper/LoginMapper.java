package com.sellme.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.sellme.domain.Login;

public class LoginMapper implements ResultSetMapper<Login> {

    @Override
    public Login map(int arg0, ResultSet resultSet, StatementContext arg2)
            throws SQLException {
        Login login = new Login();
        login.setUserId(resultSet.getString("user_id"));
        login.setUserPassword(resultSet.getString("user_password"));
        login.setLoginStatus(resultSet.getInt("user_login_status"));
        login.setSessionToken(resultSet.getString("user_session_token"));
        return login;
    }

}
