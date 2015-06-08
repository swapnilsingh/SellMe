/**
 * 
 */
package com.sellme.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Swapnil Singh
 *
 */
public class UserDetails {

    private String userName;
    private String userAddress;
    private UserSubscriptionType userSubscriptionType;
    private String userEmail;
    private String userMobile;
    
    /**
     * 
     */
    public UserDetails() {
    }
    /**
     * @param userName
     * @param userAddress
     * @param userSubscriptionType
     * @param userEmail
     * @param userMobile
     */
    public UserDetails(String userName, String userAddress,
            UserSubscriptionType userSubscriptionType, String userEmail,
            String userMobile) {
        this.userName = userName;
        this.userAddress = userAddress;
        this.userSubscriptionType = userSubscriptionType;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
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
    public final UserSubscriptionType getUserSubscriptionType() {
        return userSubscriptionType;
    }
    public final void setUserSubscriptionType(
            UserSubscriptionType userSubscriptionType) {
        this.userSubscriptionType = userSubscriptionType;
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
    @Override
    public String toString() {
        return "UserDetails [userName=" + userName + ", userAddress="
                + userAddress + ", userSubscriptionType="
                + userSubscriptionType + ", userEmail=" + userEmail
                + ", userMobile=" + userMobile + "]";
    }
    
}
