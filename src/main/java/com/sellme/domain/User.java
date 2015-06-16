/**
 * 
 */
package com.sellme.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Swapnil Singh
 *
 */
public class User {

    private String userId;
    private boolean userStatus;
    private UserRoleType userRoleType;
    private UserDetails userDetails;
    
    /**
     * 
     */
    public User() {
    }
    /**
     * @param userId
     * @param userStatus
     * @param userRoleType
     * @param userDetails
     */
    public User(String userId, boolean userStatus, int userRoleType,
            UserDetails userDetails) {
        this.userId = userId;
        this.userStatus = userStatus;
        this.userRoleType = UserRoleType.getUserRoleType(userRoleType);
        this.userDetails = userDetails;
    }
    @JsonProperty
    public final String getUserId() {
        return userId;
    }
    public final void setUserId(String userId) {
        this.userId = userId;
    }
    @JsonProperty
    public final boolean isUserStatus() {
        return userStatus;
    }
    public final void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }
    @JsonProperty
    public final UserRoleType getUserRoleType() {
        return userRoleType;
    }
    public final void setUserRoleType(int userRoleType) {
        this.userRoleType = UserRoleType.getUserRoleType(userRoleType);
    }
    public final UserDetails getUserDetails() {
        return userDetails;
    }
    public final void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
    @Override
    public String toString() {
        return "User [userId=" + userId + ", userStatus=" + userStatus
                + ", userRoleType=" + userRoleType + ", userDetails="
                + userDetails + "]";
    }
    
}
