/**
 *
 */
package com.sellme.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Swapnil Singh
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserRoleType {
    ADMIN(1), RETAILER(2), CUSTOMER(3), UNKNOWN_USER_ROLE_TYPE;
    private int value;

    private UserRoleType(int value) {
        this.value = value;
    }

    private UserRoleType() {
    }

    public static UserRoleType getUserRoleType(int value) {
        UserRoleType userRoleType = UserRoleType.UNKNOWN_USER_ROLE_TYPE;
        for (UserRoleType roleType : values()) {
            if (roleType.value == value) {
                userRoleType = roleType;
            }
        }
        return userRoleType;
    }
    public static boolean isValidUserRoleType(int value){
        boolean isvalidRole = false;
        for(UserRoleType userRoleType:values()){
            if(userRoleType.value==value){
                isvalidRole=true;
            }
        }
        return isvalidRole;
    }

    public final int getValue() {
        return value;
    }
}
