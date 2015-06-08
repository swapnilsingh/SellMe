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
HALFYEARLY(4),
ANNUAL(5);
private int value;
private UserSubscriptionType(int value){
    setValue(value);
}
public final int getValue() {
    return value;
}
public final void setValue(int value) {
    this.value = value;
}
}
