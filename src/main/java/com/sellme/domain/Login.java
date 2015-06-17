/**
 *
 */
package com.sellme.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Swapnil Singh
 *
 */
public class Login {

    private String userId;
    private String userPassword;

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

    @Override
    public String toString() {
        return "Login [userId=" + userId + "]";
    }

}
