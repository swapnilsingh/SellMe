/**
 *
 */
package com.sellme.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Swapnil Singh
 *
 */
public enum UserSubscriptionType {
    FREE(1), MONTHLY(2), QUATERLY(3), HALF_YEARLY(4), ANNUAL(5), UNKNOWN_USER_SUBSCRIPTION_TYPE;
    private int value;

    private UserSubscriptionType(int value) {
        this.value = value;
    }

    private UserSubscriptionType() {
    }

    public static UserSubscriptionType getUserSubscriptionType(int value) {
        UserSubscriptionType userSubscriptionType = UserSubscriptionType.UNKNOWN_USER_SUBSCRIPTION_TYPE;
        for (UserSubscriptionType subscriptionType : values()) {
            if (subscriptionType.value == value) {
                userSubscriptionType = subscriptionType;
            }
        }
        return userSubscriptionType;
    }

    public static Date getSubscriptionEndDate(Date subscriptionStartDate,
            UserSubscriptionType userSubscriptionType) {
        Date subscritpionEndDate = null;
        switch (userSubscriptionType) {
        case FREE:
            break;
        case MONTHLY:
            subscritpionEndDate = getDateAfterMonth(subscriptionStartDate, 1);
            break;
        case QUATERLY:
            subscritpionEndDate = getDateAfterMonth(subscriptionStartDate, 3);
            break;
        case HALF_YEARLY:
            subscritpionEndDate = getDateAfterMonth(subscriptionStartDate, 6);
            break;
        case ANNUAL:
            subscritpionEndDate = getDateAfterMonth(subscriptionStartDate, 12);
            break;
        default:
            subscritpionEndDate = null;
            break;
        }
        return subscritpionEndDate;
    }

    public final int getValue() {
        return value;
    }

    private static Date getDateAfterMonth(Date subscriptionStartDate, int month) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(subscriptionStartDate);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }
}
