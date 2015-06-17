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
public class User {

    private String userId;
    private boolean userStatus;
    private int userRoleType;
    private String userName;
    private String userAddress;
    private int userSubscriptionType;
    private String userEmail;
    private String userMobile;

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
    public final int getUserRoleType() {
        return userRoleType;
    }

    public final void setUserRoleType(int userRoleType) {
        this.userRoleType = UserRoleType.getUserRoleType(userRoleType)
                .getValue();
    }

    @JsonProperty
    public final String getUserName() {
        return userName;
    }

    public final void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty
    public final String getUserAddress() {
        return userAddress;
    }

    public final void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @JsonProperty
    public final int getUserSubscriptionType() {
        return userSubscriptionType;
    }

    public final void setUserSubscriptionType(int userSubscriptionType) {
        this.userSubscriptionType = UserSubscriptionType
                .getUserSubscriptionType(userSubscriptionType).getValue();
    }

    @JsonProperty
    public final String getUserEmail() {
        return userEmail;
    }

    public final void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @JsonProperty
    public final String getUserMobile() {
        return userMobile;
    }

    public final void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    @JsonIgnore
    public int getUserStatus() {
        return isUserStatus() ? 1 : 0;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userStatus=" + userStatus
                + ", userRoleType=" + userRoleType + ", userName=" + userName
                + ", userAddress=" + userAddress + ", userSubscriptionType="
                + userSubscriptionType + ", userEmail=" + userEmail
                + ", userMobile=" + userMobile + "]";
    }

}
