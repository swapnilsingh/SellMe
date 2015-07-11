/**
 *
 */
package com.sellme.domain;

import java.util.Date;

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
    private long state;
    private long cityOrTown;
    private int country;
    private String password;
    private Date userCreationDate = new Date();
    private Date userSubscriptionEndDate;

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

    @JsonProperty
    public final long getState() {
        return state;
    }

    public final void setState(long state) {
        this.state = State.getStateType(state).getStateCode();
    }

    @JsonProperty
    public final long getCityOrTown() {
        return cityOrTown;
    }

    public final void setCityOrTown(long cityOrTown) {
        this.cityOrTown = CityOrTown.getCityOrTownType(cityOrTown)
                .getCityOrTownCode();
    }

    @JsonProperty
    public final int getCountry() {
        return country;
    }

    public final void setCountry(int country) {
        this.country = Country.getCountryType(country).getCountryCode();
    }

    @JsonProperty
    public final String getPassword() {
        return password;
    }

    public final void setPassword(String password) {
        this.password = password;
    }
    
    @JsonProperty
    public Date getUserCreationDate() {
        return userCreationDate;
    }

    public void setUserCreationDate(Date userCreationDate) {
        this.userCreationDate = userCreationDate;
    }

    @JsonProperty
    public Date getUserSubscriptionEndDate() {
        return userSubscriptionEndDate;
    }

    public void setUserSubscriptionEndDate(Date userSubscriptionEndDate) {
        this.userSubscriptionEndDate = userSubscriptionEndDate;
    }
    
    @JsonProperty
    public void setUserSubscriptionDate(){
        setUserSubscriptionEndDate(UserSubscriptionType.getSubscriptionEndDate(
                this.getUserCreationDate(),
                UserSubscriptionType.getUserSubscriptionType(this
                        .getUserSubscriptionType())));
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
