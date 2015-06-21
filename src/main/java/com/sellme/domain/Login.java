/**
 *
 */
package com.sellme.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Swapnil Singh
 *
 */
public class Login {

    private String userId;
    private String userPassword;
    private int loginStatus;
    private String sessionToken;

    @JsonProperty
    public final String getUserId() {
        return userId;
    }

    public final void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty
    public final String getUserPassword() {
        return userPassword;
    }

    public final void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @JsonIgnore
    public int getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }

    @JsonProperty
    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    @Override
    public String toString() {
        return "Login [userId=" + userId + "]";
    }

}
