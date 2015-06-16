/**
 * 
 */
package com.sellme.domain;

/**
 * @author Swapnil Singh
 *
 */
public enum UserSubscriptionType {
FREE(1),
MONTHLY(2),
QUATERLY(3),
HALF_YEARLY(4),
ANNUAL(5),
UNKNOWN_USER_SUBSCRIPTION_TYPE;
private int value;
private UserSubscriptionType(int value){
	this.value = value;
}
private UserSubscriptionType(){}
public static UserSubscriptionType getUserSubscriptionType(int value){
	UserSubscriptionType userSubscriptionType = UserSubscriptionType.UNKNOWN_USER_SUBSCRIPTION_TYPE;
	for(UserSubscriptionType subscriptionType :values()){
		if(subscriptionType.value==value){
			userSubscriptionType=subscriptionType;
		}
	}
	return userSubscriptionType;
}
public final int getValue() {
    return value;
}
}
