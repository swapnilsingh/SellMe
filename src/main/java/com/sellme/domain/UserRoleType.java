/**
 * 
 */
package com.sellme.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Swapnil Singh
 *
 */
@JsonFormat(shape= JsonFormat.Shape.OBJECT)
public enum UserRoleType {
ADMIN(1),
RETAILER(2),
CUSTOMER(3);
private int value;
private UserRoleType(int value){
    setValue(value);
}
public final int getValue() {
    return value;
}
public final void setValue(int value) {
    this.value = value;
}

}
